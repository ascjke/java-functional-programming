package ru.borisov.functionalinterfaces.composing;

import java.util.function.Consumer;

public class ConsumerComposing {

    public static void main(String[] args) {

        Consumer<String> consumer = System.out::println;
        Consumer<String> doubleConsumer = consumer.andThen(System.out::println);
        doubleConsumer.accept("Hi!");
    }
}
