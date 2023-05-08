package ru.borisov.streams.parallel;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.function.LongConsumer;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class IteratorEx {

    public static void main(String[] args) {

//        long sum = LongStream.iterate(0, i -> i + 1)
//                .limit(100_000_000)
//                .reduce(0, Long::sum);
//        System.out.println("Sum: " + sum);

//        long sum2 = LongStream.iterate(0, i -> i + 1)
//                .parallel()
//                .limit(100_000_000)
//                .reduce(0, Long::sum);
//        System.out.println("Sum2: " + sum2);

        // tryAdvance
        var spliterator = LongStream.range(0, 10_000).spliterator();
        int count = 0;
        LongConsumer display = System.out::println;
        while (spliterator.tryAdvance(display)) {
            count++;
        }
        System.out.println("count: " + count);

        // trySplit
        var spliterator1 = LongStream.range(0, 10_000).spliterator();
        spliterator1.estimateSize(); // 10 000

        Spliterator.OfLong spliterator2 = spliterator1.trySplit();
        spliterator1.estimateSize(); // 5 000
        spliterator2.estimateSize(); // 5 000

        Spliterator.OfLong spliterator3 = spliterator2.trySplit();
        spliterator1.estimateSize(); // 5 000
        spliterator2.estimateSize(); // 2 500
        spliterator3.estimateSize(); // 2 500

        // characteristics
        var spliterator4 = LongStream.range(0, 10_000).spliterator();
        System.out.println(spliterator4.hasCharacteristics(Spliterator.ORDERED)); // true

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        Spliterator<Integer> spliterator5 = set.stream().spliterator();
        System.out.println(spliterator5.hasCharacteristics(Spliterator.DISTINCT)); // true

        Spliterator<Integer> spliterator6 = IntStream.range(0, 1000).spliterator();
        System.out.println(spliterator6.hasCharacteristics(Spliterator.SORTED)); // true

        IntStream.generate(() -> 2)
                .spliterator()
                .hasCharacteristics(Spliterator.SIZED); // false

        List<String> list = new ArrayList<>();
        list.add("text");
        list.add(null);
        list.add("more text");
        list.spliterator()
                .hasCharacteristics(Spliterator.NONNULL); // false

        List<String> list2 = new ArrayList<>();
        list2.add("text");
        list2.add(null);
        list2.add("more text");
        list2.spliterator()
                .hasCharacteristics(Spliterator.IMMUTABLE); // false

        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(5);

        arrayBlockingQueue
                .spliterator()
                .hasCharacteristics(Spliterator.CONCURRENT); // true

        IntStream.range(0, 1000)
                .spliterator()
                .hasCharacteristics(Spliterator.SUBSIZED); // true
    }
}
