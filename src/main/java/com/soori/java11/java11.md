# Java 11 Features and Modifications

Java 11 introduced several new features and enhancements. Here are some of the key features and modifications:

## 1. New String Methods
- **`isBlank()`**: Checks if a string is empty or contains only white space.
- **`lines()`**: Converts a string into a stream of lines.
- **`strip()`, `stripLeading()`, `stripTrailing()`**: Strips white space from the string.
- **`repeat(int)`**: Repeats the string a specified number of times.

## 2. Local-Variable Syntax for Lambda Parameters
- Allows the use of `var` in lambda expressions.
    ```java
    (var x, var y) -> x + y
    ```

## 3. `HttpClient` API
- Standardized the `HttpClient` API introduced in Java 9 as an incubator module.
    ```java
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create("https://example.com"))
        .build();
    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    ```

## 4. Nest-Based Access Control
- Introduced to allow nested classes to access private members of each other.

## 5. Dynamic Class-File Constants
- Introduced a new constant pool form, `CONSTANT_Dynamic`, to reduce the cost and disruption of creating new forms of materializable class-file constants.

## 6. Epsilon: A No-Op Garbage Collector
- A garbage collector that handles memory allocation but does not implement any actual memory reclamation mechanism.

## 7. Flight Recorder
- A low-overhead data collection framework for troubleshooting Java applications.

## 8. Launch Single-File Source-Code Programs
- Allows running a Java source file directly using the `java` command without needing to compile it first.
    ```sh
    java HelloWorld.java
    ```

## 9. Deprecate the Pack200 Tools and API
- The `Pack200` compression tools and API have been deprecated and are planned for removal in a future release.

## 10. Unicode 10
- Java 11 supports Unicode 10, which includes 8,518 new characters, 56 new scripts, and 285 new emoji characters.

## 11. ZGC: A Scalable Low-Latency Garbage Collector
- A new garbage collector designed for low latency and scalability.

## 12. Remove the Java EE and CORBA Modules
- The Java EE and CORBA modules have been removed from the JDK.

## 13. New `File` Methods
- **`readString(Path)`**: Reads all content from a file into a string.
- **`writeString(Path, CharSequence)`**: Writes a string to a file.

## 14. Key Agreement with Curve25519 and Curve448
- Support for key agreement using Curve25519 and Curve448.

## 15. ChaCha20 and Poly1305 Cryptographic Algorithms
- Support for the ChaCha20 and Poly1305 cryptographic algorithms.

## 16. TLS 1.3
- Support for TLS 1.3, the latest version of the Transport Layer Security protocol.

## 17. Deprecate Nashorn JavaScript Engine
- The Nashorn JavaScript engine has been deprecated and is planned for removal in a future release.

## 18. New `Optional` Methods
- **`isEmpty()`**: Checks if a value is not present.
    ```java
    Optional<String> optional = Optional.of("value");
    boolean isEmpty = optional.isEmpty(); // false
    ```

These features and modifications enhance the developer experience by improving code readability, performance, and security.
