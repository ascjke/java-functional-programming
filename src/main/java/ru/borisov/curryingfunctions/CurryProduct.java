package ru.borisov.curryingfunctions;

import java.util.Scanner;
import java.util.function.IntFunction;

// Curry it: f(x, y, z) = x + y^2 + z^3
class CurryProduct {

    public static int calc(int x, int y, int z) {
        // Write a curried form of the function f(x, y, z) = x + y^2 + z^3
        IntFunction<IntFunction<IntFunction<Integer>>> f = a -> b -> c -> a + (int) Math.pow(b, 2) + (int) Math.pow(c, 3);

        return f.apply(x).apply(y).apply(z);
    }

    // Don't change the code below
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] values = scanner.nextLine().split(" ");

        int x = Integer.parseInt(values[0]);
        int y = Integer.parseInt(values[1]);
        int z = Integer.parseInt(values[2]);

        System.out.println(calc(x, y, z));
    }
}
