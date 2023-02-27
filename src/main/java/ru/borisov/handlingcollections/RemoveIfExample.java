package ru.borisov.handlingcollections;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class RemoveIfExample {

    public static void main(String[] args) {
        boolean weatherIsGood = System.currentTimeMillis() % 2 == 0;
        List<Integer> famousNumbers = new ArrayList<>(List.of(0, 1, 1, 2, 3, 5, 8, 13));
        Predicate<Integer> predicate = weatherIsGood ? n -> n % 2 == 0 : n -> n > 1;

        // can choose predicate at runtime
        famousNumbers.removeIf(predicate);
        System.out.println(famousNumbers);
    }
}
