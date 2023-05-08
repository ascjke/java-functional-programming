package ru.borisov.patterns.chainofresponsibility;

public class LineEndHandler extends StatementHandler {

    @Override
    boolean isValid(String statement) {
        if (!statement.endsWith(";")) {
            return false;
        }

        if (next != null) {
            return next.isValid(statement);
        }

        return true;
    }
}
