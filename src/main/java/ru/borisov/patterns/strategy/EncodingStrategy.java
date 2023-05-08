package ru.borisov.patterns.strategy;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Base64;

@FunctionalInterface
public interface EncodingStrategy {
    String encode(byte[] data);
}

class HexStrategy implements EncodingStrategy {

    @Override
    public String encode(byte[] data) {
        return new BigInteger(1, data).toString(16);
    }
}

class Base64Strategy implements EncodingStrategy {

    @Override
    public String encode(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }
}

class UTFStrategy implements EncodingStrategy {

    @Override
    public String encode(byte[] data) {
        return Arrays.toString(data);
    }
}
