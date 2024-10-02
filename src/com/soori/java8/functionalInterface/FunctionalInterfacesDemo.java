package com.soori.java8.functionalInterface;
import java.util.function.*;

public class FunctionalInterfacesDemo {

    public static void main(String[] args) {
        // BiConsumer example
        BiConsumer<String, Integer> biConsumer = (s, i) -> System.out.println(s + i);
        biConsumer.accept("Age: ", 30);

        // BiFunction example
        BiFunction<Integer, Integer, Integer> biFunction = (a, b) -> a + b;
        System.out.println("Sum: " + biFunction.apply(10, 20));

        // BinaryOperator example
        BinaryOperator<Integer> binaryOperator = (a, b) -> a * b;
        System.out.println("Product: " + binaryOperator.apply(3, 5));

        // BiPredicate example
        BiPredicate<String, String> biPredicate = (s1, s2) -> s1.equals(s2);
        System.out.println("Are strings equal? " + biPredicate.test("hello", "hello"));

        // BooleanSupplier example
        BooleanSupplier booleanSupplier = () -> true;
        System.out.println("Boolean value: " + booleanSupplier.getAsBoolean());

        // Consumer example
        Consumer<String> consumer = s -> System.out.println("Hello, " + s);
        consumer.accept("World");

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

        // Function example
        Function<Integer, String> function = i -> "Number: " + i;
        System.out.println(function.apply(5));

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

        // Predicate example
        Predicate<String> predicate = s -> s.isEmpty();
        System.out.println("Is empty? " + predicate.test(""));

        // Supplier example
        Supplier<String> supplier = () -> "Hello, Supplier!";
        System.out.println(supplier.get());

        // ToDoubleBiFunction example
        ToDoubleBiFunction<Integer, Integer> toDoubleBiFunction = (a, b) -> a + b / 2.0;
        System.out.println("Sum and half: " + toDoubleBiFunction.applyAsDouble(10, 20));

        // ToDoubleFunction example
        ToDoubleFunction<String> toDoubleFunction = s -> s.length() * 2.0;
        System.out.println("Double length: " + toDoubleFunction.applyAsDouble("Hello"));

        // ToIntBiFunction example
        ToIntBiFunction<String, String> toIntBiFunction = (s1, s2) -> s1.length() + s2.length();
        System.out.println("Total length: " + toIntBiFunction.applyAsInt("Hello", "World"));

        // ToIntFunction example
        ToIntFunction<String> toIntFunction = s -> s.length();
        System.out.println("Length: " + toIntFunction.applyAsInt("Hello"));

        // ToLongBiFunction example
        ToLongBiFunction<String, String> toLongBiFunction = (s1, s2) -> s1.length() + s2.length();
        System.out.println("Total length: " + toLongBiFunction.applyAsLong("Hello", "World"));

        // ToLongFunction example
        ToLongFunction<String> toLongFunction = s -> s.length();
        System.out.println("Length: " + toLongFunction.applyAsLong("Hello"));
    }
}
