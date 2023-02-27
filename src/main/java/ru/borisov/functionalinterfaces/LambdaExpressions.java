package ru.borisov.functionalinterfaces;

import java.util.function.BiFunction;
import java.util.function.Function;

public class LambdaExpressions {
    public static void main(String[] args) {
        Function<Integer, String> plusOne = x -> String.valueOf(x + 1);
        String result = plusOne.apply(1);
        System.out.println(result);

        // a lambda expression without automatic type inference
        Function<Long, Long> mult2 = (Long x) -> x * 2;

        // with a body eclosed in {} we need to use "return" for a result
        Function<String, String> appender = s -> {
            s += " Hello";
            s += " Lambda";
            return s;
        };
        System.out.println(appender.apply("123"));

        Function<String, String> appenderShort = s -> s + " Hello" + " Lambda";
        System.out.println(appenderShort.apply("short"));

        BiFunction<Long, Long, Long> sum = (a, b) -> a + b; // () are required here
        System.out.println(sum.apply(5L, 8L));
    }
}
