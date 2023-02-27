package ru.borisov.functionalinterfaces.retryTask;

@FunctionalInterface
public interface Retry {

    void run(Runnable runnable, int maxAttempts, long delay);
}
