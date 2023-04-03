package ru.borisov.streams.filtering;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProcessingNumbers {

    public static Stream<Integer> getStream(Collection<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n < 100) // filter before sorting
                .sorted() // sorting
                .distinct(); // it is easy find unique elements on sorted Stream
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String result = getStream(numbers)
                .map(String::valueOf)
                .collect(Collectors.joining(" "));

        System.out.println(result);
    }
}
