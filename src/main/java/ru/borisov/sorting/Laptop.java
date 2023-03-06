package ru.borisov.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public record Laptop(String brand, int numberOfCores, double displaySize) {
}

class SortingLaptops {

    public static void main(String[] args) {

        List<Laptop> laptops = new ArrayList<>();
        laptops.add(new Laptop("HP", 4, 15.6));
        laptops.add(new Laptop("Apple", 6, 15.6));
        laptops.add(new Laptop("Asus", 4, 14.1));
        laptops.add(new Laptop("Dell", 8, 17.0));
        laptops.add(new Laptop("Old but work", 1, 15.1));

        Comparator<Laptop> byNumberOfCores = Comparator.comparingInt(Laptop::numberOfCores);

        laptops.sort(byNumberOfCores);
        laptops.forEach(System.out::println);

        // thenComparing()
        System.out.println("****************************************");
        laptops.sort(Comparator
                .comparing(Laptop::numberOfCores, Comparator.reverseOrder())
                .thenComparingDouble(Laptop::displaySize));
        laptops.forEach(System.out::println);
    }
}
