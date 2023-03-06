package ru.borisov.monads;

public class CustomOptionalTest {

    public static void main(String[] args) {

        Client nullClient = new Client(null, 15, true);
        CustomOptional.of(nullClient)
                .map(Client::name)
                .map(nameArray -> nameArray.split("\s"))
                .map(nameArray -> {
                    System.out.println(nameArray[0]);
                    return nameArray[0];
                });

        Client client = new Client("Zakhar Borisov", 15, true);
        CustomOptional.of(client)
                .map(Client::name)
                .map(nameArray -> nameArray.split("\s"))
                .map(nameArray -> {
                    System.out.println(nameArray[0]);
                    return nameArray[0];
                });
    }
}

record Client(String name, int sum, boolean isActive) {}
