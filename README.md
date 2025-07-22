# JavaVersionAndFeatures


[Java 8](#java-8-a-deep-dive-into-key-features) \|
[Java 9](#java-9-key-features-and-enhancements) \| [Java 10](#java-10-key-features-and-enhancements) \| [Java 11](#java-11-key-features-and-enhancements) \| [Java 12](#java-12-key-features-and-enhancements) \| [Java 13](#java-13-key-features-and-enhancements) \| [Java 14](#java-14-key-features-and-enhancements) \| [Java 15](#java-15-key-features-and-enhancements) \| [Java 16](#java-16-key-features-and-enhancements) \| [Java 17](#java-17-key-features-and-enhancements) \| [Java 18](#java-18-key-features-and-enhancements) \| [Java 19](#java-19-a-deep-dive-into-new-features-and-enhancements) \| [Java 20](#java-20-key-features-and-enhancements) \| [Java 21](#java-21-a-deep-dive-into-new-features-and-enhancements)

**Java Version And Features from java 8**

Java 8 introduced several significant features that revolutionized the way Java programming is done. Here are some of the key features:

1. **Lambda Expressions**: These provide a clear and concise way to represent one method interface using an expression. They enable functional programming and simplify the development of APIs and libraries.

2. **Method References**: These are a shorthand notation of a lambda expression to call a method. They make the code more readable and concise.

3. **Functional Interfaces**: An interface with a single abstract method, known as a SAM (Single Abstract Method) interface. Examples include `Runnable`, `Callable`, and the new interfaces in `java.util.function`.

4. **Stream API**: This allows for functional-style operations on streams of elements, such as map-reduce transformations on collections. It provides a way to perform bulk operations on collections in a declarative manner.

5. **Default Methods**: These allow the addition of new methods to interfaces without breaking the existing implementations. They provide a way to evolve interfaces.

6. **Optional Class**: This is a container object which may or may not contain a non-null value. It helps in avoiding `NullPointerException` and provides methods to deal with the absence of a value.

7. **Nashorn JavaScript Engine**: This allows Java applications to execute JavaScript code dynamically at runtime.

8. **New Date and Time API**: The `java.time` package provides a comprehensive model for date and time, improving upon the old `java.util.Date` and `java.util.Calendar` classes.

9. **Base64 Encoding and Decoding**: Java 8 includes a utility class for Base64 encoding and decoding.

10. **Parallel Array Sorting**: The `Arrays.parallelSort` method uses the Fork/Join framework to sort large arrays more efficiently.

11. **Type Annotations**: These provide the ability to apply annotations to any use of a type, enhancing the way annotations are used in Java.

12. **Repeating Annotations**: This allows the same annotation to be applied multiple times to the same declaration or type use.

13. **Concurrency Enhancements**: New classes and methods in the `java.util.concurrent` package, such as `CompletableFuture`, which simplifies asynchronous programming.

14. **Collectors Class**: This provides various methods to collect stream elements into collections, summarizing statistics, concatenating strings, etc.

15. **forEach() Method**: This method is used to iterate over elements of a collection and perform an action for each element.

### Java 8: A Deep Dive into Key Features

Java 8 introduced several significant features that revolutionized the way Java programming is done. Here are some of the key features:

*   **Lambda Expressions:** Provide a concise way to represent anonymous functions, enabling functional programming.
*   **Functional Interfaces:** Interfaces with a single abstract method, designed to be targets for lambda expressions.
*   **Streams API:** A new way to process collections of data in a declarative and functional style, supporting operations like filtering, mapping, and reducing.
*   **Optional Class:** Helps handle situations where a value might be absent, avoiding `NullPointerExceptions`.
*   **Default and Static Methods in Interfaces:** Allow adding new methods to interfaces without breaking existing implementations, and static methods belonging to the interface itself.
*   **New Date and Time API (java.time):** A comprehensive and improved date and time API, replacing older classes.
*   **Nashorn JavaScript Engine:** Allowed execution of JavaScript code directly within Java applications (deprecated in later versions).
*   **Parallel Array Sorting:** Provides a parallel sorting algorithm for arrays.
*   **Type Annotations:** Allow annotations to be applied to types.
*   **Method References:** Offer a concise syntax for referring to existing methods, simplifying lambda expressions.
*   **Collectors:** Used with Streams API to accumulate results into various data structures.
*   **New Files API (NIO.2):** Enhanced file system interactions with `Path`, `Files` class, and `Watch Service`.

### Java 9: Key Features and Enhancements

Java 9 introduced features aimed at improving performance, developer productivity, and overall application development.

*   **Private Methods in Interfaces:** Allows code reuse among default methods within the same interface.
*   **Immutable Collections:** Introduced static factory methods (`List.of()`, `Set.of()`, `Map.of()`) for creating unmodifiable collections.
*   **Stream API Improvements:** Added `takeWhile()`, `dropWhile()`, and enhancements to `iterate()`.
*   **Optional Class Improvements:** Gained new methods like `ifPresentOrElse()`, `or()`, and `stream()`.
*   **JShell:** An interactive REPL (Read-Eval-Print Loop) for Java.
*   **Module System (Project Jigsaw):** A major architectural change for modular applications, improving encapsulation and maintainability.
*   **HTTP/2 Client:** Introduced a new, more efficient HTTP client supporting HTTP/2, WebSockets, and asynchronous operations.
*   **Process API Improvements:** Offers more control over native processes.

### Java 10: Key Features and Enhancements

Java 10 brought several significant improvements focusing on developer productivity and application performance.

*   **Local-Variable Type Inference (`var`):** Introduced the `var` keyword for local variables, allowing the compiler to infer the type.
*   **Enhanced Immutable Collections:** Added `List.copyOf()`, `Set.copyOf()`, `Map.copyOf()` and collectors like `toUnmodifiableList()` for creating unmodifiable copies.
*   **`Optional.orElseThrow()`:** A new method to return the contained value or throw `NoSuchElementException`.
*   **Time-Based Release Versioning:** Shifted to a six-month release cycle.
*   **Parallel Full GC for G1:** Improved G1 garbage collector with parallel processing during full garbage collections.
*   **Application Class-Data Sharing (AppCDS):** Extended CDS to include application classes, reducing startup time and memory footprint.
*   **Experimental Java-Based JIT Compiler (Graal):** Introduced Graal as an experimental JIT compiler.

### Java 11: Key Features and Enhancements

Java 11, an LTS (Long-Term Support) version, brought many significant features and improvements.

*   **Local-Variable Syntax for Lambda Parameters:** Extended `var` keyword to lambda expressions for type inference.
*   **Standardized HTTP Client:** The HTTP Client, previewed in Java 9, became a standard feature.
*   **New `Collection.toArray()` Method:** Added `toArray(IntFunction<T[]>)` for better type safety and performance when converting collections to arrays.
*   **New String Methods:** Introduced `isBlank()`, `lines()`, `strip()`, `stripLeading()`, `stripTrailing()`, `repeat()`.
*   **`Files.readString()` and `writeString()`:** Simplified file I/O by directly reading and writing strings.
*   **`Path.of()`:** Provided a more concise way to create `Path` instances.
*   **Epsilon: A No-Op Garbage Collector:** A GC that performs no memory reclamation, useful for specialized scenarios.
*   **Launch Single-File Source-Code Programs:** Allowed direct execution of single Java source files without explicit compilation.
*   **Nest-Based Access Control:** Enhanced encapsulation by allowing classes within a "nest" to access each other's private members.
*   **Enhanced Analysis Tools:** Improved Java Flight Recorder (JFR) and low-overhead heap profiling.

### Java 12: Key Features and Enhancements

Java 12 (a non-LTS release) brought several notable improvements to developer productivity and application performance.

*   **New String and Files Methods:**
    *   `String.indent()`: Adjusts indentation of lines.
    *   `String.transform()`: Applies a function to a string.
    *   `Files.mismatch()`: Compares two files byte by byte.
*   **The Teeing Collector:** `Collectors.teeing()` allows collecting stream elements into two separate results and merging them.
*   **Support for Compact Number Formatting:** Added support for compact number formatting (e.g., 1.2M).
*   **Performance Improvements:** Included Default CDS Archives, Abortable Mixed Collections for G1, and promptly returning unused committed memory from G1.
*   **Switch Expressions (Preview):** A preview of a more concise and expressive switch statement syntax.
*   **Shenandoah: A Low-Pause-Time Garbage Collector (Experimental):** A new garbage collector aimed at minimizing pause times.
*   **Microbenchmark Suite:** Added a suite of microbenchmark tests to the JDK.

### Java 13: Key Features and Enhancements

Java 13 (a non-LTS release) continued the evolution of the Java platform with new features and improvements.

*   **Switch Expressions (Second Preview):** Returned with enhancements, allowing `yield` keyword to return values.
*   **Text Blocks (Preview):** Provided a new way to define multi-line string literals using triple quotes.
*   **ZGC: Uncommit Unused Memory (Experimental):** Enhanced ZGC to return unused memory to the operating system.
*   **Dynamic CDS Archives:** Allowed JVM to generate CDS archives at runtime, improving startup time.
*   **Soft Max Heap Size:** Enabled JVM to dynamically adjust heap size.
*   **Reimplementation of Legacy Socket API:** Improved performance and maintainability of `java.net.Socket` and `java.net.ServerSocket`.
*   **New `ByteBuffer.slice()` and `get()/put()` methods:** Enhanced `ByteBuffer` for efficiency.
*   **`FileSystems.newFileSystem()`:** Allowed creating file systems from a `Path` or `URI`.

### Java 14: Key Features and Enhancements

Java 14 (a non-LTS release) continued to evolve the Java platform with new features and improvements.

*   **Switch Expressions (Standard):** Became a standard feature, providing a more concise and flexible `switch` statement.
*   **Helpful NullPointerExceptions:** Enhanced `NullPointerException` messages to provide more context for debugging.
*   **Records (Preview):** Provided a concise syntax for declaring data classes, automatically generating methods.
*   **Pattern Matching for `instanceof` (Preview):** Simplified type checking and casting within an `instanceof` expression.
*   **Text Blocks (Second Preview):** Further refined as a multi-line string literal feature.
*   **ZGC on macOS + Windows (Experimental):** ZGC gained support for macOS and Windows.
*   **Packaging Tool (Incubator):** Helps package Java applications into self-contained executables.
*   **Foreign-Memory Access API (Incubator):** Provided a safer way to access native memory outside the Java heap.
*   **Removal of Concurrent Mark Sweep (CMS) GC:** Removed the CMS garbage collector.

### Java 15: Key Features and Enhancements

Java 15 (a non-LTS release) delivered a range of new features and improvements.

*   **Text Blocks (Standard):** Became a standard feature, providing a cleaner way to define multi-line string literals.
*   **New Garbage Collectors: ZGC + Shenandoah:** ZGC and Shenandoah reached full production status as low-latency GCs.
*   **New String and CharSequence Methods:**
    *   `String.formatted()`: More readable alternative to `String.format()`.
    *   `String.stripIndent()`: Removes leading whitespace from text blocks.
    *   `String.translateEscapes()`: Translates escape sequences.
    *   `CharSequence.isEmpty()`: Checks if a `CharSequence` is empty.
*   **Helpful NullPointerExceptions:** Further improved detailed messages.
*   **Sealed Classes (Preview):** Restricted which classes can extend or implement them, enhancing encapsulation.
*   **Pattern Matching for `instanceof` (Second Preview):** Continued as a preview feature.
*   **Records (Second Preview):** Continued as a preview feature.
*   **Removal of Nashorn JavaScript Engine:** Removed Nashorn.
*   **Deprecation of Biased Locking:** Disabled and deprecated biased locking.
*   **Hidden Classes:** Introduced classes that cannot be used directly by other classes, useful for frameworks.

### Java 16: Key Features and Enhancements

Java 16 (a non-LTS release) continued to refine the Java platform.

*   **Pattern Matching for `instanceof` (Standard):** Became a standard feature, simplifying type checking and casting.
*   **Records (Standard):** Became a standard feature, providing a concise syntax for immutable data classes.
*   **Migration to Git and GitHub:** OpenJDK source code repositories migrated.
*   **Warnings for Value-Based Classes:** Introduced warnings for best practices with value-based classes.
*   **Strongly Encapsulate JDK Internals by Default:** Restricted access to internal APIs by default.
*   **New Stream Methods:**
    *   `Stream.toList()`: Collects stream elements into an unmodifiable list.
    *   `Stream.mapMulti()`: Provides a flexible way to flat-map streams.
*   **Packaging Tool (Standard):** Simplified creating self-contained application executables.
*   **Performance Improvements:** ZGC: Concurrent Thread-Stack Processing, Concurrently Uncommit Memory in G1, Elastic Metaspace.
*   **Sealed Classes (Second Preview):** Continued as a preview feature.
*   **Vector API (Incubator):** Aimed to improve performance for vector computations.
*   **Foreign Linker API (Incubator) + Foreign-Memory Access API (Third Incubator):** Facilitated interaction with native code and memory.
*   **Unix-Domain Socket Channels:** Added support for Unix-domain sockets.

### Java 17: Key Features and Enhancements

Java 17, an LTS release, brought significant improvements.

*   **Sealed Classes (Standard):** Became a standard feature, allowing restriction of which classes can extend or implement them.
*   **Strongly Encapsulate JDK Internals:** Further strengthened encapsulation of JDK internals.
*   **`java.time.InstantSource`:** Added an interface for accessing the current instant in time.
*   **Hex Formatting and Parsing Utility:** Introduced a utility for hexadecimal values.
*   **Context-Specific Deserialization Filters:** Enhanced security by allowing fine-grained control over deserialization.
*   **Enhanced Pseudo-Random Number Generators (PRNGs):** Provided more algorithms and better performance.
*   **Pattern Matching for `switch` (Preview):** Allowed `switch` statements to match patterns.
*   **Foreign Function & Memory API (Incubator):** Enhanced interoperability with native code and memory.
*   **Vector API (Second Incubator):** Further incubated the Vector API.
*   **Deprecation of Applet API and Security Manager:** Deprecated for removal.
*   **Removal of RMI Activation:** Removed RMI Activation.

### Java 18: Key Features and Enhancements

Java 18 (a non-LTS release) introduced several new features and improvements.

*   **UTF-8 by Default:** Established UTF-8 as the default character set for the Java platform.
*   **Simple Web Server:** Included a built-in simple web server for prototyping and testing.
*   **Code Snippets in Java API Documentation:** Enhanced API documentation with embedded code snippets.
*   **Internet-Address Resolution SPI:** Introduced an SPI for customizing internet address resolution.
*   **Pattern Matching for `switch` (Second Preview):** Continued as a preview feature.
*   **Vector API (Third Incubator):** Further incubated the Vector API.
*   **Foreign Function & Memory API (Second Incubator):** Further incubated this API.
*   **Deprecation of Finalization:** Deprecated finalization for removal.
*   **`Thread.stop()` Terminally Deprecated:** `Thread.stop()` was terminally deprecated.

### Java 19: A Deep Dive into New Features and Enhancements

Java 19 brought a host of exciting new features and improvements, enhancing both the language and the runtime environment.

*   **New Methods for Creating Preallocated HashMaps:** Introduced factory methods for `HashMap` with pre-defined initial capacity.
*   **Pattern Matching for `switch` (Third Preview):** Made `switch` statements more expressive with pattern matching.
*   **Record Patterns (Preview):** Extended pattern matching to allow deconstructing records within patterns.
*   **Virtual Threads (Preview):** Lightweight threads designed to simplify high-throughput concurrent applications.
*   **Structured Concurrency (Incubator):** Provided a library for managing the lifecycle of multiple concurrent tasks.
*   **Foreign Function & Memory API (Preview):** Offered a safe and efficient way to interact with native code and manage foreign memory.
*   **Vector API (Fourth Incubator):** Enabled expression of vector computations for optimal vector instructions.
*   **Deprecation of Locale Class Constructors:** Promoted use of factory methods like `Locale.of()`.
*   **`java.lang.ThreadGroup` Degraded:** `ThreadGroup` functionality considered obsolete.
*   **Automatic Generation of the CDS Archive:** Improved startup performance.
*   **Linux/RISC-V Port:** Added support for Linux/RISC-V architecture.
*   **Additional Date-Time Formats:** Provided increased flexibility in parsing and formatting dates and times.

### Java 20: Key Features and Enhancements

Java 20 brought several notable updates, including new preview and incubator features.

*   **Scoped Values (Incubator):** Offered a mechanism to define values associated with a specific thread or task, streamlining context-specific data management.
*   **Record Patterns (Second Preview):** Allowed for concise and readable matching and destructuring of record values.
*   **Pattern Matching for `switch` (Fourth Preview):** Offered more concise and readable code by allowing pattern matching within `switch` expressions.
*   **Foreign Function & Memory API (Second Preview):** Provided a way to interact with native code and memory, improving interoperability and performance.
*   **Virtual Threads (Second Preview):** Provided a lightweight, scalable alternative to platform threads.
*   **Structured Concurrency (Second Incubator):** Simplified concurrent task handling by grouping related tasks and managing their lifecycle.
*   **`java.net.URL` constructors deprecated:** Encouraged use of `java.net.URI` or factory methods.
*   **`Thread.suspend/resume` throw `UnsupportedOperationException`:** Due to being inherently unsafe.
*   **Support for Unicode 15.0:** Expanded character set support.
*   **Idle Connection Timeouts for HTTP/2:** Improved resource management.

### Java 21: A Deep Dive into New Features and Enhancements

Java 21, an LTS release, introduced numerous enhancements aimed at improving developer productivity, application performance, and flexibility.

*   **Virtual Threads (Permanent Feature):** Lightweight threads managed by the JVM, enabling high concurrency with minimal overhead.
*   **Sequenced Collections:** New interfaces (`SequencedCollection`, `SequencedSet`, `SequencedMap`) to maintain insertion order of elements.
*   **Record Patterns (Permanent Feature):** Allowed deconstruction of record values directly within pattern-matching constructs.
*   **Pattern Matching for `switch` (Permanent Feature):** Enhanced readability and conciseness for `switch` statements.
*   **New Methods in Core Classes:** Introduced several new methods in `String`, `StringBuilder`, `StringBuffer`, `Character`, and `Math` classes.
*   **String Templates (Preview):** Allowed embedding expressions directly within string literals.
*   **Unnamed Patterns and Variables (Preview):** Enabled use of patterns and variables without explicit naming.
*   **Unnamed Classes and Instance Main Methods (Preview):** Simplified class and method creation without explicit naming.
*   **Scoped Values (Preview):** Provided context-specific values scoped to threads or tasks.
*   **Structured Concurrency (Preview):** Improved concurrent task handling by grouping and managing related tasks.
*   **Foreign Function & Memory API (Third Preview):** Enhanced interoperability with native code and memory.
*   **Vector API (Sixth Incubator):** Further improved performance of vector computations.
*   **Generational ZGC:** Improved performance of the Z Garbage Collector.
*   **Deprecate the Windows 32-bit x86 Port for Removal:** Deprecated the 32-bit Windows port.
