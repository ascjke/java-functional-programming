package ru.borisov.asynchronous;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


public class CompletableFutureCreating {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Client client = new ClientImpl();

        //can be useful in some cases, for example, for testing purposes
        CompletableFuture<Integer> completedFuture = CompletableFuture.completedFuture(42);


        // real case
        CompletableFuture<Void> printTutorials = CompletableFuture.runAsync(() -> {
            List<Tutorial> tutorials = client.getTutorials();
            tutorials.forEach(tutorial -> System.out.println(tutorial.name()));
        });

        CompletableFuture<Tutorial> bestTutorial =
                CompletableFuture.supplyAsync(client::getBestTutorial);
        System.out.println(bestTutorial.get());
    }
}




