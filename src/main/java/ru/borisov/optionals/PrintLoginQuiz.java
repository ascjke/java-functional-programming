package ru.borisov.optionals;

import java.util.Optional;
import java.util.Set;

public class PrintLoginQuiz {

    public static void printLoginIfPro(Set<User_> users, String id) {
        users.forEach(
                        user -> Optional
                                .ofNullable(user)
                                .flatMap(User_::getAccount)
                                .filter(account -> account.getId().equals(id) && account.getType().equals("pro"))
                                .ifPresent(u -> System.out.println(user.getLogin()))
        );

    }
}

class Account_ {
    private String id;
    private String type;

    public Account_(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }
}

class User_ {
    private String login;
    private Account_ account;

    public User_(String login, Account_ account) {
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
