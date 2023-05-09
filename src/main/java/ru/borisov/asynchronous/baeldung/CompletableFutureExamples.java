package ru.borisov.asynchronous.baeldung;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExamples {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> completableFuture
                = CompletableFuture.supplyAsync(() -> "Hello");

        CompletableFuture<String> futureAsFunction = completableFuture
                .thenApply(s -> s + " World");
        System.out.println(futureAsFunction.get());

        CompletableFuture<Void> futureAsConsumer = completableFuture
                .thenAccept(s -> System.out.println("Computation returned: " + s));

        CompletableFuture<Void> futureAsRunnable = completableFuture
                .thenRun(() -> System.out.println("Computation finished."));

    }
}
