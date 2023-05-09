package ru.borisov.asynchronous;

import java.util.List;

public interface Client {

    Tutorial getTutorial();

    List<Tutorial> getTutorials();

    Tutorial getBestTutorial();

    Author findAuthorByTutorialName(String authorName);
}
