package com.soori.java9.streamapi;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiEnhancementsExample {
	public static void main(String[] args) {
// Example of Stream.ofNullable()
		String nullableValue = null;
		Stream<String> nullableStream = Stream.ofNullable(nullableValue);
		System.out.println("Using Stream.ofNullable():");
		nullableStream.forEach(System.out::println); // No output as value is null

// Example of takeWhile() and dropWhile()
		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		System.out.println("\nUsing takeWhile():");
		List<Integer> taken = numbers.stream().takeWhile(n -> n < 5).collect(Collectors.toList());
		System.out.println("Taken: " + taken); // Output: [1, 2, 3, 4]

		System.out.println("\nUsing dropWhile():");
		List<Integer> dropped = numbers.stream().dropWhile(n -> n < 5).collect(Collectors.toList());
		System.out.println("Dropped: " + dropped); // Output: [5, 6, 7, 8, 9, 10]

// Example of iterate() method
		System.out.println("\nUsing Stream.iterate():");
		Stream<Integer> infiniteStream = Stream.iterate(1, n -> n + 1).filter(n -> n <= 10).limit(10);
		infiniteStream.forEach(System.out::println); // Output: 1 to 10

// Example of new factory methods for collections
		System.out.println("\nUsing Set.of() and Streams:");
		Set<String> set = Set.of("a", "b", "c", "d");
		List<String> list = set.stream().filter(s -> s.compareTo("b") > 0).collect(Collectors.toList());
		System.out.println("List: " + list); // Output: [c, d]

// Example of Optional.stream()
		System.out.println("\nUsing Optional.stream():");
		Optional<String> optionalValue = Optional.of("Hello, World!");
		optionalValue.stream().forEach(System.out::println); // Output: Hello, World!
	}
}
