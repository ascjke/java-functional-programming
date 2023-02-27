package ru.borisov.functionalinterfaces;

import java.util.Scanner;
import java.util.function.Function;

class Emailing {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String sender = scanner.nextLine();
        String receiver = scanner.nextLine();
        String signature = scanner.nextLine();

        Function<String, String> emailFormatter = text -> new StringBuilder()
                .append(sender)
                .append("|")
                .append(receiver)
                .append("|")
                .append(text)
                .append("|")
                .append(signature)
                .toString();

        System.out.println(emailFormatter.apply(scanner.nextLine()));
    }
}
