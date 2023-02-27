package ru.borisov.functionalinterfaces.retryTask;

import java.util.Scanner;

class Retrying {
    private static final int MAX_ATTEMPTS = 10;
    private static final long DELAY_MS = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RetryUtils.retry.run(() -> System.out.println(scanner.nextInt()), MAX_ATTEMPTS, DELAY_MS);
    }
}
