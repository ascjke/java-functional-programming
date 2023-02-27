package ru.borisov.functionalinterfaces.standardfunctions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Consumers {

    public static void main(String[] args) {
        // it prints a given string
        Consumer<String> printer = System.out::println; // s -> System.out.println(s)
        printer.accept("!!!"); // !!!
        printer.accept("Hello"); // Hello

        List<Integer> numbers = new ArrayList<>();
        Consumer<Integer> consumer = numbers::add; // it just adds new numbers to the list
        System.out.println(numbers);
        consumer.accept(1);
        consumer.accept(2);
        consumer.accept(3);
        System.out.println(numbers);
    }
}
