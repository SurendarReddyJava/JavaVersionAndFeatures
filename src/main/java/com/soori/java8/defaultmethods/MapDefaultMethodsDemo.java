package com.soori.java8.defaultmethods;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MapDefaultMethodsDemo {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("John", 20);
        map.put("Paul", 30);
        map.put("Peter", 40);

        // forEach method demonstration
        System.out.println("Using forEach method:");
        BiConsumer<String, Integer> action = (key, value) -> System.out.println("Key: " + key + ", Value: " + value);
        map.forEach(action);

        // replaceAll method demonstration
        System.out.println("\nUsing replaceAll method:");
        BiFunction<String, Integer, Integer> incrementByTen = (key, value) -> value + 10;
        map.replaceAll(incrementByTen);
        map.forEach(action);

        // putIfAbsent method demonstration
        System.out.println("\nUsing putIfAbsent method:");
        map.putIfAbsent("Kelly", 50);
        map.forEach(action);

        // remove method demonstration
        System.out.println("\nUsing remove method:");
        map.remove("Peter", 50);
        map.forEach(action);

        // replace method demonstration
        System.out.println("\nUsing replace method:");
        map.replace("Paul", 40);
        map.forEach(action);

        // computeIfAbsent method demonstration
        System.out.println("\nUsing computeIfAbsent method:");
        Function<String, Integer> computeValue = key -> 100;
        map.computeIfAbsent("George", computeValue);
        map.forEach(action);

        // computeIfPresent method demonstration
        System.out.println("\nUsing computeIfPresent method:");
        BiFunction<String, Integer, Integer> computeIfPresent = (key, value) -> value + 20;
        map.computeIfPresent("John", computeIfPresent);
        map.forEach(action);

        // compute method demonstration
        System.out.println("\nUsing compute method:");
        BiFunction<String, Integer, Integer> compute = (key, value) -> (value == null) ? 0 : value + 5;
        map.compute("Paul", compute);
        map.forEach(action);

        // merge method demonstration
        System.out.println("\nUsing merge method:");
        BiFunction<Integer, Integer, Integer> mergeFunction = (oldValue, newValue) -> oldValue + newValue;
        map.merge("John", 10, mergeFunction);
        map.forEach(action);
    }
}
