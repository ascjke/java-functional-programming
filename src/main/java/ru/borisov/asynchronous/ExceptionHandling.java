package ru.borisov.asynchronous;

import java.util.concurrent.CompletableFuture;

public class ExceptionHandling {

    public static void main(String[] args) {
        ExceptionHandling exceptionHandling = new ExceptionHandling();
        exceptionHandling.executeFuture();

//        CompletableFuture<String> dataFuture = CompletableFuture.supplyAsync(() -> {
//            error();
//            return "some data";
//        });
//
//        CompletableFuture<String> exceptionally =
//                dataFuture.exceptionally(throwable -> "No data due to");
//        System.out.println(exceptionally.join());
    }

    private void executeFuture() {
        CompletableFuture<String> dataFuture = CompletableFuture.supplyAsync(() -> {
            error();
            return "some data";
        });

        CompletableFuture<String> handleFuture = dataFuture.handle((result, throwable) -> {
            if (throwable != null) {
                return "No data";
            } else {
                return result.toUpperCase();
            }
        });

        System.out.println(handleFuture.join());
    }


    private static void error() {
        throw new RuntimeException("Ooops, something went wrong");
    }
}
