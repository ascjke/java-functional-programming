package ru.borisov.functionalinterfaces.standardfunctions;

import java.time.LocalDate;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import java.util.function.Supplier;

public class Suppliers {

    public static void main(String[] args) {

        Supplier<String> helloSupplier = () -> "Hello";
        System.out.println(helloSupplier.get()); // "Hello"

        Supplier<LocalDate> todaySupplier = LocalDate::now;
        System.out.println(todaySupplier.get()); // 2021-05-15 or something else

        BooleanSupplier booleanSupplier = () -> true;
        System.out.println(booleanSupplier.getAsBoolean()); // true

        DoubleSupplier randomGenerator = Math::random;
        System.out.println(randomGenerator.getAsDouble()); // 0.11253 or something else

        /**
         * At the first glance, it might seem like suppliers are useless, but it’s a false impression.
         * Suppliers can produce values depending on some internal conditions of the program or just take data from
         * external sources like collections, files or databases. For example, the following supplier
         * helps us iterate over a queue.
         */
        Queue<Integer> list = new ArrayDeque<>(List.of(1, 2, 3, 4));
        Supplier<Integer> supplier = list::poll;

        System.out.println(supplier.get()); // 1
        System.out.println(supplier.get()); // 2
        System.out.println(supplier.get()); // 3
        System.out.println(supplier.get()); // 4
        System.out.println(supplier.get()); // null
    }
}
