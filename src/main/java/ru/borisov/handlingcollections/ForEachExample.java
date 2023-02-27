package ru.borisov.handlingcollections;

import java.util.List;
import java.util.function.Consumer;

public class ForEachExample {

    public static void main(String[] args) {

        List<Integer> list = List.of(1, 2, 3, 4, 5);
        Consumer<Integer> consumerOdd = n -> {
            if (n % 2 == 0) {
                System.out.println(n);
            }
        };

        Consumer<Integer> consumerEven = n -> {
            if (n % 2 != 0) {
                System.out.println(n);
            }
        };

        list.forEach(consumerOdd);
        System.out.println("***********");
        list.forEach(consumerEven);
    }
}
