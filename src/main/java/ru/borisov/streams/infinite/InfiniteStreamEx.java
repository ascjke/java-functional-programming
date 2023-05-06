package ru.borisov.streams.infinite;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class InfiniteStreamEx {

    public static void main(String[] args) {

        Random random = new Random();
        Stream<Integer> numbers = Stream.generate(random::nextInt); // an infinite stream

        List<Integer> numbersLimited = Stream.generate(random::nextInt)
                .limit(5) // don't miss it
                .toList();

    }
}
