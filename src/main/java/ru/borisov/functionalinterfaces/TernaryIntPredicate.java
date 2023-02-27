package ru.borisov.functionalinterfaces;

import java.util.stream.IntStream;

@FunctionalInterface
public interface TernaryIntPredicate {

    boolean test(int a, int b, int c);
}

class TernaryIntPredicateImpl {

    public static final TernaryIntPredicate allValuesAreDifferentPredicate =
            (a, b, c) -> IntStream.of(a, b, c)
                    .distinct()
                    .count() == 3;
}
