package ru.borisov.exceptionhandling;

@FunctionalInterface
interface ThrowableOperation<T> {
    T execute() throws Throwable;
}
