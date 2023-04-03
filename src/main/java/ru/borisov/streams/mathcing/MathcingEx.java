package ru.borisov.streams.mathcing;

import java.util.List;

public class MathcingEx {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(5, 2, 7, 3, 12, 13, 7, 3);
        List<Integer> empty = List.of();

        numbers.stream().anyMatch(n -> n > 10); // true because the list contains 12 and 13
        numbers.stream().anyMatch(n -> n > 15); // false
        empty.stream().anyMatch(n -> n > 10);   // false

        numbers.contains(7); // true
        numbers.stream().anyMatch(n -> n == 7); // true

        numbers.stream().allMatch(n -> n > 0);  // true because all elements > 0
        numbers.stream().allMatch(n -> n < 10); // false, because not all elements < 10
        empty.stream().allMatch(n -> n < 10);   // true, you may be surprised!

        numbers.stream().noneMatch(n -> n > 0);  // false, all elements > 0
        numbers.stream().noneMatch(n -> n > 20); // true, because there are no elements > 20
        empty.stream().noneMatch(n -> n > 10);   // true
    }
}
