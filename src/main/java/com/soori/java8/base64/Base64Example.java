package com.soori.java8.base64;
import java.util.Base64;

public class Base64Example {
    public static void main(String[] args) {
        // Original string
        String originalString = "Hello, World!";
        System.out.println("Original String: " + originalString);

        // Encoding
        String encodedString = Base64.getEncoder().encodeToString(originalString.getBytes());
        System.out.println("Encoded String: " + encodedString);

        // Decoding
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        String decodedString = new String(decodedBytes);
        System.out.println("Decoded String: " + decodedString);
    }
}
