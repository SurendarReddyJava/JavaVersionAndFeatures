package com.soori.java8.parallel.arraysort;
import java.util.Arrays;
import java.util.Random;

public class ParallelArraySorting {
    public static void main(String[] args) {
        int[] numbers = {9, 8, 7, 6, 3, 1};
        
        System.out.println("Unsorted Array: ");
        Arrays.stream(numbers).forEach(n -> System.out.print(n + " "));
        System.out.println();
        
// Parallel sorting
        Arrays.parallelSort(numbers);
        
        System.out.println("Sorted Array: ");
        Arrays.stream(numbers).forEach(n -> System.out.print(n + " "));
        
        int[] numbers1 = new int[1000000];
        Random rand = new Random();
        
        for (int i = 0; i < numbers1.length; i++) {
        	numbers1[i] = rand.nextInt();
        }
        
// Serial sort
        int[] numbersCopy1 = Arrays.copyOf(numbers1, numbers1.length);
        long startTime = System.nanoTime();
        Arrays.sort(numbersCopy1);
        long endTime = System.nanoTime();
        System.out.println("\nTime taken by Serial Sort (in ns): " + (endTime - startTime));
        
// Parallel sort
        int[] numbersCopy2 = Arrays.copyOf(numbers1, numbers1.length);
        startTime = System.nanoTime();
        Arrays.parallelSort(numbersCopy2);
        endTime = System.nanoTime();
        System.out.println("Time taken by Parallel Sort (in ns): " + (endTime - startTime));
        
    }
}
