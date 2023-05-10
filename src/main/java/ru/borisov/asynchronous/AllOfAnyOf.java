package ru.borisov.asynchronous;

import java.util.concurrent.CompletableFuture;

public class AllOfAnyOf {

    public static void main(String[] args) {

        Client client = new ClientImpl();

        CompletableFuture<Tutorial> root = client.getTutorialByKeyword("root");
        CompletableFuture<Tutorial> mkdir = client.getTutorialByKeyword("mkdir");
        CompletableFuture<Tutorial> cat = client.getTutorialByKeyword("cat");
        CompletableFuture<Tutorial> sudo = client.getTutorialByKeyword("sudo");

        CompletableFuture<Void> allComplete = CompletableFuture.allOf(root, mkdir, cat, sudo);

        allComplete.thenRun(() -> System.out.println("All complete"));

        CompletableFuture<Object> anyComplete = CompletableFuture.anyOf(root, mkdir, cat, sudo);
        CompletableFuture<String> firstComplete =
                CompletableFuture.anyOf(root, mkdir, cat, sudo)
                        .thenApply(tutorial -> ((Tutorial) tutorial).name());
        System.out.println(firstComplete.join());

    }
}
