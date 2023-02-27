package ru.borisov.functionalinterfaces;

import java.util.function.Function;

public class LambdaAsMethodParameter {

    public static int substitution(int n, Function<Integer, Integer> digitRule) {
        String numberAsString = String.valueOf(n);
        int result = 0;

        for (int i = 0; i < numberAsString.length(); i++) {
            result *= 10;
            int nextDigit = Integer.parseInt(String.valueOf(numberAsString.charAt(i)));
            result += digitRule.apply(nextDigit);
        }

        return result;
    }

    public static void main(String[] args) {

        int number = 123456789;

        // 123456789 -> 234567890
        int result1 = substitution(number, digit -> digit < 9 ? digit + 1 : 0);
        System.out.println(result1);

        // 123456789 -> 101010101
        int result2 = substitution(number, digit -> digit % 2 == 0 ? 0 : 1);
        System.out.println(result2);

        // 123456789 -> 123457777
        int result3 = substitution(number, digit -> digit > 5 ? 7 : digit);
        System.out.println(result3);
    }
}
