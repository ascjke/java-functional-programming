package ru.borisov.streams;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class SourceOfStreams {

    public static void main(String[] args) {

        // Getting stream from a String
        Stream<String> stream = "Breaking news\na new version of Java\ris coming soon!".lines();
        stream.forEach(System.out::println);

        // Streams from a Map
        Map<String, String> phoneBook = Map.of(
                "Tom Hunter", "0131 128 8144",
                "Layla Graham", "07027296303",
                "Michael Butler", "+44(0)1035 093821"
        );

        Stream<String> names = phoneBook.keySet().stream();
        Stream<String> phones = phoneBook.values().stream();
        Stream<Map.Entry<String, String>> entries = phoneBook.entrySet().stream();

        // Streams from enumerating all values
        Stream<String> persons = Stream.of("Elizabeth", "John", "Alise");

        // Concatenating streams
        Stream<Integer> stream1 = Stream.of(1, 2, 3);
        Stream<Integer> stream2 = Stream.of(4, 5);
        Stream<Integer> stream3 = Stream.concat(stream1, stream2); // 1 2 3 4 5

        // Empty streams
        Stream<Integer> empty1 = Stream.of();
        Stream<Integer> empty2 = Stream.empty();

        // Stream from Optional
        Optional<String> optionalBook = Optional.ofNullable("Peace and war");
        Stream<String> bookStream = optionalBook.stream();
    }
}
