package ru.borisov.streams.collecting.counting;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CountingEx {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(4, 7, 4, 2, 1, 6, 4);

        System.out.println(numbers.stream().filter(n -> n == 4).collect(Collectors.counting()));
        System.out.println(numbers.stream().collect(Collectors.summingInt(i -> i + 4)));
        System.out.println(Collections.frequency(numbers, 4));
        System.out.println(numbers.stream().filter(n -> n == 4).count());
//        System.out.println(numbers.stream().collect(Collectors.counting(n -> n == 4)));
    }
}
