package ru.borisov.streams.infinite;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IterateEx {

    public static void main(String[] args) {

        Stream<Integer> infiniteNumbers = Stream.iterate(1, n -> n * 2); // 1, 2, 4, 8, ...

        List<Integer> finiteNumbers = Stream.iterate(1, n -> n * 2)
                .limit(4)
                .collect(Collectors.toList());

        Stream.iterate(1, n -> n < 20, n -> n * 2)
                .forEach(System.out::println); // 1 2 4 8 16

        Stream.iterate(1, n -> n * 2)
                .takeWhile(n -> n < 20)
                .forEach(System.out::println);
        // or

        for (int i = 1; i < 20; i *= 2) {
            System.out.println(i);
        }
    }
}
