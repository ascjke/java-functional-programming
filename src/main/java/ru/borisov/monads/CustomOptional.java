package ru.borisov.monads;

import java.util.function.Function;

public class CustomOptional<T> {

    private static CustomOptional<?> empty = new CustomOptional<>(null);

    private final T value;

    public CustomOptional(T value) {
        this.value = value;
    }

    public static <T> CustomOptional<T> of(T value) {
        if (value != null) {
            return new CustomOptional<>(value);
        } else {
            return (CustomOptional<T>) empty;
        }
    }

    public <U> CustomOptional<U> flatMap(Function<T, CustomOptional<U>> mapFunc) {
        return mapFunc.apply(value);
    }

    public <U> CustomOptional<U> map(Function<T, U> mapFunc) {
        if (value != null) {
            return flatMap(val -> new CustomOptional<>(mapFunc.apply(val)));
        } else {
            return (CustomOptional<U>) empty;
        }
    }
}
