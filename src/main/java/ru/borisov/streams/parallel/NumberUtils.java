package ru.borisov.streams.parallel;

import java.util.stream.LongStream;

public class NumberUtils {

    public static boolean isPrime(long n) {
        return n > 1 && LongStream
                .rangeClosed(2, n - 1)
                .noneMatch(divisor -> n % divisor == 0);
    }

    public static LongStream createPrimesFilteringStream(long start, long end) {
        return LongStream.rangeClosed(start, end)
                .parallel()
                .filter(NumberUtils::isPrime);
    }
}




