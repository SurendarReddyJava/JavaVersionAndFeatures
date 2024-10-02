package com.soori.java8.defaultmethods;
import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class SpliteratorDemo {
    public static void main(String[] args) {
        List<String> cities = new ArrayList<>();
        cities.add("New York");
        cities.add("Tokyo");
        cities.add("Paris");
        cities.add("London");
        cities.add("Delhi");

        // forEach method demonstration
        System.out.println("Cities:");
        cities.forEach(city -> System.out.println(city));

        // removeIf method demonstration
        Predicate<String> startsWithP = city -> city.startsWith("P");
        cities.removeIf(startsWithP);
        System.out.println("\nCities after removing those starting with 'P':");
        cities.forEach(System.out::println);

        // spliterator method demonstration
        Spliterator<String> spliterator = cities.spliterator();
        System.out.println("\nSpliterator characteristics: " + spliterator.characteristics());
        System.out.println("Estimated size: " + spliterator.estimateSize());

        System.out.println("\nCities using Spliterator:");
        spliterator.forEachRemaining(System.out::println);

        // Demonstrating tryAdvance method
        Spliterator<String> spliterator2 = cities.spliterator();
        System.out.println("\nUsing tryAdvance method:");
        while (spliterator2.tryAdvance(city -> System.out.println("City: " + city)));

        // Demonstrating trySplit method
        Spliterator<String> spliterator3 = cities.spliterator();
        
       System.out.println("spliterator3.estimateSize() "+spliterator3.estimateSize());
        
        
        Spliterator<String> spliterator4 = spliterator3.trySplit();
        System.out.println("\nUsing trySplit method:\n");
        
        System.out.println("Second half: spliterator3");
        spliterator3.forEachRemaining(System.out::println);
        
        if (spliterator4 != null) {
            System.out.println("First half: spliterator4");
            spliterator4.forEachRemaining(System.out::println);
        }
    }
}
