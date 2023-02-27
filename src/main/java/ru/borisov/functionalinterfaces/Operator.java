package ru.borisov.functionalinterfaces;

import java.util.function.BiFunction;

class Operator {

    // assign a lambda expression to this variable
    static BiFunction<Integer, Integer, Integer> function = (x, y) -> Math.min(x, y);
}
