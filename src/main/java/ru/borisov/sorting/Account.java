package ru.borisov.sorting;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
@Data
public class Account {

    private final String owner;
    private final long balance;
    private final boolean locked;

    public static Comparator<? super Account> getComparatorByLockedBalanceAndOwner() {
        return Comparator
                .comparing(Account::isLocked)
                .thenComparing(Account::getBalance, Comparator.reverseOrder())
                .thenComparing(Account::getOwner);
    }
}

class SortingAccounts {

    public static void main(String[] args) {

        List<Account> accounts = new ArrayList<>();

        accounts.add(new Account("Peter", 1000L, false));
        accounts.add(new Account("John", 1000L, false));
        accounts.add(new Account("Ivan", 8000L, true));
        accounts.add(new Account("Helen", 5000L, false));
        accounts.add(new Account("Nicole", 3000L, true));

        accounts.sort(Account.getComparatorByLockedBalanceAndOwner());

        accounts.forEach(System.out::println);
    }
}
