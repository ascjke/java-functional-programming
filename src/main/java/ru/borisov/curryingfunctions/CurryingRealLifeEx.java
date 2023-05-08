package ru.borisov.curryingfunctions;

import java.util.function.Function;

public class CurryingRealLifeEx {

    public static void main(String[] args) {

        Function<String, Function<String, String>> querySchemaTable = schema -> query -> {
            String setSchema = String.format("set schema '%s'", schema);
            // execute setting schema and execute a query
            return String.format("%s; %s", setSchema, query);
        };

        var queryProductionSchema = querySchemaTable.apply("production");

        // set schema 'production'; SELECT * FROM customers
        queryProductionSchema.apply("SELECT * FROM customers");

        // set schema 'production'; DROP TABLE rates
        queryProductionSchema.apply("DROP TABLE rates");

        var queryDevSchema = querySchemaTable.apply("development");

        // set schema 'development'; SELECT * FROM customers
        queryDevSchema.apply("SELECT * FROM customers");
    }
}
