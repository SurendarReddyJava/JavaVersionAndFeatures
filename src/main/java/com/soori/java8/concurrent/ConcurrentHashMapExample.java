package com.soori.java8.concurrent;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {
	public static void main(String[] args) {
		ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
		map.put("A", 1);
		map.put("B", 2);
		map.put("C", 3);

		// forEach
		map.forEach(1, (key, value) -> System.out.println(key + ": " + value));

		// search
		String result = map.search(1, (key, value) -> {
			if (value == 3) {
				return key;
			}
			return null;
		});
		System.out.println("Search result: " + result);

		// reduce
		int sum = map.reduce(1, (key, value) -> value, Integer::sum);
		System.out.println("Sum of values: " + sum);
	}
}
