Java 10 introduced several new features and enhancements. Here are some of the key features:

1. **Local-Variable Type Inference**: The `var` keyword allows the compiler to infer the type of a local variable, making the code more concise.
    ```java
    var list = List.of("a", "b", "c"); // The type of list is inferred as List<String>
    ```

2. **Unmodifiable Collections**: New methods to create unmodifiable collections more easily.
    ```java
    List<String> copy = List.copyOf(list); // Creates an unmodifiable copy of the list
    ```

3. **Optional.orElseThrow()**: A new method in the `Optional` class that throws `NoSuchElementException` if no value is present.
    ```java
    Optional<String> optional = Optional.of("value");
    String value = optional.orElseThrow(); // Returns "value" or throws NoSuchElementException
    ```

4. **Performance Improvements**: Various performance improvements, including enhancements to the G1 garbage collector.

5. **Application Class-Data Sharing**: Reduces the startup time and footprint of Java applications by sharing common class metadata across different Java processes.

6. **Thread-Local Handshakes**: Allows executing a callback on threads without performing a global VM safepoint, improving performance.

7. **Root Certificates**: The default set of root Certification Authority (CA) certificates is included in the JDK.

8. **Heap Allocation on Alternative Memory Devices**: Enables the JVM to allocate the Java heap on an alternative memory device, such as an NVMe device.

9. **Experimental Java-Based JIT Compiler**: The Graal JIT compiler can be used as an experimental feature.

10. **Deprecated APIs and Tools**: Some APIs and tools have been deprecated for removal in future releases.

These features enhance the developer experience by improving code readability, performance, and security.
