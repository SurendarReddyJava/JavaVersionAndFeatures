package com.soori.java8.concurrent;
import java.util.concurrent.atomic.LongAdder;

public class LongAdderExample {
    public static void main(String[] args) {
        LongAdder adder = new LongAdder();

        // Incrementing the adder
        adder.increment();
        adder.increment();

        // Getting the sum
        System.out.println("Sum: " + adder.sum());
    }
}
