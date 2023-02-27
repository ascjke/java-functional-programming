package ru.borisov.functionalinterfaces.composing;

import java.util.function.Predicate;

public class XORPredicate {

    public static void main(String[] args) {


    }


    public static <T> Predicate<T> xor(Predicate<T> predicate1, Predicate<T> predicate2) {
        //  XOR == A or B, but not(A and B).
        return t -> predicate1.test(t) ^ predicate2.test(t);
    }
}
