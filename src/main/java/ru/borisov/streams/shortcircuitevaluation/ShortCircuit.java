package ru.borisov.streams.shortcircuitevaluation;

import java.util.stream.Stream;

public class ShortCircuit {

    public static void main(String[] args) {

        int result = Stream.of(1, 2, 3, 4, 5)
                .peek(System.out::println)
                .filter(n -> n >= 3)
                .findFirst()
                .get();
        System.out.println("Result: " + result);


        boolean resultBoolean = Stream.of(1, 2, 3, 4, 5)
                .peek(System.out::println)
                .allMatch(n -> n < 3);

        System.out.println("Result: " + resultBoolean); // false
    }
}
