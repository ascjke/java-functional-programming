package ru.borisov.patterns.chainofresponsibility;

public abstract class StatementHandler {

    protected StatementHandler next;

    public void setNext(StatementHandler next) {
        this.next = next;
    }

    abstract boolean isValid(String statement);
}
