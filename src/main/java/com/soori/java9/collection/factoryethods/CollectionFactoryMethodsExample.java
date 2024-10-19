package com.soori.java9.collection.factoryethods;

import java.util.List;
import java.util.Set;
import java.util.Map;

public class CollectionFactoryMethodsExample {
	public static void main(String[] args) {
		// Creating an immutable List
		List<String> immutableList = List.of("Java", "Python", "C++");
		System.out.println("Immutable List: " + immutableList);

		// Creating an immutable Set
		Set<String> immutableSet = Set.of("Apple", "Banana", "Cherry");
		System.out.println("Immutable Set: " + immutableSet);

		// Creating an immutable Map
		Map<Integer, String> immutableMap = Map.of(1, "One", 2, "Two", 3, "Three");
		System.out.println("Immutable Map: " + immutableMap);

		// Creating an immutable Map using Map.ofEntries
		Map<Integer, String> immutableMapEntries = Map.ofEntries(Map.entry(1, "One"), Map.entry(2, "Two"),
				Map.entry(3, "Three"));
		System.out.println("Immutable Map (ofEntries): " + immutableMapEntries);

		// Attempting to modify the collections will throw UnsupportedOperationException
		try {
			immutableList.add("Ruby");
		} catch (UnsupportedOperationException e) {
			System.out.println("Cannot modify immutable list");
		}

		try {
			immutableSet.add("Date");
		} catch (UnsupportedOperationException e) {
			System.out.println("Cannot modify immutable set");
		}

		try {
			immutableMap.put(4, "Four");
		} catch (UnsupportedOperationException e) {
			System.out.println("Cannot modify immutable map");
		}
	}
}
