package ru.borisov.optionals;

import java.util.Optional;

public class CreatingOptionals {

    public static void main(String[] args) {

        Optional<String> batteryVersion1 = Optional.empty();

        Optional<String> batteryVersion2 = Optional.of("T1000");

//        Optional<String> batteryVersion3 = Optional.of(null); // throws NPE

        String version = null;
        Optional<String> batteryVersion4 = Optional.ofNullable(version); // return private ctor new Optional<>(null);

    }
}
