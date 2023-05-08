package ru.borisov.streams.grouping;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

class Classifier {

    public static Map<Integer, List<String>> group(List<String> words) {
        return words.stream()
                .collect(groupingBy(String::length));
    }
}
