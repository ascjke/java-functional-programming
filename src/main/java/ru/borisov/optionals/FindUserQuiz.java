package ru.borisov.optionals;

import java.util.Optional;
import java.util.Set;

public class FindUserQuiz {

    public static Optional<User_> findUserByAccountId(Set<User_> users, String id) {
        User_ findUser = null;
        for (User_ user : users) {
            if (user.getAccount().isPresent()) {
                if (user.getAccount().get().getId().equals(id)) {
                    findUser = user;
                }
            }
        }

        return Optional.ofNullable(findUser);
    }
}

class Account {
    private final String id;

    public Account(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}

class User {
    private final String login;
    private final Account_ account;

    public User(String login, Account_ account) {
        this.login = login;
        this.account = account;
    }

    public String getLogin() {
        return login;
    }

    public Optional<Account_> getAccount() {
        return Optional.ofNullable(account);
    }
}
