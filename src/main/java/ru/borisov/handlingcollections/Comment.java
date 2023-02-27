package ru.borisov.handlingcollections;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public record Comment(Date created, String text) {
}

class CommentUtils {

    public static final SimpleDateFormat TEXT_FORMATTER = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    public static void main(String[] args) throws ParseException {
        List<Comment> comments = new ArrayList<>();

        comments.add(new Comment(
                CommentUtils.TEXT_FORMATTER.parse("14-03-2020 10:20:34"),
                "What a beautiful photo! Where is it?"
        ));
        comments.add(new Comment(
                CommentUtils.TEXT_FORMATTER.parse("16-03-2020 15:35:18"),
                "I do not know, I just found it on the internet!"
        ));
        comments.add(new Comment(
                CommentUtils.TEXT_FORMATTER.parse("20-03-2020 19:10:22"),
                "Is anyone here?"
        ));

        Date threshold = CommentUtils.TEXT_FORMATTER.parse("15-03-2020 00:00:00");
        int maxTextLength = 30; // it is just an example, do not rely on this number!

        CommentUtils.handleComments(comments, threshold, maxTextLength);
        CommentUtils.printComments(comments);
    }


    /**
     * An example string that fits the format "15-03-2020 10:20:34".
     * Use it to print the comments.
     */


    private CommentUtils() {
    }

    /**
     * It processes a given list of comments by removing old comments and shortening the text length
     */
    public static void handleComments(List<Comment> comments, Date thresholdDate, int maxTextLength) {
        comments.removeIf(c -> c.created().before(thresholdDate));
        comments.replaceAll(comment -> new Comment(comment.created(),
                comment.text().substring(0, Math.min(comment.text().length(), maxTextLength))));
    }

    /**
     * It prints each comment in the following format:
     * [14-03-2020 10:20:34] What a beautiful photo! Where is it?
     * [16-03-2020 15:35:18] I do not know, I just found it on the internet!
     * [20-03-2020 19:10:22] Is anyone here?
     * Please, use the formatter above to fit the format.
     */
    public static void printComments(List<Comment> comments) {
        comments.forEach(c -> System.out.println("[" + TEXT_FORMATTER.format(c.created()) + "] " + c.text()));
    }
}
