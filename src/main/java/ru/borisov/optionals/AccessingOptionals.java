package ru.borisov.optionals;

import java.util.Optional;

public class AccessingOptionals {

    public static void main(String[] args) {

        Optional<String> version1 = Optional.of("T-1000");
        System.out.println(version1.orElse("T-600")); // "T-1000"

        Optional<String> version2 = Optional.empty();
        System.out.println(version2.orElse("T-600")); // "T-600"


    }
}
