package ru.borisov.functionalinterfaces.standardfunctions;

import java.util.function.BiFunction;
import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class Functions {

    public static void main(String[] args) {

        // String to Integer function with the apply method
        Function<String, Integer> lengthFunction = String::length;
        int len = lengthFunction.apply("Hello!"); // 6

    // (Integer, Integer) to Integer function with the apply method
        BiFunction<Integer, Integer, Integer> sum = (a, b) -> a + b;
        int result = sum.apply(20, 30); // 50

    // String to int function with the applyAsInt method
        ToIntFunction<String> converter = Integer::parseInt;
        int thousand = converter.applyAsInt("1000"); // 1000

    // Double to Long function
        DoubleFunction<Long> rounding = Math::round;
        long value = rounding.apply(10.02); // 10
    }
}
