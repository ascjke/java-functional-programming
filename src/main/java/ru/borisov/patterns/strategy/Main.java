package ru.borisov.patterns.strategy;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Base64;

public class Main {

    public static void main(String[] args) {
        byte[] text = "Some data :)".getBytes();

//        Encoder base64Encoder = new Encoder(new Base64Strategy());
//        Encoder hexEncoder = new Encoder(new HexStrategy());
//        Encoder utfEncoder = new Encoder(new UTFStrategy());

        // функциональное программирование позволяет не создавать реализации String encode(byte[] data)
        Encoder base64Encoder = new Encoder(data -> Base64.getEncoder().encodeToString(data));
        Encoder hexEncoder = new Encoder(data -> new BigInteger(1, data).toString(16));
        Encoder utfEncoder = new Encoder(data -> Arrays.toString(data));

        base64Encoder.printEncoded(text);
        hexEncoder.printEncoded(text);
        utfEncoder.printEncoded(text);
    }
}
