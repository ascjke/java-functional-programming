package ru.borisov.patterns.command;

import java.util.ArrayList;
import java.util.List;

class Player {
    private final List<Command> commands;

    public Player() {
        commands = new ArrayList<>();
    }

    public void add(Command command) {
        commands.add(command);
    }

    public void run() {
        for (Command command : commands) {
            command.execute();
        }
    }
}
