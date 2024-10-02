Java 8 introduced the `Optional` class in the `java.util` package to provide a more elegant and safer way to handle the absence of a value, reducing the risk of `NullPointerException`. Here are the key features and methods of the `Optional` class:

### Key Features

1. **Avoid Null Checks**:
   - `Optional` helps avoid explicit null checks and provides a more readable and expressive way to handle optional values.

2. **Immutability**:
   - Instances of `Optional` are immutable, meaning once created, their value cannot be changed.

3. **Value-Based Class**:
   - `Optional` is a value-based class, meaning its instances are considered equal based on their contained value, not their reference.

### Key Methods

1. **Creation Methods**:
   - `Optional.empty()`: Returns an empty `Optional` instance.
     ```java
     Optional<String> emptyOptional = Optional.empty();
     ```
   - `Optional.of(T value)`: Returns an `Optional` with the specified non-null value.
     ```java
     Optional<String> nonEmptyOptional = Optional.of("Hello");
     ```
   - `Optional.ofNullable(T value)`: Returns an `Optional` describing the specified value, if non-null; otherwise, returns an empty `Optional`.
     ```java
     Optional<String> nullableOptional = Optional.ofNullable(null);
     ```

2. **Retrieval Methods**:
   - `T get()`: If a value is present, returns the value; otherwise, throws `NoSuchElementException`.
     ```java
     String value = nonEmptyOptional.get();
     ```
   - `boolean isPresent()`: Returns `true` if there is a value present; otherwise, `false`.
     ```java
     boolean present = nonEmptyOptional.isPresent();
     ```

3. **Conditional Execution**:
   - `void ifPresent(Consumer<? super T> consumer)`: If a value is present, performs the given action with the value; otherwise, does nothing.
     ```java
     nonEmptyOptional.ifPresent(value -> System.out.println("Value is present: " + value));
     ```

4. **Default Values and Actions**:
   - `T orElse(T other)`: Returns the value if present; otherwise, returns `other`.
     ```java
     String defaultValue = nullableOptional.orElse("Default Value");
     ```
   - `T orElseGet(Supplier<? extends T> other)`: Returns the value if present; otherwise, invokes `other` and returns the result.
     ```java
     String defaultValue = nullableOptional.orElseGet(() -> "Default Value");
     ```
   - `<X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier) throws X`: Returns the value if present; otherwise, throws an exception created by the provided supplier.
     ```java
     String value = nullableOptional.orElseThrow(() -> new IllegalArgumentException("Value is absent"));
     ```

5. **Transformations**:
   - `<U> Optional<U> map(Function<? super T, ? extends U> mapper)`: If a value is present, applies the provided mapping function to it, and if the result is non-null, returns an `Optional` describing the result; otherwise, returns an empty `Optional`.
     ```java
     Optional<Integer> length = nonEmptyOptional.map(String::length);
     ```
   - `<U> Optional<U> flatMap(Function<? super T, Optional<U>> mapper)`: If a value is present, applies the provided `Optional`-bearing mapping function to it, returns that result; otherwise, returns an empty `Optional`.
     ```java
     Optional<String> upperCase = nonEmptyOptional.flatMap(value -> Optional.of(value.toUpperCase()));
     ```

6. **Filtering**:
   - `Optional<T> filter(Predicate<? super T> predicate)`: If a value is present and matches the given predicate, returns an `Optional` describing the value; otherwise, returns an empty `Optional`.
     ```java
     Optional<String> filtered = nonEmptyOptional.filter(value -> value.startsWith("H"));
     ```

### Example Usage

Here's a complete example demonstrating the use of `Optional`:

```java
import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        // Creating Optional instances
        Optional<String> emptyOptional = Optional.empty();
        Optional<String> nonEmptyOptional = Optional.of("Hello");
        Optional<String> nullableOptional = Optional.ofNullable(null);

        // Retrieving values
        if (nonEmptyOptional.isPresent()) {
            System.out.println("Value: " + nonEmptyOptional.get());
        }

        // Conditional execution
        nonEmptyOptional.ifPresent(value -> System.out.println("Value is present: " + value));

        // Default values and actions
        String defaultValue = nullableOptional.orElse("Default Value");
        System.out.println("Default Value: " + defaultValue);

        // Transformations
        Optional<Integer> length = nonEmptyOptional.map(String::length);
        length.ifPresent(len -> System.out.println("Length: " + len));

        // Filtering
        Optional<String> filtered = nonEmptyOptional.filter(value -> value.startsWith("H"));
        filtered.ifPresent(value -> System.out.println("Filtered Value: " + value));
    }
}
