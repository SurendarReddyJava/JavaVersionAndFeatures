
# Java versions and their release dates

| Java Version      | Approximate Release Date |
|-------------------|---|
| JDK 1.0           | January 23, 1996 |
| JDK 1.1           | February 19, 1997 |
| J2SE 1.2 (Java 2) | December 8, 1998 |
| J2SE 1.3          | May 8, 2000 |
| J2SE 1.4          | February 6, 2002 |
| J2SE 5.0 (Java 5) | September 30, 2004 |
| Java SE 6         | December 11, 2006 |
| Java SE 7         | July 28, 2011 |
| Java SE 8-LTS       | March 18, 2014 |
| Java SE 9         | September 21, 2017 |
| Java SE 10        | March 20, 2018 |
| Java SE 11-LTS    | September 25, 2018 |
| Java SE 12        | March 19, 2019 |
| Java SE 13        | September 17, 2019 |
| Java SE 14        | March 17, 2020 |
| Java SE 15        | September 15, 2020 |
| Java SE 16        | March 16, 2021 |
| Java SE 17-LTS    | September 14, 2021 |
| Java SE 18        | March 22, 2022 |
| Java SE 19        | September 20, 2022 |
| Java SE 20        | March 21, 2023 |
| Java SE 21-LTS    | September 19, 2023 |


# Java 8: A Deep Dive into Key Features

Java 8 marked a significant milestone in the evolution of the Java programming language, introducing several powerful features designed to enhance code readability, efficiency, and expressiveness.  Let's explore these key features in detail:

## 1. Lambda Expressions

Lambda expressions provide a concise way to represent anonymous functions. They're particularly useful for implementing functional interfaces (interfaces with a single abstract method).

**Syntax:**

`(parameters) -> expression`  // For single-expression lambdas

`(parameters) -> { statements; }` // For multi-statement lambdas

**Example:**

```java
import java.util.Arrays;
import java.util.List;

public class LambdaExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ramesh", "Suresh", "Kamlesh", "Priya");

        names.forEach(name -> System.out.println(name)); 
    }
}
```

This example uses a lambda expression `name -> System.out.println(name)` to iterate and print each name in the list.


## 2. Functional Interfaces

A functional interface is an interface with exactly one abstract method.  The `@FunctionalInterface` annotation (optional but recommended) marks an interface as a functional interface.  Lambda expressions are used to implement these interfaces.

**Example:**

```java
@FunctionalInterface
interface GreetingService {
    void sayMessage(String message);
}

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        GreetingService greet = message -> System.out.println("Hello, " + message);
        greet.sayMessage("Ramesh");
    }
}
```

`GreetingService` is a functional interface. The lambda expression `message -> System.out.println("Hello, " + message)` provides the implementation for `sayMessage`.


## 3. Streams API

The Streams API introduces a new way to process collections of data in a declarative and functional style.  It supports operations like filtering, mapping, sorting, and reducing.

**Example:**

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> evenNumbers = numbers.stream()
                                           .filter(n -> n % 2 == 0)
                                           .collect(Collectors.toList());

        System.out.println("Even Numbers: " + evenNumbers);
    }
}
```

This code creates a stream from a list of numbers, filters for even numbers, and collects the results into a new list.


## 4. Optional Class

The `Optional` class helps to handle situations where a value might be absent. It avoids `NullPointerExceptions` by explicitly representing the possibility of a missing value.

**Example:**

```java
import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        Optional<String> optionalName = Optional.of("Ramesh");

        if (optionalName.isPresent()) {
            System.out.println("Name: " + optionalName.get());
        }

        optionalName.ifPresent(name -> System.out.println("Hello, " + name));
    }
}
```

`Optional.of("Ramesh")` creates an `Optional` containing a value.  `isPresent()` checks for the presence of a value, and `ifPresent()` executes a lambda expression if a value is present.


## 5. Default and Static Methods in Interfaces

Java 8 allows adding default and static methods to interfaces.  Default methods provide default implementations, avoiding breaking changes when adding new methods to existing interfaces. Static methods belong to the interface itself, not to its implementations.

**Example:**

```java
interface Vehicle {
    default void print() {
        System.out.println("I am a vehicle");
    }

    static void blowHorn() {
        System.out.println("Blowing horn");
    }
}

public class DefaultMethodExample implements Vehicle {
    public static void main(String[] args) {
        DefaultMethodExample car = new DefaultMethodExample();
        car.print();
        Vehicle.blowHorn();
    }
}
```


## 6. New Date and Time API (java.time)

The `java.time` package provides a comprehensive and improved date and time API, replacing the older `java.util.Date` and `java.util.Calendar` classes.

**Example:**

```java
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

public class DateTimeExample {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dateTime = LocalDateTime.now();
        LocalDate specificDate = LocalDate.of(2023, 8, 10);

        System.out.println("Current Date: " + date);
        System.out.println("Current Time: " + time);
        System.out.println("Current Date and Time: " + dateTime);
        System.out.println("Specific Date: " + specificDate);
    }
}
```


## 7. Nashorn JavaScript Engine

Nashorn allowed execution of JavaScript code directly within Java applications.  (Note: Nashorn is deprecated in later Java versions.)


## 8. Parallel Array Sorting

`Arrays.parallelSort()` provides a parallel sorting algorithm for arrays, potentially improving performance for large datasets.


## 9. Type Annotations

Type annotations allow annotations to be applied to types, providing more fine-grained control over metadata associated with types.


## 10. Method References

Method references offer a concise syntax for referring to existing methods, often simplifying lambda expressions.

**Example:**

```java
import java.util.Arrays;
import java.util.List;

public class MethodReferenceExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ramesh", "Suresh", "Kamlesh");
        names.forEach(System.out::println);
    }
}
```

`System.out::println` is a method reference, directly calling the `println` method.


## 11. Collectors

Collectors are used with the Streams API to perform terminal operations, accumulating results into various data structures (like lists, maps, etc.).

## 12. New Files API (NIO.2)

The Java 8 release significantly enhanced the `java.nio.file` package, introducing the NIO.2 API. This API provides a more robust and feature-rich approach to file system interactions compared to older methods.  It offers improved capabilities for handling files, directories, and overall file system access.  Key improvements include streamlined directory stream handling, efficient file reading and writing, and more comprehensive file system access control.


### Key Features of NIO.2

* **Path API:**  The `Path` interface represents a file or directory path in an abstract way, making code more portable across different operating systems.
* **Files Class:** This class offers static methods for various file operations, like creating, deleting, copying, moving, and reading files.
* **Directory Stream:**  Provides an efficient way to iterate through directories and their contents.
* **Watch Service:** Allows monitoring of file system changes (creation, modification, deletion) in a non-blocking manner.
* **File Attributes:**  Access to various file attributes (size, last modified time, permissions, etc.).


### Example: Reading and Writing Files with NIO.2

This example demonstrates basic file reading and writing using the `Files` class:

```java
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FilesExample {
    public static void main(String[] args) {
        String filePath = "example.txt";

        try {
            // Writing to a file
            Files.write(Paths.get(filePath), "Hello, Ramesh!".getBytes());

            // Reading from a file
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            lines.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

**Explanation:**

1. **`Files.write(Paths.get(filePath), "Hello, Ramesh!".getBytes())`**: This line writes the string "Hello, Ramesh!" to the file specified by `filePath`.  `Paths.get(filePath)` creates a `Path` object, and `.getBytes()` converts the string into a byte array suitable for writing.

2. **`Files.readAllLines(Paths.get(filePath))`**: This line reads all lines from the file into a `List<String>`.

3. **`lines.forEach(System.out::println)`**: This iterates through the list of lines and prints each line to the console.

4. **`try-catch` block**:  Handles potential `IOExceptions` that might occur during file operations.


This example showcases the simplicity and efficiency of the NIO.2 API for common file operations.  More advanced features, such as directory traversal and file system monitoring, can be explored using other classes and methods within the `java.nio.file` package.


# Java 9: Key Features and Enhancements

Java 9, released in 2017, introduced a significant number of features aimed at improving performance, developer productivity, and overall application development. This guide explores the key enhancements.


## 1. Private Methods in Interfaces

Java 9 allows interfaces to contain private methods. This facilitates code reuse among default methods within the same interface, promoting better organization and reducing redundancy.

**Example:**

```java
interface MyInterface {
    default void defaultMethod() {
        System.out.println("Default Method");
        privateMethod();
    }

    private void privateMethod() {
        System.out.println("Private Method");
    }
}

public class PrivateMethodsExample {
    public static void main(String[] args) {
        MyInterface myInterface = new MyInterface() {};
        myInterface.defaultMethod();
    }
}
```

**Output:**

```
Default Method
Private Method
```

The `privateMethod()` is called by the `defaultMethod()`, demonstrating code sharing within the interface.


## 2. Immutable Collections

Java 9 introduced static factory methods (`List.of()`, `Set.of()`, `Map.of()`) for creating immutable collections. These methods provide a convenient way to create collections whose contents cannot be modified after creation, enhancing thread safety and predictability.

**Example:**

```java
import java.util.List;
import java.util.Set;
import java.util.Map;

public class ImmutableCollectionsExample {
    public static void main(String[] args) {
        List<String> immutableList = List.of("A", "B", "C");
        Set<String> immutableSet = Set.of("X", "Y", "Z");
        Map<String, Integer> immutableMap = Map.of("One", 1, "Two", 2);

        System.out.println("Immutable List: " + immutableList);
        System.out.println("Immutable Set: " + immutableSet);
        System.out.println("Immutable Map: " + immutableMap);
    }
}
```

**Output:**

```
Immutable List: [A, B, C]
Immutable Set: [X, Y, Z]
Immutable Map: {One=1, Two=2}
```


## 3. Stream API Improvements

The Stream API received several enhancements, including the addition of `takeWhile()`, `dropWhile()`, and improvements to `iterate()`. These methods provide more flexible and concise ways to process streams.

**Example:**

```java
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamImprovementsExample {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        List<Integer> taken = numbers.stream().takeWhile(n -> n < 5).collect(Collectors.toList());
        List<Integer> dropped = numbers.stream().dropWhile(n -> n < 5).collect(Collectors.toList());
        Stream<Integer> iterated = Stream.iterate(0, n -> n < 10, n -> n + 2);

        System.out.println("takeWhile: " + taken);
        System.out.println("dropWhile: " + dropped);
        iterated.forEach(System.out::println);
    }
}
```

**Output:**

```
takeWhile: [1, 2, 3, 4]
dropWhile: [5, 6, 7, 8, 9]
0
2
4
6
8
```


## 4. Optional Class Improvements

The `Optional` class gained new methods like `ifPresentOrElse()`, `or()`, and `stream()`, offering more expressive ways to handle potentially missing values.

**Example:**

```java
import java.util.Optional;

public class OptionalImprovementsExample {
    public static void main(String[] args) {
        Optional<String> optionalValue = Optional.of("Java 9");

        optionalValue.ifPresentOrElse(value -> System.out.println("Value: " + value), () -> System.out.println("Value not present"));
        Optional<String> alternative = optionalValue.or(() -> Optional.of("Alternative"));
        optionalValue.stream().forEach(System.out::println);

        System.out.println("Alternative: " + alternative.get());
    }
}
```

**Output:**

```
Value: Java 9
Java 9
Alternative: Java 9
```


## 5. JShell: The Interactive Java Shell

JShell is an interactive REPL (Read-Eval-Print Loop) for Java.  It allows developers to execute Java code snippets quickly without needing a full compilation and execution cycle.  This is invaluable for testing, experimenting, and learning.


## 6. Module System (Project Jigsaw)

The Java Platform Module System (JPMS), also known as Project Jigsaw, is a major architectural change.  It allows developers to create modular applications, improving encapsulation, maintainability, and reducing dependencies.  (Explaining modules in detail would require a separate, extensive document.)


## 7. HTTP/2 Client

Java 9 introduced a new, more efficient HTTP client supporting HTTP/2, WebSockets, and asynchronous operations.


## 8. Process API Improvements

The `Process` API received enhancements, offering more control over native processes, including improved management of process trees and access to process information.


## 9. Miscellaneous Changes

Java 9 included many other smaller but significant changes:  Multi-Release JARs, unified JVM logging, enhanced `@Deprecated` annotation, and compact strings (using byte arrays for strings).


## 10. Summary

Java 9 significantly advanced the Java platform with features designed to improve both developer experience and application performance.  The module system, in particular, represents a fundamental shift in how Java applications are structured and managed.  The other enhancements, such as improvements to Streams, Optional, and the HTTP client, contribute to a more modern and efficient development environment.



# Java 10: Key Features and Enhancements

Java 10, released in March 2018, brought several significant improvements focusing on developer productivity and application performance.  This guide details the key features.


## 1. Local-Variable Type Inference (`var`)

Java 10 introduced the `var` keyword, enabling local variable type inference. The compiler infers the type based on the initializer, leading to more concise and readable code.

**Example:**

```java
import java.util.ArrayList;
import java.util.HashMap;

public class VarExample {
    public static void main(String[] args) {
        var list = new ArrayList<String>();
        list.add("Java 10");
        list.add("Local-Variable Type Inference");

        var map = new HashMap<String, Integer>();
        map.put("Java", 10);

        for (var item : list) {
            System.out.println(item);
        }

        for (var entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
```

**Output:**

```
Java 10
Local-Variable Type Inference
Java: 10
```

Note that `var` is only applicable to local variables with initializers; it cannot be used for method parameters or class fields.


## 2. Enhanced Immutable Collections

Java 10 extended the capabilities for creating immutable collections.


### 2.1 `List.copyOf()`, `Set.copyOf()`, `Map.copyOf()`

These methods create unmodifiable copies of existing collections.


**Example:**

```java
import java.util.List;
import java.util.Set;
import java.util.Map;

public class ImmutableCollectionsExample {
    public static void main(String[] args) {
        List<String> originalList = List.of("A", "B", "C");
        List<String> immutableList = List.copyOf(originalList);

        Set<String> originalSet = Set.of("X", "Y", "Z");
        Set<String> immutableSet = Set.copyOf(originalSet);

        Map<String, Integer> originalMap = Map.of("One", 1, "Two", 2);
        Map<String, Integer> immutableMap = Map.copyOf(originalMap);

        System.out.println("Immutable List: " + immutableList);
        System.out.println("Immutable Set: " + immutableSet);
        System.out.println("Immutable Map: " + immutableMap);
    }
}
```

**Output:**

```
Immutable List: [A, B, C]
Immutable Set: [X, Y, Z]
Immutable Map: {One=1, Two=2}
```


### 2.2 `Collectors.toUnmodifiableList()`, `toUnmodifiableSet()`, `toUnmodifiableMap()`

These collectors create unmodifiable collections from streams.

**Example:**

```java
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UnmodifiableCollectorsExample {
    public static void main(String[] args) {
        List<String> list = Stream.of("Java", "10", "Features").collect(Collectors.toUnmodifiableList());
        Set<String> set = Stream.of("A", "B", "C").collect(Collectors.toUnmodifiableSet());
        Map<String, Integer> map = Stream.of("One", "Two")
                .collect(Collectors.toUnmodifiableMap(s -> s, s -> s.length()));

        System.out.println("Unmodifiable List: " + list);
        System.out.println("Unmodifiable Set: " + set);
        System.out.println("Unmodifiable Map: " + map);
    }
}
```

**Output:**

```
Unmodifiable List: [Java, 10, Features]
Unmodifiable Set: [A, B, C]
Unmodifiable Map: {One=3, Two=3}
```


## 3. `Optional.orElseThrow()`

This new method in the `Optional` class returns the contained value if present, otherwise it throws a `NoSuchElementException`.  It provides a more concise way to handle potentially missing values compared to previous approaches.


## 4. Time-Based Release Versioning

Java 10 shifted to a time-based release model, with feature releases every six months and Long-Term Support (LTS) releases every three years.  This provides more predictable release cycles.


## 5. Parallel Full GC for G1

Java 10 improved the G1 garbage collector by enabling parallel processing during full garbage collections, leading to reduced pause times and better performance, especially for applications with large heaps.


## 6. Application Class-Data Sharing (AppCDS)

AppCDS extends the existing Class-Data Sharing (CDS) to include application classes, further reducing startup time and memory footprint by sharing data across multiple JVM instances.  (Detailed steps for using AppCDS are beyond the scope of this concise summary).


## 7. Experimental Java-Based JIT Compiler (Graal)

Graal, an experimental Java-based JIT compiler, was introduced.  (Enabling Graal requires specific JVM flags).


## 8. Other Changes in Java 10

Several other improvements were included, such as support for heap allocation on alternative memory devices, additional Unicode language-tag extensions, a new garbage collector interface, a default set of root certificates, thread-local handshakes, and removal of the `javah` tool.


## 9. Conclusion

Java 10 delivered notable enhancements, improving developer productivity and application performance.  Features like `var`, immutable collection improvements, and AppCDS are particularly impactful for modern Java development.


# Java 11: Key Features and Enhancements

Java 11, released in September 2018 as a Long-Term Support (LTS) version, brought many significant features and improvements to the Java platform.  This guide explores the key additions.


## 1. Local-Variable Syntax for Lambda Parameters

Java 11 extends the `var` keyword to lambda expressions, enabling local variable type inference for lambda parameters. This improves consistency and flexibility.

**Example:**

```java
import java.util.List;
import java.util.function.Consumer;

public class VarInLambdaExample {
    public static void main(String[] args) {
        List<String> list = List.of("Java", "11", "Features");

        Consumer<String> consumer = (var item) -> System.out.println(item);
        list.forEach(consumer);
    }
}
```

**Output:**

```
Java
11
Features
```

The `var` keyword infers the type of the `item` parameter within the lambda expression.


## 2. Standardized HTTP Client

The HTTP Client, initially previewed in Java 9, became a standard feature in Java 11. This modern API supports HTTP/1.1 and HTTP/2, providing a robust and feature-rich mechanism for making HTTP requests.

**Example: HTTP GET Request**

```java
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientExample {
    public static void main(String[] args) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                                         .uri(new URI("https://jsonplaceholder.typicode.com/posts/1"))
                                         .GET()
                                         .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Response: " + response.body());
    }
}
```

**Output:** (will vary slightly depending on the API response)

```json
Response: {
  "userId": 1,
  "id": 1,
  "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
  "body": "quia et suscipit\nsuscipit..."
}
```


## 3. New `Collection.toArray()` Method

A new `toArray(IntFunction<T[]>)` method was added to the `Collection` interface. This improves type safety and performance when converting collections to arrays.

**Example:**

```java
import java.util.List;

public class CollectionToArrayExample {
    public static void main(String[] args) {
        List<String> list = List.of("Java", "11", "Features");
        String[] array = list.toArray(String[]::new);

        for (String item : array) {
            System.out.println(item);
        }
    }
}
```

**Output:**

```
Java
11
Features
```


## 4. New String Methods

Several helpful methods were added to the `String` class:

*   `isBlank()`: Checks if a string is empty or contains only whitespace.
*   `lines()`: Returns a stream of lines from the string.
*   `strip()`, `stripLeading()`, `stripTrailing()`: Remove leading/trailing/all whitespace.
*   `repeat()`: Repeats a string a specified number of times.  (Examples for each of these are provided in the original text).


## 5. `Files.readString()` and `writeString()`

These new methods in the `Files` class simplify file I/O by directly reading and writing strings to files. (Example provided in the original text).


## 6. `Path.of()`

`Path.of()` provides a more concise and readable way to create `Path` instances compared to the older `Paths.get()`. (Example and comparison provided in the original text).


## 7. Epsilon: A No-Op Garbage Collector

Epsilon is a garbage collector that performs no memory reclamation. It's useful for specialized scenarios like performance testing and short-lived applications where garbage collection overhead is undesirable. (Enabling Epsilon requires specific JVM flags).


## 8. Launch Single-File Source-Code Programs

Java 11 allows the direct execution of single Java source files without explicit compilation. This simplifies testing and quick code experiments. (Example provided in the original text).


## 9. Nest-Based Access Control

This feature enhances encapsulation by allowing classes within a "nest" (logically grouped classes) to access each other's private members. (Example provided in the original text).


## 10. Enhanced Analysis Tools

Java 11 improved tools for analyzing application performance:

*   **Java Flight Recorder (JFR):**  A powerful profiling tool for recording detailed runtime information. (Enabling JFR requires JVM flags).
*   **Low-Overhead Heap Profiling:** Provides heap usage details with minimal performance impact. (Enabling this requires JVM flags).


## 11. Experimental and Preview Features

Java 11 included experimental features like ZGC (Z Garbage Collector), a scalable, low-latency garbage collector designed for large heaps. (Enabling ZGC requires JVM flags).


## 12. Deprecations and Removals

Several features were deprecated or removed in Java 11, reflecting the ongoing evolution of the platform.  Key examples include the removal of Java EE and CORBA modules, and the deprecation of the Nashorn JavaScript engine and Pack200 tools.


## 13. Other Changes

Other enhancements in Java 11 include: support for Unicode 10; improvements to Aarch64 intrinsics; support for TLS 1.3;  addition of ChaCha20 and Poly1305 cryptographic algorithms; support for key agreement with Curve25519 and Curve448; and dynamic class-file constants.


## Conclusion

Java 11, as an LTS release, provided substantial improvements to the Java platform.  Features like the standardized HTTP client, improved string methods, and enhanced analysis tools significantly benefit developers and application performance.


# Java 12: Key Features and Enhancements

Java 12, released in March 2019 (a non-LTS release), brought several notable improvements to developer productivity and application performance.  This guide details the key features.


## 1. New String and Files Methods

Java 12 enhanced the `String` and `Files` classes with new methods.


### 1.1 `String.indent()`

This method adjusts the indentation of each line in a string, adding or removing spaces from the beginning of each line.

**Example:**

```java
public class StringIndentExample {
    public static void main(String[] args) {
        String text = "Java\nFeatures\nIndentation";

        String indentedText = text.indent(4);
        String reducedIndentationText = indentedText.indent(-2);

        System.out.println("Original Text:\n" + text);
        System.out.println("Indented Text:\n" + indentedText);
        System.out.println("Reduced Indentation Text:\n" + reducedIndentationText);
    }
}
```

**Output:**

```
Original Text:
Java
Features
Indentation
Indented Text:
    Java
    Features
    Indentation
Reduced Indentation Text:
  Java
  Features
  Indentation
```


### 1.2 `String.transform()`

This method applies a function to a string and returns the result, enabling chained transformations.

**Example:**

```java
import java.util.Locale;

public class StringTransformExample {
    public static void main(String[] args) {
        String text = "java features";
        String transformedText = text.transform(s -> s.toUpperCase(Locale.ROOT) + " - Java 12");

        System.out.println("Original Text: " + text);
        System.out.println("Transformed Text: " + transformedText);
    }
}
```

**Output:**

```
Original Text: java features
Transformed Text: JAVA FEATURES - Java 12
```


### 1.3 `Files.mismatch()`

This method compares two files byte by byte and returns the position of the first differing byte (-1 if identical).

**Example:**

```java
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

public class FilesMismatchExample {
    public static void main(String[] args) {
        try {
            Path file1 = Files.createTempFile("file1", ".txt");
            Path file2 = Files.createTempFile("file2", ".txt");

            Files.writeString(file1, "Java 12 Features");
            Files.writeString(file2, "Java 12 Features");

            long mismatchPosition = Files.mismatch(file1, file2);
            System.out.println("Mismatch Position: " + mismatchPosition);

            Files.writeString(file2, "Java 12 New Features");
            mismatchPosition = Files.mismatch(file1, file2);
            System.out.println("Mismatch Position after change: " + mismatchPosition);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

**Output:**

```
Mismatch Position: -1
Mismatch Position after change: 7
```


## 2. The Teeing Collector

The `Collectors.teeing()` method allows collecting stream elements into two separate results and then merging them.

**Example:**

```java
import java.util.List;
import java.util.stream.Collectors;

public class TeeingCollectorExample {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        var result = numbers.stream()
                .collect(Collectors.teeing(
                        Collectors.summingInt(Integer::intValue),
                        Collectors.averagingInt(Integer::intValue),
                        (sum, avg) -> "Sum: " + sum + ", Average: " + avg
                ));

        System.out.println("Result: " + result);
    }
}
```

**Output:**

```
Result: Sum: 55, Average: 5.5
```


## 3. Support for Compact Number Formatting

Java 12 added support for compact number formatting (e.g., 1.2M for 1,200,000) via `NumberFormat.getCompactNumberInstance()`.


## 4. Performance Improvements

Java 12 included several performance optimizations:

*   **Default CDS Archives:** Improved startup time and reduced memory footprint by including default Class Data Sharing (CDS) archives.
*   **Abortable Mixed Collections for G1:** Enhanced the G1 garbage collector to reduce pause times.
*   **Promptly Return Unused Committed Memory from G1:** Improved G1's memory management efficiency.


## 5. Experimental and Preview Features

Java 12 featured experimental and preview features:

*   **Switch Expressions (Preview):** A preview of a more concise and expressive switch statement syntax. (Example provided in the original text).
*   **Shenandoah: A Low-Pause-Time Garbage Collector (Experimental):**  A new garbage collector aimed at minimizing pause times, especially beneficial for large heaps.


## 6. Other Changes in Java 12

Other changes include: support for Unicode 11; a microbenchmark suite; the JVM Constants API; and the consolidation of AArch64 ports.


## Conclusion

Java 12, although a non-LTS release, brought valuable enhancements to the Java platform, improving developer productivity and application performance.  Features like the new string and file methods, the Teeing Collector, and performance optimizations are noteworthy contributions.


# Java 13: Key Features and Enhancements

Java 13, released in September 2019 (a non-LTS release), continued the evolution of the Java platform with several new features and improvements. This guide details the key enhancements.


## 1. Experimental and Preview Features

Java 13 focused heavily on refining features introduced as previews in earlier releases.


### 1.1 Switch Expressions (Second Preview)

Switch expressions, initially previewed in Java 12, returned in Java 13 with enhancements. They allow using the `switch` statement as an expression, providing a more concise syntax for handling multiple cases.

**Example:**

```java
public class SwitchExpressionsExample {
    public static void main(String[] args) {
        String day = "MONDAY";

        int result = switch (day) {
            case "MONDAY", "FRIDAY", "SUNDAY" -> 6;
            case "TUESDAY" -> 7;
            case "THURSDAY", "SATURDAY" -> 8;
            case "WEDNESDAY" -> {
                int len = day.length();
                yield len; 
            }
            default -> throw new IllegalArgumentException("Invalid day: " + day);
        };

        System.out.println("Result: " + result);
    }
}
```

**Output:**

```
Result: 6
```

The `yield` keyword is used to explicitly return a value from a switch expression block.


### 1.2 Text Blocks (Preview)

Text blocks provide a new way to define multi-line string literals, improving readability and reducing the need for escape sequences.

**Example:**

```java
public class TextBlocksExample {
    public static void main(String[] args) {
        String json = """
                      {
                          "name": "Java",
                          "version": 13,
                          "features": ["Text Blocks", "Switch Expressions"]
                      }
                      """;

        System.out.println("JSON:\n" + json);
    }
}
```

**Output:**

```json
JSON:
{
    "name": "Java",
    "version": 13,
    "features": ["Text Blocks", "Switch Expressions"]
}
```


### 1.3 ZGC: Uncommit Unused Memory (Experimental)

Java 13 enhanced the Z Garbage Collector (ZGC) to uncommit unused memory, returning it to the operating system.  This reduces the memory footprint of applications using ZGC.


## 2. Performance Improvements

Java 13 included performance enhancements:


### 2.1 Dynamic CDS Archives

Dynamic Class Data Sharing (CDS) allows the JVM to generate CDS archives at runtime, improving startup time and performance by optimizing class loading.


### 2.2 Soft Max Heap Size

The introduction of a soft max heap size enables the JVM to dynamically adjust the heap size based on the application's workload and available system resources, optimizing memory usage.


## 3. JDK Class Library Enhancements

Several JDK classes received enhancements:


### 3.1 `ByteBuffer.slice()`

A new `slice()` method was added to the `ByteBuffer` class, allowing the creation of a new buffer that shares its content with the original buffer. This improves efficiency when working with buffers.  (Example provided in the original text).


### 3.2 New `ByteBuffer.get()` and `put()` Methods

New overloaded `get()` and `put()` methods were added to `ByteBuffer`, accepting an index and an array, enhancing flexibility and performance. (Example provided in the original text).


### 3.3 `FileSystems.newFileSystem()`

A new `newFileSystem()` method in `FileSystems` allows creating file systems from a `Path` or `URI`, increasing flexibility when working with file systems. (Example provided in the original text).


## 4. Other Changes in Java 13

Other notable changes include: a reimplementation of the legacy socket API for improved performance and maintainability; and support for Unicode 12.1.


## Conclusion

Java 13, while a non-LTS release, introduced important features and refinements.  The preview features (switch expressions and text blocks) are particularly significant, shaping the future direction of the language.  The performance enhancements and JDK library improvements further solidify Java's position as a robust and efficient platform.


# Java 14: Key Features and Enhancements

Java 14, released in March 2020 (a non-LTS release), continued to evolve the Java platform with new features, improvements, and deprecations. This guide explores the key additions.


## 1. Switch Expressions (Standard)

Switch expressions, previously in preview, became a standard feature in Java 14. They provide a more concise and flexible way to use `switch` statements, improving readability and reducing boilerplate code.

**Example:**

```java
public class SwitchExpressionsExample {
    public static void main(String[] args) {
        String day = "MONDAY";

        int result = switch (day) {
            case "MONDAY", "FRIDAY", "SUNDAY" -> 6;
            case "TUESDAY" -> 7;
            case "THURSDAY", "SATURDAY" -> 8;
            case "WEDNESDAY" -> {
                int len = day.length();
                yield len; 
            }
            default -> throw new IllegalArgumentException("Invalid day: " + day);
        };

        System.out.println("Result: " + result);
    }
}
```

**Output:**

```
Result: 6
```


## 2. Helpful NullPointerExceptions

Java 14 enhances `NullPointerException` messages to provide more context, making debugging easier by pinpointing the null variable.

**Example:**

```java
public class HelpfulNPEExample {
    public static void main(String[] args) {
        String[] array = null;
        try {
            System.out.println(array.length);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
```

**Output:** (The exact message may vary slightly)

```
java.lang.NullPointerException: Cannot read the array length because "array" is null
    at HelpfulNPEExample.main(HelpfulNPEExample.java:6)
```


## 3. Experimental, Preview, and Incubator Features

Java 14 included several features in experimental, preview, or incubator stages.


### 3.1 Records (Preview)

Records provide a concise syntax for declaring data classes, automatically generating methods like `equals()`, `hashCode()`, and `toString()`.

**Example:**

```java
public record Point(int x, int y) {}

public class RecordsExample {
    public static void main(String[] args) {
        Point point = new Point(5, 10);
        System.out.println("Point: " + point);
    }
}
```

**Output:**

```
Point: Point[x=5, y=10]
```


### 3.2 Pattern Matching for `instanceof` (Preview)

This feature simplifies type checking and casting within an `instanceof` expression.

**Example:**

```java
public class PatternMatchingExample {
    public static void main(String[] args) {
        Object obj = "Java 14";
        if (obj instanceof String str) {
            System.out.println("Length: " + str.length());
        }
    }
}
```

**Output:**

```
Length: 7
```


### 3.3 Text Blocks (Second Preview)

Text blocks, previously in preview, were further refined in Java 14, providing a more convenient way to define multi-line strings. (Example provided in the original text).


### 3.4 ZGC on macOS + Windows (Experimental)

The Z Garbage Collector (ZGC) gained support for macOS and Windows platforms.


### 3.5 Packaging Tool (Incubator)

This tool helps package Java applications into self-contained executables.


### 3.6 Foreign-Memory Access API (Incubator)

This API provides a safer and more efficient way to access native memory outside the Java heap. (Example provided in the original text).


## 4. Performance Improvements

Several performance enhancements were included:

*   **Non-Volatile Mapped Byte Buffers:** Improved file I/O performance by mapping files directly into memory.
*   **NUMA-Aware Memory Allocation for G1:** Optimized memory allocation for Non-Uniform Memory Access (NUMA) architectures.
*   **Parallel GC Improvements:** Enhanced the Parallel garbage collector for better performance and reduced pause times.


## 5. Deprecations and Deletions

Several features were deprecated or removed:

*   `Thread.suspend()` and `Thread.resume()` were deprecated for removal.
*   Solaris and SPARC ports were deprecated.
*   The Concurrent Mark Sweep (CMS) garbage collector was removed.
*   The ParallelScavenge + SerialOld GC combination was deprecated.
*   The Pack200 tools and API were removed.


## 6. Other Changes in Java 14

Other additions include: JFR (Java Flight Recorder) event streaming; and accounting currency format support. (Example for accounting currency format provided in the original text).


## Conclusion

Java 14, while a non-LTS release, introduced significant features and improvements.  The standardization of switch expressions, helpful `NullPointerExceptions`, and progress on preview features like records and pattern matching for `instanceof` are highlights.  Performance optimizations and the deprecation/removal of older features further refine the Java platform.


# Java 15: Key Features and Enhancements

Java 15, released in September 2020, delivered a range of new features and improvements to the Java platform. This guide details the key enhancements.


## 1. Text Blocks (Standard)

Text blocks, previously in preview, became a standard feature in Java 15. They provide a cleaner way to define multi-line string literals, improving readability and maintainability.

**Example:**

```java
public class TextBlocksExample {
    public static void main(String[] args) {
        String json = """
                      {
                          "name": "Java",
                          "version": 15,
                          "features": ["Text Blocks", "Sealed Classes"]
                      }
                      """;

        System.out.println("JSON:\n" + json);
    }
}
```

**Output:**

```json
JSON:
{
    "name": "Java",
    "version": 15,
    "features": ["Text Blocks", "Sealed Classes"]
}
```


## 2. New Garbage Collectors: ZGC + Shenandoah

Java 15 brought two significant garbage collectors to full production status:


### 2.1 ZGC (Z Garbage Collector)

ZGC is a scalable, low-latency garbage collector designed for large heaps, minimizing pause times.

*   **Low Latency:** Concurrent operation minimizes pauses.
*   **Scalability:** Efficient handling of large heap sizes.


### 2.2 Shenandoah

Shenandoah is another low-pause-time garbage collector that performs concurrent garbage collection to improve application responsiveness.

*   **Concurrent Collection:** Reduces pause times by performing most of its work concurrently with the application.
*   **Low Pause Times:** Provides more predictable performance for memory-intensive applications.


## 3. New String and CharSequence Methods

Several new methods were added to the `String` and `CharSequence` classes:


### 3.1 `String.formatted()`

This method offers a more readable alternative to `String.format()` for creating formatted strings.  (Example provided in the original text).


### 3.2 `String.stripIndent()`

This method removes leading whitespace common to all lines in a string, useful for cleaning up text blocks. (Example provided in the original text).


### 3.3 `String.translateEscapes()`

This method translates escape sequences (like `\n`) into their corresponding characters. (Example provided in the original text).


### 3.4 `CharSequence.isEmpty()`

This method provides a concise way to check if a `CharSequence` is empty. (Example provided in the original text).


## 4. Helpful NullPointerExceptions

Java 15 further improved the helpful `NullPointerException` messages, providing more detailed information to aid debugging. (Example provided in the original text).


## 5. Performance Changes

Key performance-related changes included:


### 5.1 Disable and Deprecate Biased Locking

Biased locking was disabled and deprecated due to its complexity and potential performance issues.


### 5.2 Specialized Implementations of `TreeMap` Methods

Specialized implementations for several `TreeMap` methods (like `putIfAbsent`, `computeIfAbsent`, etc.) were introduced to improve performance. (Important considerations regarding concurrent modification are noted in the original text).


## 6. Experimental, Preview, and Incubator Features

Java 15 included several features in experimental or preview stages:


### 6.1 Sealed Classes (Preview)

Sealed classes restrict which classes can extend or implement them, enhancing encapsulation. (Example provided in the original text).


### 6.2 Pattern Matching for `instanceof` (Second Preview)

Pattern matching for `instanceof` was again offered as a preview feature. (Example provided in the original text).


### 6.3 Records (Second Preview)

Records, providing a concise way to declare data classes, were also in preview again. (Example provided in the original text).


### 6.4 Foreign-Memory Access API (Second Incubator)

The Foreign-Memory Access API, for accessing native memory, was further incubated. (Example provided in the original text).


## 7. Deprecations and Deletions

Several features were deprecated or removed:

*   The Nashorn JavaScript engine was removed.
*   Solaris and SPARC ports were removed.
*   RMI Activation was deprecated for removal.


## 8. Other Changes in Java 15

Other changes included: hidden classes; support for the Edwards-Curve Digital Signature Algorithm (EdDSA); a reimplementation of the legacy `DatagramSocket` API; compressed heap dumps; and support for Unicode 13.0.


## Conclusion

Java 15 delivered significant improvements, including the standardization of text blocks, new garbage collectors, and enhanced string methods. These enhancements boost developer productivity, application performance, and the overall flexibility of the Java platform.


# Java 16: Key Features and Enhancements

Java 16, released in March 2021 (a non-LTS release), continued to refine the Java platform with new features, performance improvements, and deprecations. This guide details the key changes.


## 1. Pattern Matching for `instanceof` (Standard)

Pattern matching for `instanceof`, previously in preview, became a standard feature in Java 16. It simplifies type checking and casting, making code more concise and readable.

**Example:**

```java
public class PatternMatchingExample {
    public static void main(String[] args) {
        Object obj = "Java 16";
        if (obj instanceof String str) {
            System.out.println("Length: " + str.length());
        }
    }
}
```

**Output:**

```
Length: 7
```


## 2. Records (Standard)

Records, introduced as a preview feature in earlier releases, became standard in Java 16.  They provide a concise syntax for creating immutable data classes, automatically generating constructors, getters, `equals()`, `hashCode()`, and `toString()`.

**Example:**

```java
public record Point(int x, int y) {}

public class RecordsExample {
    public static void main(String[] args) {
        Point point = new Point(5, 10);
        System.out.println("Point: " + point);
    }
}
```

**Output:**

```
Point: Point[x=5, y=10]
```


## 3. Migration to Git and GitHub

Java 16 marked a significant change: the migration of OpenJDK source code repositories from Mercurial to Git and from self-hosted servers to GitHub.


## 4. Warnings for Value-Based Classes

Java 16 introduced warnings to help developers adhere to best practices when using value-based classes (immutable classes with no observable identity).


## 5. Strongly Encapsulate JDK Internals by Default

Java 16 strengthened the encapsulation of JDK internals by default, restricting access to internal APIs to improve security and stability.


## 6. New Stream Methods

New methods were added to the `Stream` class:


### 6.1 `Stream.toList()`

This method collects stream elements into an unmodifiable list, offering a more concise alternative to `Collectors.toList()`.  (Example provided in the original text).


### 6.2 `Stream.mapMulti()`

This method provides a more flexible and efficient way to flat-map streams. (Example provided in the original text).


## 7. Packaging Tool (Standard)

The Packaging Tool, previously incubated, became a standard feature in Java 16.  It simplifies creating self-contained application executables for various platforms.


## 8. Performance Improvements

Several performance enhancements were made:


### 8.1 ZGC: Concurrent Thread-Stack Processing

Improved ZGC's performance by concurrently processing thread stacks.


### 8.2 Concurrently Uncommit Memory in G1

Enhanced G1's memory management to concurrently uncommit unused memory.


### 8.3 Elastic Metaspace

Improved metaspace memory management by more efficiently returning unused memory to the operating system.


### 8.4 Unix-Domain Socket Channels

Added support for Unix-domain sockets in the `java.nio.channels` package.


## 9. Experimental, Preview, and Incubator Features

Java 16 included several features in experimental or incubator phases:


### 9.1 Sealed Classes (Second Preview)

Sealed classes, allowing restriction of which classes can extend or implement them, were again in preview. (Example provided in the original text).


### 9.2 Vector API (Incubator)

This API aims to improve performance for vector computations.


### 9.3 Foreign Linker API (Incubator) + Foreign-Memory Access API (Third Incubator)

These APIs facilitate interaction with native code and memory.


## 10. Deprecations

Several methods in the `ThreadGroup` class were terminally deprecated.


## 11. Other Changes in Java 16

Other changes include:  `InvocationHandler::invokeDefault` for better dynamic proxy support; day period support in `java.time` formats;  ports for Alpine Linux and Windows/AArch64; and enabling C++14 language features in the JDK codebase.


## Conclusion

Java 16 delivered significant improvements, including the standardization of pattern matching for `instanceof` and records.  Performance enhancements and the continued incubation of important APIs like the Vector and Foreign-Memory Access APIs further strengthen the Java platform.

# Java 17: Key Features and Enhancements

Java 17, released in September 2021 as a Long-Term Support (LTS) release, brought significant improvements to the Java platform. This guide details the key features.


## 1. Sealed Classes (Standard)

Sealed classes, previously in preview, became a standard feature in Java 17. They allow a class or interface to restrict which classes or interfaces can extend or implement it, improving code maintainability and safety.

**Example:**

```java
public sealed class Person permits Employee, Manager {
    private final String name;

    public Person(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }
}

public final class Employee extends Person {
    public Employee(String name) {
        super(name);
    }
}

public final class Manager extends Person {
    public Manager(String name) {
        super(name);
    }
}

public class SealedClassExample {
    public static void main(String[] args) {
        Person employee = new Employee("Alice");
        Person manager = new Manager("Bob");

        System.out.println("Employee Name: " + employee.name()); 
        System.out.println("Manager Name: " + manager.name());  
    }
}
```

Sealed interfaces work similarly.


## 2. Strongly Encapsulate JDK Internals

Java 17 further strengthens the encapsulation of JDK internals, completely restricting access to internal APIs.  This enhances security and stability.


## 3. `java.time.InstantSource`

The `java.time.InstantSource` interface was added, providing a way to access the current instant in time, improving flexibility within the `java.time` package.  (Example provided in the original text).


## 4. Hex Formatting and Parsing Utility

A utility for formatting and parsing hexadecimal values was introduced, simplifying work with hexadecimal data. (Example provided in the original text).


## 5. Context-Specific Deserialization Filters

Context-specific deserialization filters enhance security by allowing fine-grained control over deserialization, mitigating deserialization vulnerabilities. (Example provided in the original text).


## 6. Enhanced Pseudo-Random Number Generators (PRNGs)

Java 17 provides enhanced PRNGs with more algorithms and better performance. (Example provided in the original text).


## 7. Performance Enhancements

A key performance improvement is the unified logging framework's support for asynchronous log flushing.


## 8. Preview and Incubator Features

Java 17 included several features in preview or incubator stages:


### 8.1 Pattern Matching for `switch` (Preview)

This preview feature allows `switch` statements to match patterns, enhancing conciseness and readability. (Example provided in the original text).


### 8.2 Foreign Function & Memory API (Incubator)

This API enhances interoperability with native code and memory.


### 8.3 Vector API (Second Incubator)

The Vector API, for improved performance of vector computations, was further incubated.


## 9. Deprecations and Deletions

Several features were deprecated or removed:

*   The Applet API was deprecated for removal.
*   The Security Manager was deprecated for removal.
*   RMI Activation was removed.
*   The experimental AOT and JIT compilers were removed.


## 10. Other Changes in Java 17

Other changes include: a new API for accessing large icons; added support for `UserDefinedFileAttributeView` on macOS; a system property for the native character encoding name; restoration of always-strict floating-point semantics; a new macOS rendering pipeline; a macOS/AArch64 port; and improved documentation pages for new and deprecated APIs.


## Conclusion

Java 17, as an LTS release, delivered significant improvements focusing on enhanced security, improved performance, and refined APIs.  The standardization of sealed classes and the strengthening of JDK internal encapsulation are notable contributions.  The preview and incubator features point towards further advancements in future releases.

# Java 18: Key Features and Enhancements

Java 18, released in March 2022 (a non-LTS release), introduced several new features, performance improvements, and deprecations. This guide details the key changes.


## 1. UTF-8 by Default

Java 18 establishes UTF-8 as the default character set for the Java platform. This simplifies text handling and ensures consistent behavior across different environments.


### 1.1 `Charset.forName()` Taking Fallback Default Value

The `Charset.forName()` method now accepts a fallback default charset, enhancing flexibility in charset handling.

**Example:**

```java
import java.nio.charset.Charset;

public class CharsetExample {
    public static void main(String[] args) {
        Charset charset = Charset.forName("UTF-16", Charset.defaultCharset());
        System.out.println("Charset: " + charset.name());
    }
}
```


## 2. Simple Web Server

Java 18 includes a built-in simple web server, useful for prototyping, testing, and small applications.  It simplifies web application development by removing the need for external web servers. (Example provided in the original text).


## 3. Code Snippets in Java API Documentation

Java 18 enhances API documentation by including code snippets within the documentation itself, improving usability and understanding. (Example provided in the original text).


## 4. Internet-Address Resolution SPI

A Service Provider Interface (SPI) for internet address resolution was introduced, allowing customization of internet address resolution. (Example provided in the original text).


## 5. Preview and Incubator Features

Java 18 continued the incubation or preview of several features:


### 5.1 Pattern Matching for `switch` (Second Preview)

Pattern matching for `switch` statements was again offered as a preview feature. (Example provided in the original text).


### 5.2 Vector API (Third Incubator)

The Vector API, aiming to improve performance for vector computations, was further incubated.


### 5.3 Foreign Function & Memory API (Second Incubator)

This API, for interacting with native code and memory, was also further incubated.


## 6. Deprecations and Deletions

Several features were deprecated or removed:

*   Finalization was deprecated for removal.
*   `Thread.stop()` was terminally deprecated.
*   The legacy `PlainSocketImpl` and `PlainDatagramSocketImpl` implementations were removed.


## 7. Other Changes in Java 18

Other changes include: reimplementation of core reflection using method handles; string deduplication support for various garbage collectors;  increased maximum G1 heap region size; and various other internal improvements.


## Conclusion

Java 18, although a n# Java 19: A Deep Dive into New Features and Enhancements

Java 19 brings a host of exciting new features and improvements, enhancing both the language and the runtime environment. This guide explores the key additions, including new methods, preview and incubator features, deprecations, and other significant changes.


## 1. New Methods for Creating Preallocated HashMaps

Java 19 introduces factory methods for creating `HashMap` instances with a pre-defined initial capacity. This optimization reduces resizing overhead when the approximate number of entries is known beforehand, leading to performance gains.

**Example:**

```java
import java.util.HashMap;

public class PreallocatedHashMapExample {
    public static void main(String[] args) {
        // Create a preallocated HashMap with an initial capacity of 20
        HashMap<String, Integer> map = HashMap.newHashMap(20);

        // Add elements to the HashMap
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);

        // Print the HashMap
        System.out.println("HashMap: " + map);
    }
}
```

`HashMap.newHashMap(20)` creates a `HashMap` with an initial capacity of 20, minimizing resizing as elements are added.


## 2. Preview and Incubator Features

Java 19 includes several features in preview and incubator stages, allowing developers to experiment with functionalities that may become standard in future releases.

### 2.1 Pattern Matching for switch (Third Preview) – JEP 427

This enhancement makes `switch` statements more expressive and readable by allowing pattern matching on types and values.

**Example:**

```java
public class PatternMatchingSwitchExample {
    public static void main(String[] args) {
        Object obj = "Hello, Java 19";

        // Using pattern matching in switch statement
        switch (obj) {
            case Integer i -> System.out.println("Integer: " + i);
            case String s -> System.out.println("String: " + s);
            case Double d -> System.out.println("Double: " + d);
            default -> System.out.println("Unknown type");
        }
    }
}
```

The `switch` statement directly handles different types (Integer, String, Double), improving code clarity.


### 2.2 Record Patterns (Preview) – JEP 405

Record patterns extend pattern matching to allow deconstructing records within patterns, simplifying work with data classes.

**Example:**

```java
record Point(int x, int y) {}

public class RecordPatternsExample {
    public static void main(String[] args) {
        Point point = new Point(10, 20);

        // Using record pattern to deconstruct a record
        if (point instanceof Point(int x, int y)) {
            System.out.println("Point coordinates: (" + x + ", " + y + ")");
        }
    }
}
```

`if (point instanceof Point(int x, int y))` deconstructs the `Point` record into its `x` and `y` components.


### 2.3 Virtual Threads (Preview) – JEP 425

Virtual threads are lightweight threads designed to simplify high-throughput concurrent applications. They reduce resource overhead compared to platform threads.

**Example:**

```java
public class VirtualThreadsExample {
    public static void main(String[] args) {
        // Create and start a virtual thread
        Thread vThread = Thread.ofVirtual().start(() -> {
            System.out.println("Running in a virtual thread");
        });

        // Wait for the virtual thread to complete
        vThread.join();
    }
}
```

`Thread.ofVirtual().start()` creates and starts a virtual thread, enabling efficient concurrency.


### 2.4 Structured Concurrency (Incubator) – JEP 428

This incubator module provides a library for managing the lifecycle of multiple concurrent tasks within a structured framework, improving reliability and code readability.

**Example:**

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class StructuredConcurrencyExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

        try (executor) {
            Future<String> task = executor.submit(() -> {
                // Simulate a task
                Thread.sleep(1000);
                return "Task completed";
            });

            System.out.println(task.get());
        }
    }
}
```

`Executors.newVirtualThreadPerTaskExecutor()` creates an executor service for managing virtual threads, facilitating efficient concurrent task execution.


### 2.5 Foreign Function & Memory API (Preview) – JEP 424

This API offers a safe and efficient way to interact with native code and manage foreign memory.

**Example:**

```java
import jdk.incubator.foreign.*;

public class ForeignFunctionMemoryExample {
    public static void main(String[] args) {
        try (MemorySegment segment = MemorySegment.allocateNative(1024)) {
            System.out.println("Allocated native memory segment of size: " + segment.byteSize());
        }
    }
}
```

`MemorySegment.allocateNative(1024)` allocates a native memory segment, providing safe access to foreign memory.


### 2.6 Vector API (Fourth Incubator) – JEP 426

The Vector API enables the expression of vector computations that compile to optimal vector instructions on supported hardware, boosting performance.

**Example:**  (Note: This example requires adding `import java.util.Arrays;`)

```java
import jdk.incubator.vector.*;
import java.util.Arrays;

public class VectorAPIExample {
    public static void main(String[] args) {
        // Create a vector species of type int with size 256
        VectorSpecies<Integer> SPECIES = IntVector.SPECIES_256;

        // Initialize two int arrays
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] b = {8, 7, 6, 5, 4, 3, 2, 1};

        // Perform vector addition
        IntVector va = IntVector.fromArray(SPECIES, a, 0);
        IntVector vb = IntVector.fromArray(SPECIES, b, 0);
        IntVector vc = va.add(vb);

        // Store the result in an array
        int[] c = new int[8];
        vc.intoArray(c, 0);

        // Print the result
        System.out.println("Vector addition result: " + Arrays.toString(c));
    }
}
```

The Vector API facilitates vectorized computations for efficient execution on compatible hardware.


## 3. Deprecations and Deletions

### 3.1 Deprecation of Locale Class Constructors

The constructors in the `Locale` class are deprecated, promoting the use of factory methods like `Locale.of()`.

**Example:**

```java
import java.util.Locale;

public class LocaleExample {
    public static void main(String[] args) {
        // Create a Locale using the factory method
        Locale locale = Locale.of("en", "US");
        System.out.println("Locale: " + locale);
    }
}
```

`Locale.of("en", "US")` is the recommended approach for creating `Locale` instances.


### 3.2 `java.lang.ThreadGroup` is Degraded

The `ThreadGroup` class is deprecated; its functionality is considered obsolete for modern Java applications.


## 4. Other Changes in Java 19

### 4.1 Automatic Generation of the CDS Archive

Java 19 automatically generates the Class Data Sharing (CDS) archive during the JDK build, improving startup performance.


### 4.2 Linux/RISC-V Port – JEP 422

Java 19 adds support for the Linux/RISC-V architecture, expanding platform compatibility.


### 4.3 Additional Date-Time Formats

New date-time formats provide increased flexibility in parsing and formatting dates and times.

**Example:**

```java
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatsExample {
    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.now();

        // Format date-time with additional formats
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = dateTime.format(formatter);

        System.out.println("Formatted Date-Time: " + formattedDateTime);
    }
}
```

`DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")` enables custom formatting using extended patterns.


### 4.4 New System Properties for `System.out` and `System.err`

New system properties enhance control over standard output and error streams.


## 5. Summary

Java 19 introduces many features and improvements, enhancing the language, runtime, and developer experience.  From optimized `HashMap` creation to preview features like pattern matching and virtual threads, Java 19 offers significant advancements.  The deprecations and other changes further refine performance, flexibility, and usability across the platform.  Understanding these additions empowers developers to leverage the full potential of Java 19 in their applications.
on-LTS release, delivered several useful features. The simple web server, UTF-8 as the default charset, and improvements to the API documentation are particularly notable.  The continued incubation of key APIs and performance enhancements further strengthen the Java platform.

# Java 20: Key Features and Enhancements

Java 20, released in March 2023, brings several notable updates, including new preview and incubator features, deprecations, and other improvements. This guide highlights the key changes.


## 1. Preview and Incubator Features

### 1.1 Scoped Values (Incubator) – JEP 429

Scoped values offer a mechanism to define values associated with a specific thread or task, streamlining the management of context-specific data.  They provide a safer and more efficient alternative to thread-local variables, particularly for sharing immutable data.

**Example:**

```java
public class ScopedValuesExample {
    public static void main(String[] args) {
        ScopedValue<String> scopedValue = ScopedValue.newInstance();

        ScopedValue.Scope scope = ScopedValue.withValue(scopedValue, "Hello, Java 20!");
        scope.run(() -> {
            System.out.println("Scoped Value: " + scopedValue.get());
        });
    }
}
```

**Explanation:**

* **Context-Specific Data:** Scoped values enable the definition of thread or task-specific values.
* **Flexibility:** This feature offers enhanced control over the lifecycle and visibility of context-specific data.


### 1.2 Record Patterns (Second Preview) – JEP 432

Record patterns, in their second preview iteration, allow for concise and readable matching and destructuring of record values.

**Example:**

```java
public class RecordPatternExample {
    public static void main(String[] args) {
        record Point(int x, int y) {}
        Point point = new Point(5, 10);

        if (point instanceof Point(int x, int y)) {
            System.out.println("x: " + x + ", y: " + y);
        }
    }
}
```

**Explanation:**

* **Destructuring:**  Record patterns enable the extraction of record components in a more readable manner.
* **Concise Code:** This reduces boilerplate code when working with records.


### 1.3 Pattern Matching for switch (Fourth Preview) – JEP 433

Pattern matching for `switch` statements, now in its fourth preview, offers more concise and readable code by allowing pattern matching within `switch` expressions.

**Example:**

```java
public class PatternMatchingSwitchExample {
    public static void main(String[] args) {
        Object obj = "Java 20";
        String result = switch (obj) {
            case Integer i -> "Integer: " + i;
            case String s -> "String: " + s;
            default -> "Unknown type";
        };
        System.out.println(result);
    }
}
```

**Explanation:**

* **Concise Code:** Pattern matching in `switch` statements improves code readability and reduces boilerplate.
* **Flexibility:** Enhanced flexibility in handling diverse types and patterns within `switch` statements.


### 1.4 Foreign Function & Memory API (Second Preview) – JEP 434

The Foreign Function & Memory API, in its second preview, provides a way to interact with native code and memory, improving interoperability and performance.

**Explanation:**

* **Interoperability:**  Enhanced interaction with native code and memory for more efficient use of native libraries.
* **Performance:** More direct access to native memory and functions leads to performance improvements.


### 1.5 Virtual Threads (Second Preview) – JEP 436

Virtual threads, in their second preview, provide a lightweight, scalable alternative to platform threads, boosting the performance and scalability of concurrent applications.

**Example:**

```java
import java.util.concurrent.Executors;

public class VirtualThreadsExample {
    public static void main(String[] args) {
        var executor = Executors.newVirtualThreadPerTaskExecutor();

        executor.execute(() -> System.out.println("Hello from a virtual thread!"));

        executor.shutdown();
    }
}
```

**Explanation:**

* **Lightweight Threads:** Virtual threads offer lightweight and scalable execution of many concurrent tasks.
* **Improved Performance:** Reduced overhead compared to traditional threads results in performance improvements.


### 1.6 Structured Concurrency (Second Incubator) – JEP 437

Structured concurrency, in its second incubator phase, simplifies concurrent task handling by grouping related tasks and managing their lifecycle as a unit.

**Example:**

```java
import java.util.concurrent.*;

public class StructuredConcurrencyExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            Future<String> task1 = scope.fork(() -> "Task 1 result");
            Future<String> task2 = scope.fork(() -> "Task 2 result");

            scope.join();
            scope.throwIfFailed();

            System.out.println("Results: " + task1.resultNow() + ", " + task2.resultNow());
        }
    }
}
```

**Explanation:**

* **Task Grouping:** Related tasks are grouped and managed together, simplifying concurrent task handling.
* **Lifecycle Management:** Improved reliability and maintainability through better lifecycle management for grouped tasks.


## 2. Deprecations and Deletions

### 2.1 `java.net.URL` constructors are deprecated

The constructors of the `java.net.URL` class are deprecated, encouraging the use of `java.net.URI` or factory methods.


### 2.2 `Thread.suspend/resume` changed to throw `UnsupportedOperationException`

`Thread.suspend` and `Thread.resume` now throw `UnsupportedOperationException` because they are inherently unsafe and can lead to deadlocks.  Safer alternatives for thread management should be used.


## 3. Other Changes in Java 20

### 3.1 Javac Warnings about Type Casts in Compound Assignments

Java 20 introduces warnings in `javac` for potentially lossy type casts in compound assignments.


### 3.2 Idle Connection Timeouts for HTTP/2

Idle connection timeouts for HTTP/2 improve resource management and performance by automatically closing idle connections.


### 3.3 `HttpClient` Default Keep Alive Time is 30 Seconds

The default keep-alive time for `HttpClient` connections is set to 30 seconds, optimizing persistent connection management.


### 3.4 `IdentityHashMap`'s `Remove` and `Replace` Methods Use Object Identity

`IdentityHashMap`'s `remove` and `replace` methods now consistently use object identity for comparisons.


### 3.5 Support for Unicode 15.0

Java 20 adds support for Unicode 15.0, expanding character set support.


## Conclusion

Java 20 introduces several key features and improvements that enhance developer productivity, application performance, and the overall flexibility of the Java platform.  Understanding and utilizing these features allows developers to create more efficient and maintainable Java applications.


# Java 21: A Deep Dive into New Features and Enhancements

Java 21, released in September 2023, marks a significant release with numerous enhancements aimed at improving developer productivity, application performance, and the overall flexibility of the Java platform. This guide explores the key features and changes.


## 1. Virtual Threads – JEP 444

Virtual threads, now a permanent feature in Java 21 (part of Project Loom), are lightweight threads managed by the JVM, enabling the creation and management of thousands of threads with minimal overhead.  This significantly reduces the resource consumption and complexity associated with traditional thread management.

**Example:**

```java
import java.util.concurrent.Executors;

public class VirtualThreadsExample {
    public static void main(String[] args) {
        var executor = Executors.newVirtualThreadPerTaskExecutor();

        executor.execute(() -> System.out.println("Hello from a virtual thread!"));

        executor.shutdown();
    }
}
```

**Explanation:**

* **Lightweight:** Virtual threads are far more lightweight than platform threads, allowing for high concurrency with reduced resource usage.
* **Scalable:** They enhance scalability and simplify the development of concurrent applications.


## 2. Sequenced Collections – JEP 431

Sequenced collections maintain the insertion order of elements.  This feature introduces interfaces to the Java Collections Framework that describe collections with a defined encounter order, simplifying code and improving readability.

**Interfaces:**

* `SequencedCollection`: Extends `Collection` to guarantee a defined element order.
* `SequencedSet`: Extends `Set` to maintain a defined order of elements without duplicates.
* `SequencedMap`: Extends `Map` to maintain a defined order of key-value pairs.

**New Methods:**

* `SequencedCollection.reversed()`, `SequencedSet.reversed()`, `SequencedMap.reversed()`:  Return a reversed view of the collection/set/map.

**Examples:**

```java
import java.util.SequencedCollection;
import java.util.ArrayList;

public class SequencedCollectionExample {
    public static void main(String[] args) {
        SequencedCollection<String> collection = new ArrayList<>();
        collection.add("Java");
        collection.add("21");

        SequencedCollection<String> reversed = collection.reversed();
        System.out.println(reversed); // Output: [21, Java]
    }
}

import java.util.SequencedSet;
import java.util.LinkedHashSet;

public class SequencedSetExample {
    public static void main(String[] args) {
        SequencedSet<String> set = new LinkedHashSet<>();
        set.add("Java");
        set.add("21");

        SequencedSet<String> reversed = set.reversed();
        System.out.println(reversed); // Output: [21, Java]
    }
}

import java.util.SequencedMap;
import java.util.LinkedHashMap;

public class SequencedMapExample {
    public static void main(String[] args) {
        SequencedMap<String, Integer> map = new LinkedHashMap<>();
        map.put("Java", 21);
        map.put("Features", 2023);

        SequencedMap<String, Integer> reversed = map.reversed();
        System.out.println(reversed); // Output: {Features=2023, Java=21}
    }
}
```

**Explanation:**

* **Order Maintenance:**  Sequenced collections ensure the order of elements is preserved.
* **Improved APIs:**  Provides improved APIs for managing ordered data, leading to cleaner and more readable code.


## 3. Record Patterns – JEP 440

Record patterns allow for the deconstruction of record values directly within pattern-matching constructs, simplifying code and improving maintainability.

**Example:**

```java
public class RecordPatternExample {
    public static void main(String[] args) {
        record Point(int x, int y) {}
        Point point = new Point(5, 10);

        if (point instanceof Point(int x, int y)) {
            System.out.println("x: " + x + ", y: " + y);
        }
    }
}
```

**Explanation:**

* **Destructuring:**  Directly extracts components from records within pattern matching.
* **Concise Code:** Reduces boilerplate code when working with records.


## 4. Pattern Matching for switch – JEP 441

Pattern matching for `switch` statements enhances readability and conciseness.

**Example:**

```java
public class PatternMatchingSwitchExample {
    public static void main(String[] args) {
        Object obj = "Java 21";
        String result = switch (obj) {
            case Integer i -> "Integer: " + i;
            case String s -> "String: " + s;
            default -> "Unknown type";
        };
        System.out.println(result);
    }
}
```

**Explanation:**

* **Concise Code:** More concise and readable `switch` statements.
* **Flexibility:** Improved flexibility in handling different types and patterns.


## 5. New Methods in Core Classes

Java 21 introduces several new methods in `String`, `StringBuilder`, `StringBuffer`, `Character`, and `Math` classes.  These methods enhance functionality and often improve performance.  (Detailed examples are provided in the original prompt, and are too extensive to fully reproduce here.  Consult the Java 21 API documentation for specifics on each method.)


## 6. Preview and Incubator Features

Java 21 continues to evolve several preview and incubator features:

* **String Templates (Preview) – JEP 430:** Allows embedding expressions directly within string literals.
* **Unnamed Patterns and Variables (Preview) – JEP 443:** Enables the use of patterns and variables without explicit naming.
* **Unnamed Classes and Instance Main Methods (Preview) – JEP 445:** Simplifies class and method creation without explicit naming.
* **Scoped Values (Preview) – JEP 446:** Provides context-specific values scoped to threads or tasks.
* **Structured Concurrency (Preview) – JEP 453:** Improves concurrent task handling by grouping and managing related tasks.
* **Foreign Function & Memory API (Third Preview) – JEP 442:**  Enhances interoperability with native code and memory.
* **Vector API (Sixth Incubator) – JEP 448:** Improves performance of vector computations.  (Examples omitted for brevity, refer to the original prompt or the Java 21 documentation.)


## 7. Other Changes in Java 21

* **Generational ZGC – JEP 439:** Improves the performance of the Z Garbage Collector.
* **Generational Shenandoah (Experimental) – JEP 404:** Improves the performance of the Shenandoah Garbage Collector.
* **Deprecate the Windows 32-bit x86 Port for Removal – JEP 449:**  Deprecates the 32-bit Windows port.
* **Prepare to Disallow the Dynamic Loading of Agents – JEP 451:** Enhances JVM security and stability.
* **Key Encapsulation Mechanism API – JEP 452:** Improves key management security. (Example omitted for brevity, refer to the original prompt or the Java 21 documentation.)
* **Improve `Thread.sleep(millis, nanos)` For Sub-millisecond Granularity:**  Provides more precise control over thread sleeping.
* **Last-Ditch Full GC Should Also Move Humongous Objects:** Improves memory management.


## Conclusion

Java 21 is a substantial release bringing significant enhancements to the language and runtime. The new features and improvements empower developers to build more efficient, maintainable, and performant applications.  A thorough understanding of these changes will enable developers to fully utilize the capabilities of Java 21.


