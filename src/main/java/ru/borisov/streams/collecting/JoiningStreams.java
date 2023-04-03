package ru.borisov.streams.collecting;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JoiningStreams {

    public static void main(String[] args) {

        String collect = Stream.of("Ja", "va")
                .collect(Collectors.joining());// Java
        System.out.println(collect);

        // A huge advantage of this approach to create strings based on elements is that when you use a delimiter, it is not appended after the last element.
        String collect1 = Stream.of("Functions", "in", "Java")
                .collect(Collectors.joining("\s"));// Functions in Java
        System.out.println(collect1);

        String collect2 = Stream.of("Java", "Kotlin", "Scala")
                .collect(Collectors.joining(",\s", "(", ")"));// (Java, Kotlin, Scala)
        System.out.println(collect2);
    }
}
