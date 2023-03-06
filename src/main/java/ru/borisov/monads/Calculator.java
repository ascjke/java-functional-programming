package ru.borisov.monads;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * This generic class represents a monadic-like calculator
 */
class Calculator<T extends Number> {
    /**
     * It represents a calculator in which an error has occurred
     */
    private static final Calculator<?> BROKEN_CALCULATOR = new Calculator<>(true);
    /**
     * The value stored inside the calculator
     */
    private final T value;
    /**
     * It determines if the calculator has an error
     */
    private final boolean hasError;

    private Calculator(T value) {
        this.value = value;
        this.hasError = false;
    }

    private Calculator(boolean hasError) {
        this.value = null;
        this.hasError = hasError;
    }

    /**
     * It returns a broken calculator with an explicit type casting.
     * We recommend you to use this method instead of accessing BROKEN_CALCULATOR directly.
     */
    @SuppressWarnings("unchecked")
    private static <T extends Number> Calculator<T> getBrokenCalculator() {
        return (Calculator<T>) BROKEN_CALCULATOR;
    }

    /**
     * The method creates a new instance of the calculator with a specified initial value.
     */
    public static <T extends Number> Calculator<T> of(T value) {
        if (value == null) {
            return getBrokenCalculator();
        }
        return new Calculator<>(value);
    }

    /**
     * The method applies a given function to the value stored in the calculator.
     * It never throws ArithmeticException or NullPointerException
     */
    public <U extends Number> Calculator<U> eval(Function<? super T, ? extends U> mapper) {
        Calculator<U> calculator;
        try {
            calculator = Calculator.of(mapper.apply(value));
        } catch (RuntimeException e) {
            calculator = getBrokenCalculator();
//            e.printStackTrace();
        }
        return calculator;
    }

    /**
     * The method passes the stored value to a given consumer only if no errors have occurred in the calculator.
     */
    public Calculator<T> consume(Consumer<T> consumer) {
        if (!this.hasError) {
            consumer.accept(value);
        }
        return this;
    }
}
