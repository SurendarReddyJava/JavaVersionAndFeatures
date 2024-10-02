package com.soori.java8.parallel.arraysort;
import java.util.Arrays;

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
    }
}
