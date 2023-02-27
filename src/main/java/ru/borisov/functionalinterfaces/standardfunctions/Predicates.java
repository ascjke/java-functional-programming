package ru.borisov.functionalinterfaces.standardfunctions;

import java.time.LocalTime;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class Predicates {

    public static void main(String[] args) {

        // String to boolean
        Predicate<String> startsWithDigit = s -> !s.isEmpty() && Character.isDigit(s.charAt(0));

        System.out.println(startsWithDigit.test("1st"));   // true
        System.out.println(startsWithDigit.test("Hello")); // false
        System.out.println(startsWithDigit.test(""));      // false

        // int to boolean predicate
        IntPredicate isEven = val -> val % 2 == 0;

        System.out.println(isEven.test(10)); // true
        System.out.println(isEven.test(11)); // false

        Predicate<LocalTime> isLunchTime =
                time -> time.isAfter(LocalTime.of(12, 0))
                        && time.isBefore(LocalTime.of(14, 0));

        // ...

        // somewhere else in the program

        LocalTime currentTime = LocalTime.now();
        System.out.println(currentTime);
        if (isLunchTime.test(currentTime)) {
            System.out.println("It is time for lunch!");
        } else {
            System.out.println("No time for lunch!");
        }
    }
}
