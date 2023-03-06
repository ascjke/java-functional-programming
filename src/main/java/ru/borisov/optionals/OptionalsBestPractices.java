package ru.borisov.optionals;

import lombok.Data;
import lombok.Value;

import java.util.Optional;

public class OptionalsBestPractices {

    public static void main(String[] args) {

        Robot robot = new Robot(new Engine(new Battery(null)));

        String version = Optional.ofNullable(robot)
                .flatMap(Robot::getEngine)
                .flatMap(Engine::getBattery)
                .map(Battery::getVersion)
                .orElse("Battery version is unknown");

        System.out.println(version);
    }
}

@Data
class Robot {
    private final Engine engine;

    public Optional<Engine> getEngine() {
        return Optional.ofNullable(engine);
    }
}

@Data
class Engine {
    private final Battery battery;

    public Optional<Battery> getBattery() {
        return Optional.ofNullable(battery);
    }
}

@Data
class Battery {
    private final String version;

    public String getVersion() {
        return version;
    }
}
