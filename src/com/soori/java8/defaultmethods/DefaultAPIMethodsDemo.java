package com.soori.java8.defaultmethods;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class DefaultAPIMethodsDemo {
	public static void main(String[] args) {
		List<String> cities = new ArrayList<>();
		cities.add("New York");
		cities.add("Tokyo");
		cities.add("Paris");
		cities.add("London");
		cities.add("Delhi");

//1) forEach method demonstration
		System.out.println("Cities:");
		cities.forEach(city -> System.out.println(city));

//2) removeIf method demonstration
		Predicate<String> startsWithP = city -> city.startsWith("P");
		cities.removeIf(startsWithP);
		System.out.println("\nCities after removing those starting with 'P':");
		cities.forEach(System.out::println);

//3) spliterator method demonstration
		Spliterator<String> spliterator = cities.spliterator();
		System.out.println("\nSpliterator characteristics: " + spliterator.characteristics());
		System.out.println("Estimated size: " + spliterator.estimateSize());

		System.out.println("\nCities using Spliterator:");
		spliterator.forEachRemaining(System.out::println);

//4) replaceAll method demonstration
		UnaryOperator<String> toUpperCase = String::toUpperCase;
		cities.replaceAll(toUpperCase);
		System.out.println("Cities after replaceAll (toUpperCase):");
		cities.forEach(System.out::println);

//5) sort method demonstration
//		Comparator<String> alphabeticalOrder = String::compareTo;
		Comparator<String> alphabeticalOrder = Comparator.naturalOrder();
		cities.sort(alphabeticalOrder);
		System.out.println("\nCities after sort (alphabetical order):");
		cities.forEach(System.out::println);

//6) sort method demonstration with reverse order
		Comparator<String> reverseOrder = Comparator.reverseOrder();
		cities.sort(reverseOrder);
		System.out.println("\nCities after sort (reverse order):");
		cities.forEach(System.out::println);
		
		
		Map<String, Integer> map = new HashMap<>();
        map.put("John", 20);
        map.put("Paul", 30);
        map.put("Peter", 40);
        
//forEach method demonstration
        System.out.println("Using forEach method:");
        BiConsumer<String, Integer> action = (key, value) -> System.out.println("Key: " + key + ", Value: " + value);
        map.forEach(action);

//replaceAll method demonstration
        System.out.println("\nUsing replaceAll method:");
        BiFunction<String, Integer, Integer> incrementByTen = (key, value) -> value + 10;
        map.replaceAll(incrementByTen);
        map.forEach(action);

//putIfAbsent method demonstration
        System.out.println("\nUsing putIfAbsent method:");
        map.putIfAbsent("Kelly", 50);
        map.forEach(action);

//remove method demonstration
        System.out.println("\nUsing remove method:");
        map.remove("Peter", 50);
        map.forEach(action);

//replace method demonstration
        System.out.println("\nUsing replace method:");
        map.replace("Paul", 59);
        map.forEach(action);

//computeIfAbsent method demonstration
        System.out.println("\nUsing computeIfAbsent method:");
        Function<String, Integer> computeValue = key -> 100;
        map.computeIfAbsent("George", computeValue);//calculation applied only key absent 
        map.computeIfAbsent("Paul", computeValue);//calculation applied only key absent,As paul available as 59, it remains same 
        map.forEach(action);

//computeIfPresent method demonstration
        System.out.println("\nUsing computeIfPresent method:");
        BiFunction<String, Integer, Integer> computeIfPresent = (key, value) -> value + 20;
        map.computeIfPresent("John", computeIfPresent);//john present with 30, so increment by 20 => 50 
        map.forEach(action);

//compute method demonstration
        System.out.println("\nUsing compute method:");
        BiFunction<String, Integer, Integer> compute = (key, value) -> (value == null) ? 0 : value + 5;
        map.compute("Paul", compute);
        map.forEach(action);

//merge method demonstration
        System.out.println("\nUsing merge method:");
        BiFunction<Integer, Integer, Integer> mergeFunction = (oldValue, newValue) -> oldValue + newValue;
        map.merge("John", 10, mergeFunction);
        map.forEach(action);
	}
}
