package com.soori.java8.optional;
import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        // Creating an Optional object
        Optional<String> optionalString = Optional.of("Hello, World!");

        // Checking if a value is present
        if (optionalString.isPresent()) {
            System.out.println("Value is present: " + optionalString.get());
        } else {
            System.out.println("Value is not present");
        }

        // Using ifPresent method
        optionalString.ifPresent(value -> System.out.println("Value using ifPresent: " + value));

        // Using orElse method
        String defaultValue = optionalString.orElse("Default Value");
        System.out.println("Value using orElse: " + defaultValue);

        // Using orElseGet method
        String valueOrElseGet = optionalString.orElseGet(() -> "Default Value from Supplier");
        System.out.println("Value using orElseGet: " + valueOrElseGet);

        // Using orElseThrow method
        try {
        	Optional<String> optionalString2 =  Optional.empty();
            String valueOrElseThrow = optionalString2.orElseThrow(() -> new IllegalArgumentException("No value present"));
            System.out.println("===>Value using orElseThrow: " + valueOrElseThrow);
        } catch (Exception e) {
        	e.printStackTrace();
            System.out.println("Exception message "+e.getMessage());
        }

        // Creating an empty Optional
        Optional<String> emptyOptional = Optional.empty();
        System.out.println("Empty Optional: " + emptyOptional);

        // Using map method
        Optional<Integer> lengthOptional = optionalString.map(String::length);
        lengthOptional.ifPresent(length -> System.out.println("Length of the string: " + length));

        // Using flatMap method
        Optional<Optional<String>> nestedOptional = Optional.of(Optional.of("Nested Value"));
        Optional<String> flatMappedValue = nestedOptional.flatMap(opt -> opt);
        flatMappedValue.ifPresent(value -> System.out.println("Value using flatMap: " + value));
    }
}
