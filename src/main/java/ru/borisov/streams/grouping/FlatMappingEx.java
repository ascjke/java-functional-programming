package ru.borisov.streams.grouping;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class FlatMappingEx {

    public static void main(String[] args) {

        List<List<String>> values = List.of(
                List.of("1", "2", "3"),
                List.of("green", "yellow", "blue", "red"),
                List.of("g10", "g11", "g12", "g13"),
                List.of("group captain", "general", "major", "admiral")
        );

        Map<Boolean, Long> map = values.stream()
                .filter(l -> l.size() > 3)
                .collect(groupingBy(s -> s.get(0).length() < 4, flatMapping(
                        l -> l.stream().filter(v -> v.contains("g")),
                        counting()
                )));
        System.out.println(map);
    }
}
