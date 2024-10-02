package com.soori.java8.base64;
import java.util.Base64;

public class Base64FeaturesExample {
    public static void main(String[] args) {
        String originalString = "Hello, World!";

// Basic Encoding and Decoding
        Base64.Encoder basicEncoder = Base64.getEncoder();
        String basicEncoded = basicEncoder.encodeToString(originalString.getBytes());
        System.out.println("Basic Encoded: " + basicEncoded);

        Base64.Decoder basicDecoder = Base64.getDecoder();
        String basicDecoded = new String(basicDecoder.decode(basicEncoded));
        System.out.println("Basic Decoded: " + basicDecoded);

// URL and Filename Safe Encoding and Decoding
        Base64.Encoder urlEncoder = Base64.getUrlEncoder();
        String urlString = "https://github.com/SurendarReddyJava/JavaVersionAndFeatures/tree/main";
        String urlEncoded = urlEncoder.encodeToString(urlString.getBytes());
        System.out.println("URL Encoded: " + urlEncoded);

        Base64.Decoder urlDecoder = Base64.getUrlDecoder();
        String urlDecoded = new String(urlDecoder.decode(urlEncoded));
        System.out.println("URL Decoded: " + urlDecoded);

        String mimeString = "This is a long string that needs to be encoded using MIME Base64 encoding. "
                + "It will be split into multiple lines with a maximum line length of 76 characters.";

// MIME Encoding
        Base64.Encoder mimeEncoder = Base64.getMimeEncoder();
        String mimeEncoded = mimeEncoder.encodeToString(mimeString.getBytes());
        System.out.println("MIME Encoded String: \n" + mimeEncoded);

        // MIME Decoding
        Base64.Decoder mimeDecoder = Base64.getMimeDecoder();
        String mimeDecoded = new String(mimeDecoder.decode(mimeEncoded));
        System.out.println("MIME Decoded String: " + mimeDecoded);

// Encoding Without Padding
        Base64.Encoder encoderWithoutPadding = Base64.getEncoder().withoutPadding();
        String encodedWithoutPadding = encoderWithoutPadding.encodeToString(originalString.getBytes());
        System.out.println("Encoded Without Padding: " + encodedWithoutPadding);
    }
}
