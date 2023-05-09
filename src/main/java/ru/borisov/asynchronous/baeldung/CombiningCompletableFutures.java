package ru.borisov.asynchronous.baeldung;

import java.util.concurrent.CompletableFuture;

/**
 * Monadic design pattern
 */
public class CombiningCompletableFutures {

    public static void main(String[] args) {

        CompletableFuture<String> completableFuture
                = CompletableFuture.supplyAsync(() -> "Hello")
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " World")); // s = CompletableFuture<"Hello">

        CompletableFuture<String> completableFuture2
                = CompletableFuture.supplyAsync(() -> "Hello")
                .thenCombine(CompletableFuture.supplyAsync(() -> " World"), (s1, s2) -> s1 + s2);

        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> "Hello")
                .thenAcceptBoth(CompletableFuture.supplyAsync(() -> " World"),
                        (s1, s2) -> System.out.println(s1 + s2));
    }
}
