package ru.borisov.patterns.chainofresponsibility.paymentsystem;

@FunctionalInterface
public interface RequestHandler {

    Request handle(Request request);

    default RequestHandler combine(RequestHandler after) {
        return request -> after.handle(this.handle(request));
    }
}
