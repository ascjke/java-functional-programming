package ru.borisov.functionalinterfaces;

import java.util.function.Function;

public class Closures {

    public static void main(String[] args) {

        final String hello = "Hello, "; // final local variable
        Function<String, String> helloFunction = name -> hello + name;

        System.out.println(helloFunction.apply("John"));  // Hello, John
        System.out.println(helloFunction.apply("Emily")); // Hello, Emily

        int n = 10; // effectively final variable
        Function<Integer, Integer> adder10 = x -> x + n;

        System.out.println(adder10.apply(20)); // 30
        System.out.println(adder10.apply(30)); // 40
    }
}
