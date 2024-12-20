Here is a Markdown document detailing Java 12 features with examples:

```markdown
# Java 12 Features

Java 12 introduced several new features and enhancements to improve the developer experience. Below are some of the key features along with examples to help you understand and use them effectively.

## 1. Switch Expressions (Preview)

Switch expressions allow you to use the `switch` statement as an expression, which can return a value. This feature simplifies the syntax and makes the code more readable.

### Example

```java
public class SwitchExpressionsExample {
    public static void main(String[] args) {
        String day = "MONDAY";
        int numLetters = switch (day) {
            case "MONDAY", "FRIDAY", "SUNDAY" -> 6;
            case "TUESDAY" -> 7;
            case "THURSDAY", "SATURDAY" -> 8;
            case "WEDNESDAY" -> 9;
            default -> throw new IllegalStateException("Unexpected value: " + day);
        };
        System.out.println("Number of letters: " + numLetters);
    }
}
```

## 2. Default CDS Archives

Class Data Sharing (CDS) archives are now generated by default, improving startup time and reducing memory footprint.

### Example

This feature is enabled by default and does not require any code changes. You can observe the performance improvements during application startup.

## 3. Shenandoah: A Low-Pause-Time Garbage Collector (Experimental)

Shenandoah is a new garbage collector that aims to reduce pause times by performing more work concurrently with the running Java threads.

### Example

To enable Shenandoah GC, use the following JVM option:

```sh
java -XX:+UseShenandoahGC -jar your-application.jar
```

## 4. Microbenchmark Suite

Java 12 includes a set of microbenchmarks to help developers measure the performance of their code.

### Example

To use the microbenchmark suite, you need to include the JMH (Java Microbenchmark Harness) library in your project. Here is a simple example:

```java
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
public class MyBenchmark {

    @Benchmark
    public void testMethod() {
        // Your benchmark code here
    }

    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }
}
```

## 5. JVM Constants API

The JVM Constants API provides a set of classes to model nominal descriptions of key class-file and run-time artifacts.

### Example

```java
import java.lang.constant.ClassDesc;
import java.lang.constant.MethodTypeDesc;

public class JVMConstantsAPIExample {
    public static void main(String[] args) {
        ClassDesc classDesc = ClassDesc.of("java.lang.String");
        MethodTypeDesc methodTypeDesc = MethodTypeDesc.of(ClassDesc.of(void.class), ClassDesc.of(String.class));
        System.out.println("ClassDesc: " + classDesc);
        System.out.println("MethodTypeDesc: " + methodTypeDesc);
    }
}
```

## 6. One AArch64 Port, Not Two

Java 12 consolidates the two existing 64-bit ARM ports into a single port, reducing maintenance overhead.

### Example

This feature is related to the JVM internals and does not require any code changes.

## 7. Abortable Mixed Collections for G1

G1 garbage collector can now abort mixed collections if they exceed the pause time target.

### Example

To enable this feature, use the following JVM option:

```sh
java -XX:+AbortVMOnException -jar your-application.jar
```

## 8. Promptly Return Unused Committed Memory from G1

G1 garbage collector can now return unused committed memory to the operating system more promptly.

### Example

To enable this feature, use the following JVM option:

```sh
java -XX:G1PeriodicGCInterval=2000 -jar your-application.jar
```

## Conclusion

Java 12 introduces several new features and enhancements that improve performance, readability, and maintainability. By leveraging these features, developers can write more efficient and cleaner code.
```

This document provides an overview of the key features introduced in Java 12 along with examples to help you get started.
