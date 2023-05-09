package ru.borisov.asynchronous;

import java.util.List;

public class ClientImpl implements Client {

    @Override
    public Tutorial getTutorial() {
        return new Tutorial("Thinking on Java", new Author("Joshua Bloch"));
    }

    @Override
    public List<Tutorial> getTutorials() {
        return List.of(new Tutorial("Thinking on Java", new Author("Joshua Bloch")),
                new Tutorial("Clean Code", new Author("Steve McConnell"))
        );
    }

    @Override
    public Tutorial getBestTutorial() {
        return new Tutorial("Thinking on Java", new Author("Joshua Bloch"));
    }

    @Override
    public Author findAuthorByTutorialName(String authorName) {
        return new Author("Steve McConnell");
    }
}
