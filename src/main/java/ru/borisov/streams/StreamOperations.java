package ru.borisov.streams;

import java.util.List;

public class StreamOperations {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 4, 8, 3, 7, 5, 4, 3); // 8 elements

        long numberOfUniqueElements = numbers.stream() // 1 4 8 3 7 5 4 3
                .distinct()
                .peek(System.out::println) // 1 4 8 3 7 5, peek() shows intermediate results
                .count();

        System.out.println("Result: " + numberOfUniqueElements); // Result: 6
    }
}
