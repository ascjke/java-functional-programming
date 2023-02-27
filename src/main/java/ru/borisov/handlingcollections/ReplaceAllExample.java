package ru.borisov.handlingcollections;

import java.util.ArrayList;
import java.util.List;

public class ReplaceAllExample {

    public static void main(String[] args) {

        List<String> countries = new ArrayList<>(List.of(
                "china", "australia", "germany",
                "russia", "spain", "south korea"
        ));

        countries.replaceAll(String::toUpperCase);

        System.out.println(countries); // [CHINA, AUSTRALIA, GERMANY, RUSSIA, SPAIN, SOUTH KOREA]
    }
}
