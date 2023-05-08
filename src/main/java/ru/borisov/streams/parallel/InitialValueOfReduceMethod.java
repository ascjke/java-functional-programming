package ru.borisov.streams.parallel;

import java.util.List;

public class InitialValueOfReduceMethod {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3);
        int result = numbers.stream().reduce(100, Integer::sum);
        System.out.println(result);

        int result1 = List.of(1, 2, 3).parallelStream().reduce(100, Integer::sum);
        System.out.println(result1); // 306

        int result2 = List.of(1, 2, 3, 4, 5).parallelStream().reduce(100, Integer::sum);
        System.out.println(result2); // 515

        // To sum it up, when using a parallel stream, use only a neutral element
        // (0 for summing, 1 for multiplication, and so on) as the initial value in the reduce method. I
        // t is better to do the same with sequential streams too.
        int result3 = List.of(1, 2, 3, 4, 5).parallelStream().reduce(0, Integer::sum) + 100;
        System.out.println(result3); // 115
    }
}
