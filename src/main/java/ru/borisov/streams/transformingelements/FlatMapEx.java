package ru.borisov.streams.transformingelements;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapEx {

    public static void main(String[] args) {

        List<OnlineCourse> courses = List.of(
                new OnlineCourse("Algorithms, Part I", List.of("Kevin Wayne", "Robert Sedgewick")),
                new OnlineCourse("Analysis of Algorithms", List.of("Robert Sedgewick")),
                new OnlineCourse("Programming in Java: A Hands-on Introduction",
                        List.of("Anh Le", "Patrick Ester", "Elise Deitrick"))
        );

        Set<String> instructors = courses.stream()
                .flatMap(course -> course.getInstructors().stream())
                .collect(Collectors.toSet());

        System.out.println(instructors);

        List<List<String>> strings = List.of(
                List.of("j", "a", "v", "a"),
                List.of("i", "s"),
                List.of("g", "r", "e", "a", "t")
        );

        Set<String> result = strings.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        System.out.println(result);
    }
}

@RequiredArgsConstructor
@Getter
class OnlineCourse {
    private final String title;
    private final List<String> instructors;

}

class FindMax {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int max = Stream
                .iterate(1, i -> scanner.hasNextLine(), i -> i + 1) // iterates over all input lines
                .map(i -> scanner.nextLine())
                .map(line -> line.split("\\s+"))
                .flatMap(Arrays::stream)
                .filter(string -> string.length() > 0)
                .map(Integer::parseInt)
                .max(Comparator.naturalOrder())
                .orElse(Integer.MIN_VALUE);
    }
}
