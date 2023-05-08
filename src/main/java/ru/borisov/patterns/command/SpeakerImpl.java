package ru.borisov.patterns.command;

public class SpeakerImpl implements Speaker {
    @Override
    public void play() {
        System.out.println("Play");
    }

    @Override
    public void pause() {
        System.out.println("pause");
    }

    @Override
    public void volumeUp() {
        System.out.println("volume Up");
    }

    @Override
    public void volumeDown() {
        System.out.println("volume down");
    }
}
