package ru.borisov.streams.filtering;

import java.util.stream.Stream;

public class Java9TakeWhile {

    public static void main(String[] args) {

        // Here, the takeWhile method stops after taking the element 0 as the condition becomes false. So, the result includes only four elements from the initial stream: 10, 13, 11, 7.
        Stream.of(10, 13, 11, 7, 0, 5, 8, 11)
                .takeWhile(n -> n > 0)
                .forEach(System.out::println); // 10 13 11 7


        // Here, the dropWhile method stops dropping elements after reaching the element 0 as the condition becomes false. The elements 0, 5, 8, 11 remain in the stream.
        Stream.of(10, 13, 11, 7, 0, 5, 8, 11)
                .dropWhile(n -> n > 0)
                .forEach(System.out::println); // 0 5 8 11
    }
}
