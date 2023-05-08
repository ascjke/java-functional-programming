package ru.borisov.curryingfunctions;

import java.util.function.BiFunction;
import java.util.function.Function;

public class CurryingEx {

    public static void main(String[] args) {

        BiFunction<Integer, Integer, Integer> f1 =
                (first, second) -> first % second; // not curried function

        Function<Integer, Function<Integer, Integer>> f2 =
                first -> second -> first + second; // curried function
        // first == Integer
        // second == result of Function


        // Let's look at an example and start with a simple function that accepts two arguments: prefix and value and returns a String value:
        BiFunction<String, String, String> addPrefix = (prefix, value) ->
                String.format("[%s] %s", prefix, value);

        addPrefix.apply("y", "Confirm");   // [y] Confirm
        addPrefix.apply("y", "Cancel");    // [y] Cancel
        addPrefix.apply("y", "Terminate"); // [y] Terminate

        Function<String, Function<String, String>> addPrefixCurrying = prefix -> value ->
                String.format("[%s] %s", prefix, value);

        Function<String, String> addYPrefix = addPrefixCurrying.apply("y");
        addYPrefix.apply("Confirm");   // [y] Confirm
        addYPrefix.apply("Cancel");    // [y] Cancel
        addYPrefix.apply("Terminate"); // [y] Terminate

        Function<String, String> addNPrefix = addPrefixCurrying.apply("n");
        addNPrefix.apply("Update"); // [n] Update

    }
}
