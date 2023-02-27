package ru.borisov.handlingmaps;

import java.util.HashMap;
import java.util.Map;

public class ForEachMap {

    public static void main(String[] args) {

        Map<String, String> phoneBook = Map.of(
                "Tom Hunter", "0131 128 8144",
                "Layla Graham", "07027296303",
                "Michael Butler", "+44(0)1035 093821"
        );

        phoneBook.forEach((name, phone) -> System.out.printf("Name: %s, Phone: %s\n", name, phone));
        System.out.println("***********************");
        phoneBook.keySet().forEach(System.out::println);
        System.out.println("***********************");
        phoneBook.entrySet().forEach(entry ->
                System.out.printf("Name: %s, Phone: %s\n", entry.getKey(), entry.getValue()));

        System.out.println("***********************");
        Map<String, String> mutablePhoneBook = new HashMap<>(Map.of(
                "Tom Hunter", "0131 128 8144",
                "Layla Graham", "0702 7296 3035",
                "Michael Butler", "0035 0938 2100"
        ));

        mutablePhoneBook.replaceAll((name, phone) -> "1 " + phone);
        mutablePhoneBook.forEach((name, phone) -> System.out.printf("Name: %s, Phone: %s\n", name, phone));
    }
}
