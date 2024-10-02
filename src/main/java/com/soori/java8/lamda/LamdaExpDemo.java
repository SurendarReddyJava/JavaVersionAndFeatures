package com.soori.java8.lamda;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.DoubleSupplier;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.LongPredicate;
import java.util.function.LongSupplier;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;
import java.util.function.LongUnaryOperator;
import java.util.function.ObjDoubleConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.ObjLongConsumer;

public class LamdaExpDemo {

    public static void main(String[] args) {
        // Before Java 8
        System.out.println("=== Before Java 8 ===");

        // Runnable example
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello, World!");
            }
        };
        r1.run();

        // Consumer example
        Consumer<String> consumer1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer1.accept("Hello, Lambda!");

        // BiFunction example
        BiFunction<Integer, Integer, Integer> add1 = new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer a, Integer b) {
                return a + b;
            }
        };
        System.out.println("Sum: " + add1.apply(5, 3));

        // Stream API example
        List<String> names1 = Arrays.asList("Alice", "Bob", "Charlie");
        for (String name : names1) {
            if (name.startsWith("A")) {
                System.out.println(name);
            }
        }

        for (String name : names1) {
            System.out.println(name);
        }

        // With Java 8
        System.out.println("\n=== With Java 8 ===");

        // Runnable example
        Runnable r2 = () -> System.out.println("Hello, World!");
        r2.run();

        // Consumer example
        Consumer<String> consumer2 = s -> System.out.println(s);
        consumer2.accept("Hello, Lambda!");

        // BiFunction example
        BiFunction<Integer, Integer, Integer> add2 = (a, b) -> a + b;
        System.out.println("Sum: " + add2.apply(5, 3));

        // Stream API example
        List<String> names2 = Arrays.asList("Alice", "Bob", "Charlie");
        names2.stream()
             .filter(name -> name.startsWith("A"))
             .forEach(System.out::println);

        names2.forEach(System.out::println);

        // Additional Functional Interfaces Examples

        // BiPredicate example
        BiPredicate<String, String> biPredicate = (s1, s2) -> s1.equals(s2);
        System.out.println("Are strings equal? " + biPredicate.test("hello", "hello"));

        // BooleanSupplier example
        BooleanSupplier booleanSupplier = () -> true;
        System.out.println("Boolean value: " + booleanSupplier.getAsBoolean());

        // DoubleBinaryOperator example
        DoubleBinaryOperator doubleBinaryOperator = (a, b) -> a / b;
        System.out.println("Division: " + doubleBinaryOperator.applyAsDouble(10.0, 2.0));

        // DoubleConsumer example
        DoubleConsumer doubleConsumer = d -> System.out.println("Double value: " + d);
        doubleConsumer.accept(5.5);

        // DoubleFunction example
        DoubleFunction<String> doubleFunction = d -> "Value: " + d;
        System.out.println(doubleFunction.apply(4.5));

        // DoublePredicate example
        DoublePredicate doublePredicate = d -> d > 0;
        System.out.println("Is positive? " + doublePredicate.test(3.5));

        // DoubleSupplier example
        DoubleSupplier doubleSupplier = () -> 42.0;
        System.out.println("Double value: " + doubleSupplier.getAsDouble());

        // DoubleToIntFunction example
        DoubleToIntFunction doubleToIntFunction = d -> (int) d;
        System.out.println("Double to int: " + doubleToIntFunction.applyAsInt(4.9));

        // DoubleToLongFunction example
        DoubleToLongFunction doubleToLongFunction = d -> (long) d;
        System.out.println("Double to long: " + doubleToLongFunction.applyAsLong(4.9));

        // DoubleUnaryOperator example
        DoubleUnaryOperator doubleUnaryOperator = d -> d * d;
        System.out.println("Square: " + doubleUnaryOperator.applyAsDouble(3.0));

        // IntBinaryOperator example
        IntBinaryOperator intBinaryOperator = (a, b) -> a - b;
        System.out.println("Difference: " + intBinaryOperator.applyAsInt(10, 3));

        // IntConsumer example
        IntConsumer intConsumer = i -> System.out.println("Int value: " + i);
        intConsumer.accept(7);

        // IntFunction example
        IntFunction<String> intFunction = i -> "Value: " + i;
        System.out.println(intFunction.apply(8));

        // IntPredicate example
        IntPredicate intPredicate = i -> i % 2 == 0;
        System.out.println("Is even? " + intPredicate.test(4));

        // IntSupplier example
        IntSupplier intSupplier = () -> 100;
        System.out.println("Int value: " + intSupplier.getAsInt());

        // IntToDoubleFunction example
        IntToDoubleFunction intToDoubleFunction = i -> i / 2.0;
        System.out.println("Int to double: " + intToDoubleFunction.applyAsDouble(5));

        // IntToLongFunction example
        IntToLongFunction intToLongFunction = i -> i * 100L;
        System.out.println("Int to long: " + intToLongFunction.applyAsLong(5));

        // IntUnaryOperator example
        IntUnaryOperator intUnaryOperator = i -> i * i;
        System.out.println("Square: " + intUnaryOperator.applyAsInt(6));

        // LongBinaryOperator example
        LongBinaryOperator longBinaryOperator = (a, b) -> a + b;
        System.out.println("Sum: " + longBinaryOperator.applyAsLong(100L, 200L));

        // LongConsumer example
        LongConsumer longConsumer = l -> System.out.println("Long value: " + l);
        longConsumer.accept(123L);

        // LongFunction example
        LongFunction<String> longFunction = l -> "Value: " + l;
        System.out.println(longFunction.apply(456L));

        // LongPredicate example
        LongPredicate longPredicate = l -> l > 0;
        System.out.println("Is positive? " + longPredicate.test(789L));

        // LongSupplier example
        LongSupplier longSupplier = () -> 999L;
        System.out.println("Long value: " + longSupplier.getAsLong());

        // LongToDoubleFunction example
        LongToDoubleFunction longToDoubleFunction = l -> l / 2.0;
        System.out.println("Long to double: " + longToDoubleFunction.applyAsDouble(1000L));

        // LongToIntFunction example
        LongToIntFunction longToIntFunction = l -> (int) l;
        System.out.println("Long to int: " + longToIntFunction.applyAsInt(1000L));

        // LongUnaryOperator example
        LongUnaryOperator longUnaryOperator = l -> l * l;
        System.out.println("Square: " + longUnaryOperator.applyAsLong(10L));

        // ObjDoubleConsumer example
        ObjDoubleConsumer<String> objDoubleConsumer = (s, d) -> System.out.println(s + d);
        objDoubleConsumer.accept("Value: ", 2.5);

        // ObjIntConsumer example
        ObjIntConsumer<String> objIntConsumer = (s, i) -> System.out.println(s + i);
        objIntConsumer.accept("Value: ", 3);

        // ObjLongConsumer example
        ObjLongConsumer<String> objLongConsumer = (s, l) -> System.out.println(s + l);
        objLongConsumer.accept("Value: ", 4L);

       
    }
}