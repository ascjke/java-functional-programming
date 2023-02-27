package ru.borisov.functionalinterfaces.standardfunctions;

import java.util.function.BinaryOperator;
import java.util.function.DoubleUnaryOperator;
import java.util.function.UnaryOperator;

public class Operators {

    public static void main(String[] args) {

        // Integer to Integer operator
        UnaryOperator<Integer> multiplierBy10 = n -> n * 10;
        System.out.println(multiplierBy10.apply(20)); // 200
        System.out.println(multiplierBy10.apply(-1)); // -10

        // (String, String) to String operator
        BinaryOperator<String> spacedAppender = (str1, str2) -> str1 + " " + str2;
        System.out.println(spacedAppender.apply("Hello", "World")); // prints "Hello World"

        // double to double operator
        DoubleUnaryOperator expression = n -> Math.sqrt(n) * 2;
        System.out.println(expression.applyAsDouble(9.0)); // sqrt(9.0) * 2 = 6.0
    }
}
