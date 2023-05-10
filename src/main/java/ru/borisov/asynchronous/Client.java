package ru.borisov.asynchronous;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface Client {

    Tutorial getTutorial();

    List<Tutorial> getTutorials();

    Tutorial getBestTutorial();

    Author findAuthorByTutorialName(String authorName);

    CompletableFuture<Tutorial> getTutorialByKeyword(String keyWord);
}
