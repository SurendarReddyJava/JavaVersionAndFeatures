Java 8 introduced the `parallelSort` method in the `java.util.Arrays` class, which allows for parallel sorting of arrays. This method leverages the Fork/Join framework to divide the array into sub-arrays, sort them in parallel, and then merge the sorted sub-arrays. This can significantly improve performance for large arrays by utilizing multiple CPU cores.

### Key Features of `parallelSort`
1. **Parallel Processing**:
   - Utilizes multiple threads to sort different parts of the array simultaneously.
2. **Fork/Join Framework**:
   - Uses the Fork/Join framework to divide the array into smaller parts, sort them, and then merge the results.
3. **Overloaded Methods**:
   - Available for all primitive data types and `Comparable` objects.

### Example

Here's a simple example demonstrating the use of `Arrays.parallelSort`:

```java
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
```

### Explanation
1. **Unsorted Array**:
   - The array is printed in its original, unsorted state.
2. **Parallel Sorting**:
   - `Arrays.parallelSort(numbers)` sorts the array in parallel.
3. **Sorted Array**:
   - The sorted array is printed.

### Performance Comparison

To illustrate the performance benefits, here's an example comparing `Arrays.sort` and `Arrays.parallelSort`:

```java
import java.util.Arrays;
import java.util.Random;

public class ParallelSortPerformance {
    public static void main(String[] args) {
        int[] numbers = new int[1000000];
        Random rand = new Random();
        
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt();
        }
        
        // Serial sort
        int[] numbersCopy1 = Arrays.copyOf(numbers, numbers.length);
        long startTime = System.nanoTime();
        Arrays.sort(numbersCopy1);
        long endTime = System.nanoTime();
        System.out.println("Time taken by Serial Sort (in ns): " + (endTime - startTime));
        
        // Parallel sort
        int[] numbersCopy2 = Arrays.copyOf(numbers, numbers.length);
        startTime = System.nanoTime();
        Arrays.parallelSort(numbersCopy2);
        endTime = System.nanoTime();
        System.out.println("Time taken by Parallel Sort (in ns): " + (endTime - startTime));
    }
}
```

### Explanation
1. **Array Initialization**:
   - An array of 1,000,000 random integers is created.
2. **Serial Sort**:
   - The array is sorted using `Arrays.sort`, and the time taken is measured.
3. **Parallel Sort**:
   - The array is sorted using `Arrays.parallelSort`, and the time taken is measured.
