package ru.borisov.functionalinterfaces.composing;

import java.util.function.Function;

public class FunctionComposing {

    public static void main(String[] args) {

        Function<Integer, Integer> mult2 = x -> x * 2;
        Function<Integer, Integer> square = x -> x * x;

        // square(mult2(3)) = 36
        System.out.println(square.compose(mult2).apply(3)); // 36

        // mult2(square(3)) = 18
        System.out.println(square.andThen(mult2).apply(3)); // 18
    }
}
