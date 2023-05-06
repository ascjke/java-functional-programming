package ru.borisov.streams.infinite;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ScannerWithStream {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Employee> employees = Stream.iterate(0, i -> scanner.hasNextLine(), i -> i + 1)
                .map(i -> scanner.nextLine())
                .map(Employee::new)
                .collect(Collectors.toList());
        scanner.close();

        System.out.println(employees);
    }
}

record Employee(String name){}
