package ru.borisov.patterns.chainofresponsibility;

import java.util.function.Predicate;

public class Client {

    public static void main(String[] args) {

        String s = "Chain chain = new Chain();";

//        StatementHandler lineEndHandler = new LineEndHandler();
//        StatementHandler lengthHandler = new LengthHandler();
//        StatementHandler valHandler = new ValHandler();
//
//        lineEndHandler.setNext(lengthHandler);
//        lengthHandler.setNext(valHandler);
//
//        boolean isValid = lineEndHandler.isValid(s);

        // functional approach
        Predicate<String> lineEndHandler = statement -> statement.endsWith(";");
        Predicate<String> lengthHandler = statement -> statement.length() <= 50;
        Predicate<String> valHandler = statement -> !statement.contains("val");

        boolean isValid = lineEndHandler
                .and(lengthHandler)
                .and(valHandler)
                .test(s);

        System.out.println(isValid);
    }
}
