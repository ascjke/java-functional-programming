package ru.borisov.streams.parallel;

import java.util.List;
import java.util.function.Function;

public class OrderOfElements {

    public static void main(String[] args) {

        List<Integer> sortedNumbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        sortedNumbers.stream()
                .map(Function.identity()) // some processing
                .forEach(n -> System.out.print(n + " "));

        System.out.println("\n**************************************");

        sortedNumbers.parallelStream()
                .map(Function.identity()) // some processing
                .forEach(n -> System.out.print(n + " "));

        System.out.println("\n**************************************");

        sortedNumbers.parallelStream()
                .map(Function.identity()) // some processing
                .forEachOrdered(n -> System.out.print(n + " ")); // forEachOrdered decrease performance
    }
}
