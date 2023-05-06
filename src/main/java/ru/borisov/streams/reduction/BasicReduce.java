package ru.borisov.streams.reduction;

import java.util.List;

public class BasicReduce {

    public static void main(String[] args) {

        List<Integer> spendings = List.of(14, 22, 10, 18, 16, 15, 20);
        int total = spendings.stream()
                .reduce((partialSum, next) -> partialSum + next)
                .orElse(0);
        System.out.println(total);

        // Identity
        // with a lambda expression
        int total2 = spendings.stream().reduce(0, (partialSum, next) -> partialSum + next); // Now, the initial value of the partialSum is 0 and the first result of reduction is 0 + 14 = 14
        System.out.println(total2);
    }
}
