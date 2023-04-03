package ru.borisov.streams.filtering;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StreamFiltering {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(26, 78, 30, 17, 11, 34, 42, 80, 16, 55);
        Predicate<Integer> isGreaterThan40 = n -> n > 40;
        Predicate<Integer> isDivisibleBy5 = n -> n % 5 == 0;

        numbers.stream()
                .filter(isGreaterThan40.and(isDivisibleBy5)) // only 80, 55 will pass further
                .forEach(System.out::println);
    }
}
