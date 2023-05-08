package ru.borisov.patterns.command.task;

public class Executor {

    public void executeCommand(Command command) {
        command.execute();
    }
}
