package ru.borisov.asynchronous.baeldung;

import java.util.concurrent.CompletableFuture;

public class HandlingErrors {

    public static void main(String[] args) {

        String name;
        if (Math.random() > 0.5) {
            name = "Zakhar";
        } else {
            name = null;
        }

        CompletableFuture<String> completableFuture
                =  CompletableFuture.supplyAsync(() -> {
            if (name == null) {
                throw new RuntimeException("Computation error!");
            }
            return "Hello, " + name;
        }).handle((s, t) -> s != null ? s : "Hello, Stranger!");

        System.out.println(completableFuture.join());


        CompletableFuture<String> completableFuture2 = new CompletableFuture<>();

        // ...

        completableFuture2.completeExceptionally(
                new RuntimeException("Calculation failed!"));

        // ...

        completableFuture2.join(); // ExecutionException
    }
}
