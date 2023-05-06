package ru.borisov.streams.primitives;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class PrimitiveStreamEx2 {

    public static void main(String[] args) {

        int[] numbers = {21, 14, 15, 30};

        double avg = IntStream.of(numbers).average().orElse(0.0); // 20.0
        int sum = IntStream.of(numbers).sum(); // 80

        IntSummaryStatistics stat = IntStream.rangeClosed(1, 10).summaryStatistics();

        System.out.printf("Count: %d, Min: %d, Max: %d, Sum: %d, Avg: %.1f%n",
                stat.getCount(), stat.getMin(), stat.getMax(), stat.getSum(), stat.getAverage());

        List<User> users = LongStream.of(1, 2, 3)
                .mapToObj(User::new)
                .collect(Collectors.toList());

        User user = new User(1);
    }
}

record User(long id) {
}
