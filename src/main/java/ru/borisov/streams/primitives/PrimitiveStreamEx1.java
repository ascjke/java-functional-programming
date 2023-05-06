package ru.borisov.streams.primitives;

import java.util.stream.IntStream;

public class PrimitiveStreamEx1 {

    public static void main(String[] args) {

        IntStream.of(1, 2, 3, 4, 5)
                .filter(n -> n > 2)
                .forEach(System.out::println);

        int[] array = IntStream.of(1, 2, 3, 4, 5)
                .filter(n -> n > 2)
                .toArray();
    }
}
