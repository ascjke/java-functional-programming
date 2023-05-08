package ru.borisov.returningfunctions;

import java.util.function.Function;
import java.util.function.Predicate;

public class ExtensionService {

    public static void main(String[] args) {
        Function<String, String> func = addExtension(y -> y.equals("First"), y -> y.equals("Second"));
        System.out.println(func.apply("First"));//should print First.xml
        System.out.println(func.apply("Second"));//should print Second.json
        System.out.println(func.apply("Otherwise"));//should print Otherwise

    }

    public static Function<String, String> addExtension(Predicate<String> isXml, Predicate<String> isJson) {
        return file -> isXml.test(file) ? file + ".xml" :
                isJson.test(file) ? file + ".json" : file;
    }
}
