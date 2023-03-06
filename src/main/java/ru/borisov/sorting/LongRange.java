package ru.borisov.sorting;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

@RequiredArgsConstructor
@Data
public class LongRange {
    private final long left;
    private final long right;

    public static void main(String[] args) {
        Set<LongRange> numbers = new TreeSet<>(LongRange.getComparator());

        numbers.add(new LongRange(0, 5));
        numbers.add(new LongRange(2, 4));
        numbers.add(new LongRange(1, 4));
        numbers.add(new LongRange(1, 7));
        numbers.add(new LongRange(3, 5));

        numbers.forEach(System.out::println);
    }

    public static Comparator<LongRange> getComparator() {
        return Comparator
                .comparing(LongRange::getRange)
                .thenComparing(LongRange::getLeft);
    }

    private long getRange() {
        return Math.abs(right - left);
    }

    @Override
    public String toString() {
        return String.format("%d %d", left, right);
    }
}
