package ru.borisov.streams.grouping;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingEx {

    public static void main(String[] args) {

        List<Tweet2> tweets = List.of(
                new Tweet2("100", "en"),
                new Tweet2("101", "en"),
                new Tweet2("102", "ru"),
                new Tweet2("103", "ru"),
                new Tweet2("104", "es")
        );

        Map<String, List<Tweet2>> tweetsByLang = tweets.stream()
                .collect(Collectors.groupingBy(Tweet2::lang));

        System.out.println(tweetsByLang);

    }
}

record Tweet2 (String id, String lang) {}
