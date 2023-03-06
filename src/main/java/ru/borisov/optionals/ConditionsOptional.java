package ru.borisov.optionals;

import java.util.Optional;

public class ConditionsOptional {

    public static void main(String[] args) {

        Optional<String> framework = Optional.of("java spring");
        framework.ifPresent(f -> System.out.println(f.toUpperCase())); // prints JAVA SPRING

        Optional<String> version = Optional.of("T-1000");

        version.ifPresentOrElse(
                System.out::println, // if present
                () -> System.out.println("bad request") // if null
        ); // prints "T-1000"

        Optional<String> empty = Optional.empty();

        empty.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("bad request")
        ); // prints "bad request"


        Optional<String> version1 = Optional.of("T-1000");
        version1.or(() -> Optional.of("T-600")); // returns Optional["T-1000"]

        Optional<String> version2 = Optional.empty();
        version2.or(() -> Optional.of("T-600")); // returns Optional["T-600"]
    }
}
