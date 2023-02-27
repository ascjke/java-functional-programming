package ru.borisov.handlingmaps;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PhoneBook {
    private final Map<String, Collection<PhoneNumber>> nameToPhoneNumbersMap = new HashMap<>();

    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();

        phoneBook.addNewPhoneNumbers("Clara", List.of(new PhoneNumber(PhoneNumberType.WORK, "666")));

        List<PhoneNumber> claraPhoneNumbers = new ArrayList<>();
        claraPhoneNumbers.add(new PhoneNumber(PhoneNumberType.HOME, "723324324"));
        phoneBook.addNewPhoneNumbers("Clara", claraPhoneNumbers);

        List<PhoneNumber> kevinPhoneNumbers = new ArrayList<>();
        kevinPhoneNumbers.add(new PhoneNumber(PhoneNumberType.WORK, "1231"));
        phoneBook.addNewPhoneNumbers("Kevin", kevinPhoneNumbers);

        phoneBook.addNewPhoneNumbers("Clara", List.of(new PhoneNumber(PhoneNumberType.MOBILE, "23424279")));
        phoneBook.addNewPhoneNumbers("Paul", List.of(new PhoneNumber(PhoneNumberType.WORK, "56756335")));

        phoneBook.printPhoneBook();
    }

    public void addNewPhoneNumbers(String name, Collection<PhoneNumber> numbers) {
        nameToPhoneNumbersMap.merge(name, numbers,
                (a, b) -> Stream.concat(a.stream(), b.stream()).collect(Collectors.toList()));
    }

    public void printPhoneBook() {
        nameToPhoneNumbersMap.forEach((name, phones) -> {
            System.out.printf("%s\n", name);
            phones.forEach(p -> System.out.printf("%s: %s\n", p.getType().toString(), p.getNumber()));
        });
    }
}

enum PhoneNumberType {
    MOBILE, HOME, WORK,
}

class PhoneNumber {

    private PhoneNumberType type;
    private String number;

    public PhoneNumber(PhoneNumberType type, String number) {
        this.type = type;
        this.number = number;
    }

    public PhoneNumberType getType() {
        return type;
    }

    public String getNumber() {
        return number;
    }
}
