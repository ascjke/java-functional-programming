package ru.borisov.asynchronous;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class MapCompletableFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Client client = new ClientImpl();

        CompletableFuture<Tutorial> tutorialFuture =
                CompletableFuture.supplyAsync(client::getTutorial);


        // get() блокирует поток main
//        Tutorial tutorial = tutorialFuture.get();
//        Author author = tutorial.author();
//        System.out.println(author.name());

        // thenAccept() не блокирует поток main
        CompletableFuture<Void> printTutorial = tutorialFuture.thenAccept(tutorial ->
                System.out.println(tutorial.name()));

        // thenApply()
        CompletableFuture<String> tutorialName =
                tutorialFuture.thenApply(Tutorial::name);
        System.out.println(tutorialName);


        // chain
        tutorialFuture
                .thenApply(Tutorial::name) // CompletableFuture<String>
                .thenApply(client::findAuthorByTutorialName) // CompletableFuture<Author>
                .thenAccept(System.out::println); // CompletableFuture<Void>
    }
}
