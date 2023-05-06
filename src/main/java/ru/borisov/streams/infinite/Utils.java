package ru.borisov.streams.infinite;

import java.util.stream.Stream;

final class Utils {

    private Utils() {
    }

    public static Stream<User> generateUsers(int numberOfUsers) {

        StringBuilder sb = new StringBuilder(100);
        return Stream.iterate(1, i -> i <= numberOfUsers, i -> i + 1)
                .map(i -> new User(i, String.format("user%d@gmail.com", i)));
    }
}

class User {
    private final long id;
    private final String email;

    User(long id, String email) {
        this.id = id;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
