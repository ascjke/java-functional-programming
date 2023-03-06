package ru.borisov.optionals;

import java.util.Optional;

public class FilteringOptionals {

    public static void main(String[] args) {

        Optional<String> version1 = Optional.of("T-1000");
        version1.filter(v -> v.contains("1000")); // returns Optional["T-1000"]
        version1.filter(v -> v.contains("600")); // returns Optional.empty

        Optional<String> version2 = Optional.empty();
        version2.filter(v -> v.contains("600")); // returns Optional.empty
    }
}
