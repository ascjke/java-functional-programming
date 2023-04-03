package ru.borisov.streams.filtering;

import java.util.List;

public class FilterChaining {

    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("Mike", 32),
                new Person("Jerry", 55),
                new Person("Julia", 18),
                new Person("Andrew", 40),
                new Person("Justin", 15)
        );

        long count = people.stream()
                .filter(person -> person.firstName().startsWith("J")) // Jerry, Julia, Justin
                .filter(person -> person.age() >= 18 && person.age() <= 59) // Jerry, Julia
                .count(); // 2

        System.out.println(count);

        List<Integer> numbers = List.of(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6);
        numbers.stream()
                .filter(n -> n > -5 && n <= 5)
                .filter(n -> n < 0 || n > 2)
                .forEach(System.out::println);
    }
}

record Person (String firstName, int age) {}
