package ru.borisov.streams.collecting.map;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapCollectingEx {

    public static void main(String[] args) {

        List<Log> logs = List.of(
                new Log(Instant.now(), "ERROR", 100L),
                new Log(Instant.now(), "WARN", 200L),
                new Log(Instant.now(), "INFO", 300L)
        );

        Map<Instant, Log> logsByTimestamp1 = logs.stream()
                .filter(log -> !Objects.equals(log.getType(), "INFO"))
                .collect(Collectors.toMap(Log::getTimestamp, Function.identity()));

        Map<Instant, Log> logsByTimestamp2 = logs.stream()
                .filter(log -> !Objects.equals(log.getType(), "INFO"))
                // three-argument toMap collector that takes a merge function used to resolve collisions between values
                // associated with the same key. The simplest way to use it is just prefer one of the values over others:
                .collect(Collectors.toMap(Log::getTimestamp, Function.identity(), (first, second) -> first));

        // specify the Map
        Map<Instant, Log> logsByTimestamp3 = logs.stream()
                .filter(log -> !Objects.equals(log.getType(), "INFO"))
                .collect(Collectors.toMap(Log::getTimestamp, Function.identity(), (first, second) -> first, TreeMap::new));
    }
}

@Data
@AllArgsConstructor
class Log {
    private final Instant timestamp;
    private final String type;
    private final long delay;
}
