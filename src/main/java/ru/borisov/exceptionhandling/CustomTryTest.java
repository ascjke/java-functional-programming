package ru.borisov.exceptionhandling;

public class CustomTryTest {

    public static void main(String[] args) {

//        Try<Integer> tryParseSuccess = Try.of(() -> Integer.parseInt("23")); // Success[23]
//        System.out.println(tryParseSuccess);
//        System.out.println(tryParseSuccess.isSuccess()); // true
//        System.out.println(tryParseSuccess.getUnchecked()); // 23
//        System.out.println(tryParseSuccess.toOptional().isEmpty()); // false

//        Try<Integer> tryParseFailure = Try.of(() -> Integer.parseInt("V23")); // Failure[java.lang.NumberFormatException: For input string: "V23"]
//        System.out.println(tryParseFailure);
//        System.out.println(tryParseFailure.isSuccess()); // false
//        System.out.println(tryParseFailure.toOptional().isEmpty()); // true
//        System.out.println(tryParseFailure.getUnchecked()); // throws a RuntimeException that wraps the initial one
//
//        int n = 100;
//        Try<Integer> division = Try.of(() -> n / 0); // Failure[java.lang.ArithmeticException: / by zero]
//        System.out.println(division);

//        Try<Integer> tryParse = Try.of(() -> Integer.parseInt("100")); // Success[100]
//        System.out.println(tryParse.getOrElse(200)); // 100
//        System.out.println(tryParse.getOrElseSupply(() -> 10 * 20 * 30)); // 100
//        System.out.println(tryParse.getOrElseThrow(IllegalArgumentException::new)); // 100

//        Try<Integer> tryParse = Try.of(() -> Integer.parseInt("100K"));
//        System.out.println(tryParse.getOrElse(0)); // 0
//        System.out.println(tryParse.getOrElseSupply(() -> 10 * 20 * 30)); // 6000
//        System.out.println(tryParse.getOrElseThrow(IllegalArgumentException::new)); // throws IAE

//        Try.of(() -> Integer.parseInt("100K"))
//                .onSuccess(value -> System.out.println("Parsed: " + value)) // will be executed
//                .onFailure(e -> System.out.println("Cannot parse the value")); // won't be executed

//        int n1 = Try.of(() -> Integer.parseInt("100")) // Success[100]
//                .filter(value -> value > 50) // Success[100]
//                .getUnchecked(); // 100
//
//        int n2 = Try.of(() -> Integer.parseInt("49")) // Success[49]
//                .filter(value -> value > 50) // Failure[NoSuchElementException]
//                .getUnchecked(); // throws a RuntimeException that wraps NoSuchElementException

        int n3 = Try.of(() -> Integer.parseInt("100K")) // Failure[NumberFormatException]
                .filter(value -> value > 50) // Failure[NumberFormatException]
                .getUnchecked(); // throws a RuntimeException that wraps NumberFormatException
    }
}
