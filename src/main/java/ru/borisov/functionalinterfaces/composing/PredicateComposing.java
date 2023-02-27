package ru.borisov.functionalinterfaces.composing;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class PredicateComposing {

    public static void main(String[] args) {

//        IntPredicate isEven = n -> n % 2 == 0; // it's true for 0, 2, 4, 6, 8 and so on
//
//        System.out.println(isEven.test(10)); // true
//        System.out.println(isEven.test(11)); // false
//
//        IntPredicate lessThan11 = n -> n < 11; // it's true for all numbers < 11
//
//        System.out.println(lessThan11.test(10)); // true
//        System.out.println(lessThan11.test(11)); // false
//
//        ////////////////////
//
//        IntPredicate isOdd = isEven.negate(); // it's true for 1, 3, 5, 7, 9 and so on
//
//        System.out.println(isOdd.test(10));  // false
//        System.out.println(isOdd.test(11));  // true
//
//        ///////////////////
//
//        IntPredicate isOddOrLessThan11 = isOdd.or(lessThan11);
//
//        System.out.println(isOddOrLessThan11.test(10)); // true
//        System.out.println(isOddOrLessThan11.test(11)); // true
//        System.out.println(isOddOrLessThan11.test(12)); // false
//        System.out.println(isOddOrLessThan11.test(13)); // true
//
//        IntPredicate isOddAndLessThan11 = isOdd.and(lessThan11);
//
//        System.out.println(isOddAndLessThan11.test(8));  // false
//        System.out.println(isOddAndLessThan11.test(9));  // true
//        System.out.println(isOddAndLessThan11.test(10)); // false
//        System.out.println(isOddAndLessThan11.test(11)); // false

        /////////////////////////////

        Predicate<Character> isLetter = Character::isLetter;
        Predicate<Character> isUpperCase = Character::isUpperCase;

        Predicate<Character> predicate = isLetter.and(isUpperCase.negate());

        System.out.println(predicate.test('1')); // false
        System.out.println(predicate.test('3')); // false
        System.out.println(predicate.test('c')); // true
        System.out.println(predicate.test('D')); // false
        System.out.println(predicate.test('e')); // true
        System.out.println(predicate.test('Q')); // false

    }
}
