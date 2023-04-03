package ru.borisov.streams.collecting;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectToUnmodifiable {

    public static void main(String[] args) {

        Set<Integer> numbers = Stream.of(7, 4, 9, 11, 4, 3)
                .collect(Collectors.toUnmodifiableSet());

        numbers.add(10); // UnsupportedOperationException

        CopyOnWriteArrayList<Integer> numbers2 = Stream.of(7, 4, 9, 11, 4, 3)
                .collect(Collectors.toCollection(CopyOnWriteArrayList::new));

        List<String> mostPopulatedCities = Stream
                .of("Tokyo", "Delhi", "Seoul", "Shanghai")
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
