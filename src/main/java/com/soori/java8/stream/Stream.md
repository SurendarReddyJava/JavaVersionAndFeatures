Java 8 introduced the Stream API in the `java.util.stream` package, providing a powerful and flexible way to process sequences of elements. Here are the key features and methods of the Stream API:

### Key Features

1. **Functional-Style Operations**:
   - Streams support functional-style operations on collections of objects, allowing for more readable and maintainable code.

2. **Lazy Evaluation**:
   - Stream operations are lazy, meaning they are not executed until a terminal operation is invoked. This allows for efficient processing and optimization.

3. **Pipelining**:
   - Intermediate operations return a new stream, allowing multiple operations to be chained together in a pipeline.

4. **Parallel Processing**:
   - Streams can be processed in parallel, leveraging multi-core architectures for improved performance.

### Key Methods

1. **Creation Methods**:
   - `Stream.of(T... values)`: Creates a stream from the specified values.
     ```java
     Stream<String> stream = Stream.of("a", "b", "c");
     ```
   - `Collection.stream()`: Creates a sequential stream from a collection.
     ```java
     List<String> list = Arrays.asList("a", "b", "c");
     Stream<String> stream = list.stream();
     ```
   - `Arrays.stream(T[] array)`: Creates a stream from an array.
     ```java
     String[] array = {"a", "b", "c"};
     Stream<String> stream = Arrays.stream(array);
     ```

2. **Intermediate Operations**:
   - `filter(Predicate<? super T> predicate)`: Returns a stream consisting of the elements that match the given predicate.
     ```java
     Stream<String> filtered = stream.filter(s -> s.startsWith("a"));
     ```
   - `map(Function<? super T, ? extends R> mapper)`: Returns a stream consisting of the results of applying the given function to the elements.
     ```java
     Stream<String> upperCase = stream.map(String::toUpperCase);
     ```
   - `flatMap(Function<? super T, ? extends Stream<? extends R>> mapper)`: Returns a stream consisting of the results of replacing each element with the contents of a mapped stream.
     ```java
     Stream<String> flatMapped = stream.flatMap(s -> Stream.of(s.split("")));
     ```
   - `distinct()`: Returns a stream consisting of the distinct elements.
     ```java
     Stream<String> distinct = stream.distinct();
     ```
   - `sorted()`: Returns a stream consisting of the elements sorted in natural order.
     ```java
     Stream<String> sorted = stream.sorted();
     ```
   - `peek(Consumer<? super T> action)`: Returns a stream consisting of the elements, additionally performing the provided action on each element.
     ```java
     Stream<String> peeked = stream.peek(System.out::println);
     ```
   - `limit(long maxSize)`: Returns a stream consisting of the first `maxSize` elements.
     ```java
     Stream<String> limited = stream.limit(2);
     ```
   - `skip(long n)`: Returns a stream consisting of the remaining elements after discarding the first `n` elements.
     ```java
     Stream<String> skipped = stream.skip(1);
     ```

3. **Terminal Operations**:
   - `forEach(Consumer<? super T> action)`: Performs an action for each element of the stream.
     ```java
     stream.forEach(System.out::println);
     ```
   - `toArray()`: Returns an array containing the elements of the stream.
     ```java
     String[] array = stream.toArray(String[]::new);
     ```
   - `reduce(BinaryOperator<T> accumulator)`: Performs a reduction on the elements, using an associative accumulation function, and returns an `Optional`.
     ```java
     Optional<String> reduced = stream.reduce((s1, s2) -> s1 + s2);
     ```
   - `collect(Collector<? super T, A, R> collector)`: Performs a mutable reduction operation on the elements using a `Collector`.
     ```java
     List<String> list = stream.collect(Collectors.toList());
     ```
   - `min(Comparator<? super T> comparator)`: Returns the minimum element of the stream according to the provided comparator.
     ```java
     Optional<String> min = stream.min(Comparator.naturalOrder());
     ```
   - `max(Comparator<? super T> comparator)`: Returns the maximum element of the stream according to the provided comparator.
     ```java
     Optional<String> max = stream.max(Comparator.naturalOrder());
     ```
   - `count()`: Returns the count of elements in the stream.
     ```java
     long count = stream.count();
     ```
   - `anyMatch(Predicate<? super T> predicate)`: Returns whether any elements match the provided predicate.
     ```java
     boolean anyMatch = stream.anyMatch(s -> s.startsWith("a"));
     ```
   - `allMatch(Predicate<? super T> predicate)`: Returns whether all elements match the provided predicate.
     ```java
     boolean allMatch = stream.allMatch(s -> s.startsWith("a"));
     ```
   - `noneMatch(Predicate<? super T> predicate)`: Returns whether no elements match the provided predicate.
     ```java
     boolean noneMatch = stream.noneMatch(s -> s.startsWith("a"));
     ```
   - `findFirst()`: Returns the first element of the stream.
     ```java
     Optional<String> first = stream.findFirst();
     ```
   - `findAny()`: Returns any element of the stream.
     ```java
     Optional<String> any = stream.findAny();
     ```

### Example Usage

Here's a complete example demonstrating the use of various Stream API features:

```java
import java.util.*;
import java.util.stream.*;

public class StreamExample {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");

        // Creating a stream
        Stream<String> stream = list.stream();

        // Intermediate operations
        Stream<String> filtered = stream.filter(s -> s.startsWith("a"));
        Stream<String> upperCase = filtered.map(String::toUpperCase);
        Stream<String> sorted = upperCase.sorted();

        // Terminal operation
        List<String> result = sorted.collect(Collectors.toList());

        // Print the result
        result.forEach(System.out::println);
    }
}
