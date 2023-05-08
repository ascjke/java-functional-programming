package ru.borisov.streams.grouping;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.partitioningBy;

public class Partitioner {

    public static Map<Boolean, List<Application>> getPartition(List<Application> applications) {
        return applications.stream()
                .collect(partitioningBy(Application::isFree));
    }
}

record Application(String name, boolean isFree) {

}
