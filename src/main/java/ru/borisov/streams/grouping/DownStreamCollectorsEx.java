package ru.borisov.streams.grouping;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class DownStreamCollectorsEx {

    public static void main(String[] args) {

        List<Tweet3> tweets = List.of(
                new Tweet3("100", 1000, "en"),
                new Tweet3("101", 2, "en"),
                new Tweet3("102", 1300, "ru"),
                new Tweet3("103", 22, "fr")
        );

        Map<String, Long> likesPerTweetLanguage = tweets.stream()
                .collect(groupingBy(Tweet3::lang, summingLong(Tweet3::likeCount)));
        System.out.println(likesPerTweetLanguage);


        Map<String, Long> popularTweetCountByLang = tweets.stream()
                .filter(tweet -> tweet.likeCount() > 100)
                .collect(groupingBy(Tweet3::lang, counting()));
        System.out.println(popularTweetCountByLang);


        Map<String, Long> _popularTweetCountByLang = tweets.stream()
                .collect(groupingBy(Tweet3::lang, filtering(
                        tweet -> tweet.likeCount() > 100,
                        counting()
                )));
        System.out.println(_popularTweetCountByLang);


        List<Tweet4> tweet4s = List.of(
                new Tweet4("100", 1000, "en", List.of("Wow!", "So cute")),
                new Tweet4("101", 22, "en", List.of("Take a screenshot", "It's my first comment")),
                new Tweet4("102", 1300, "ru", List.of("Поздравляю!", "Спасибо")),
                new Tweet4("103", 22, "fr", List.of("c'est le meilleur endroit!"))
        );
        Map<String, Long> commentCountPerTweetLang = tweet4s.stream()
                .collect(groupingBy(Tweet4::lang, flatMapping(
                        tweet -> tweet.comments().stream(),
                        counting()
                )));
        System.out.println(commentCountPerTweetLang);

    }
}

record Tweet3(String id, int likeCount, String lang) {
}

record Tweet4(String id, int likeCount, String lang, List<String> comments) {
}