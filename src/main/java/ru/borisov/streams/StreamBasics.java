package ru.borisov.streams;

import java.util.List;

public class StreamBasics {

    public static void main(String[] args) {

        List<String> courses = List.of(
                "Introduction to Java",
                "Kotlin for Java Developers",
                "Spring Framework",
                "Algorithms",
                "Scrum in practice"
        );

        courses.stream()  // obtaining the stream
                .sorted() // an intermediate operation that returns a sorted stream
                .limit(3) // an intermediate operation that returns a limited stream
                .forEach(System.out::println); // the final operation that prints each element
        System.out.println("**********************************");
        courses.stream() // obtaining the stream
                .sorted() // an intermediate operation
                .skip(2)  // an intermediate operation
                .forEach(System.out::println); // the final operation
    }
}
