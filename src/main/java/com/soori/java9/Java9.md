Java 9 introduced several significant features and enhancements that improved the language, APIs, and overall performance. Here are some of the key features:

### 1. **Project Jigsaw (Module System)**
   - **Modularity**: Java 9 introduced the module system, which allows developers to organize code into modules. This helps in better encapsulation and dependency management².
   - **Module Descriptor**: Modules are defined using a `module-info.java` file, which specifies the module's dependencies and the packages it exports.

### 2. **JShell (REPL)**
   - **Interactive Tool**: JShell is a Read-Eval-Print Loop (REPL) tool that allows developers to execute Java code snippets interactively. This is useful for testing and prototyping².

### 3. **HTTP/2 Client**
   - **New HTTP Client API**: A new HTTP client API was introduced to support HTTP/2 and WebSocket. It provides a more modern and efficient way to handle HTTP communication².

### 4. **Process API Improvements**
   - **Enhanced Process Handling**: The Process API was improved to provide more control and information about operating system processes. This includes methods to get process information, manage processes, and handle process trees².

### 5. **Stream API Enhancements**
   - **New Methods**: Java 9 added new methods to the Stream API, such as `takeWhile`, `dropWhile`, and `iterate`, which make it easier to work with streams³.

### 6. **Private Methods in Interfaces**
   - **Interface Enhancements**: Interfaces can now have private methods, which can be used to share common code between default methods⁴.

### 7. **Multi-Release JAR Files**
   - **Version-Specific Classes**: Multi-release JAR files allow you to include different versions of class files for different Java versions within the same JAR⁵.

### 8. **Collection Factory Methods**
   - **Convenient Collection Creation**: New factory methods were added to the `List`, `Set`, and `Map` interfaces to create immutable collections more easily⁵.

### 9. **Improved Deprecation**
   - **Enhanced Deprecation**: The `@Deprecated` annotation was enhanced to provide more information about the deprecation, including the reason and the version in which the element was deprecated⁴.



Sure! Here’s a detailed overview of Java 9 features along with code snippets where applicable:

### 1. **Project Jigsaw (Module System)**
   - **Modularity**: Introduced the module system, allowing developers to organize code into modules. This helps in better encapsulation and dependency management.
   - **Module Descriptor**: Modules are defined using a `module-info.java` file, specifying dependencies and exported packages.
   ```java
   // module-info.java
   module com.example {
       requires java.net.http;
       exports com.example;
   }
   ```

### 2. **JShell (REPL)**
   - **Interactive Tool**: JShell is a Read-Eval-Print Loop (REPL) tool that allows developers to execute Java code snippets interactively, useful for testing and prototyping.
   ```shell
   jshell> int sum(int a, int b) { return a + b; }
   jshell> sum(5, 3)
   $1 ==> 8
   ```

### 3. **HTTP/2 Client**
   - **New HTTP Client API**: A new HTTP client API was introduced to support HTTP/2 and WebSocket, providing a more modern and efficient way to handle HTTP communication.
   ```java
   import java.net.URI;
   import java.net.http.HttpClient;
   import java.net.http.HttpRequest;
   import java.net.http.HttpResponse;

   public class HttpClientExample {
       public static void main(String[] args) throws Exception {
           HttpClient client = HttpClient.newHttpClient();
           HttpRequest request = HttpRequest.newBuilder()
                   .uri(new URI("https://postman-echo.com/get"))
                   .GET()
                   .build();
           HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
           System.out.println(response.body());
       }
   }
   ```

### 4. **Process API Improvements**
   - **Enhanced Process Handling**: The Process API was improved to provide more control and information about operating system processes, including methods to get process information, manage processes, and handle process trees.
   ```java
   public class ProcessApiExample {
       public static void main(String[] args) {
           ProcessHandle currentProcess = ProcessHandle.current();
           System.out.println("PID: " + currentProcess.pid());
           ProcessHandle.Info info = currentProcess.info();
           info.command().ifPresent(cmd -> System.out.println("Command: " + cmd));
           info.startInstant().ifPresent(start -> System.out.println("Start time: " + start));
           info.totalCpuDuration().ifPresent(cpu -> System.out.println("CPU usage: " + cpu));
       }
   }
   ```

### 5. **Stream API Enhancements**
   - **New Methods**: Added new methods to the Stream API, such as `takeWhile`, `dropWhile`, and `iterate`, making it easier to work with streams.
   ```java
   import java.util.List;
   import java.util.stream.Collectors;
   import java.util.stream.Stream;

   public class StreamApiExample {
       public static void main(String[] args) {
           List<Integer> numbers = Stream.iterate(1, n -> n + 1)
                   .limit(10)
                   .collect(Collectors.toList());
           System.out.println("Numbers: " + numbers);

           List<Integer> taken = numbers.stream()
                   .takeWhile(n -> n < 5)
                   .collect(Collectors.toList());
           System.out.println("Taken: " + taken);

           List<Integer> dropped = numbers.stream()
                   .dropWhile(n -> n < 5)
                   .collect(Collectors.toList());
           System.out.println("Dropped: " + dropped);
       }
   }
   ```

### 6. **Private Methods in Interfaces**
   - **Interface Enhancements**: Interfaces can now have private methods, which can be used to share common code between default and static methods.
   ```java
   interface MyInterface {
       default void defaultMethod() {
           privateMethod();
       }

       private void privateMethod() {
           System.out.println("This is a private method");
       }
   }

   public class PrivateMethodExample implements MyInterface {
       public static void main(String[] args) {
           new PrivateMethodExample().defaultMethod();
       }
   }
   ```

### 7. **Multi-Release JAR Files**
   - **Version-Specific Classes**: Multi-release JAR files allow you to include different versions of class files for different Java versions within the same JAR.
   ```java
   // Java 8 version
   package com.example;

   public class MyClass {
       public void printVersion() {
           System.out.println("Java 8 version");
       }
   }

   // Java 9 version
   package com.example;

   public class MyClass {
       public void printVersion() {
           System.out.println("Java 9 version");
       }
   }
   ```

### 8. **Collection Factory Methods**
   - **Convenient Collection Creation**: New factory methods were added to the `List`, `Set`, and `Map` interfaces to create immutable collections more easily.
   ```java
   import java.util.List;
   import java.util.Set;
   import java.util.Map;

   public class CollectionFactoryMethodsExample {
       public static void main(String[] args) {
           List<String> immutableList = List.of("Java", "Python", "C++");
           System.out.println("Immutable List: " + immutableList);

           Set<String> immutableSet = Set.of("Apple", "Banana", "Cherry");
           System.out.println("Immutable Set: " + immutableSet);

           Map<Integer, String> immutableMap = Map.of(
               1, "One",
               2, "Two",
               3, "Three"
           );
           System.out.println("Immutable Map: " + immutableMap);
       }
   }
   ```

### 9. **Improved Deprecation**
   - **Enhanced Deprecation**: The `@Deprecated` annotation was enhanced to provide more information about the deprecation, including the reason and the version in which the element was deprecated.
   ```java
   public class DeprecationExample {
       @Deprecated(since = "9", forRemoval = true)
       public void deprecatedMethod() {
           System.out.println("This method is deprecated");
       }

       public static void main(String[] args) {
           new DeprecationExample().deprecatedMethod();
       }
   }
   ```

### 10. **Stack-Walking API**
   - **Efficient Stack Traversal**: Introduced a new Stack-Walking API to traverse and analyze stack traces in a more efficient and flexible manner.
   ```java
   import java.lang.StackWalker;
   import java.lang.StackWalker.StackFrame;

   public class StackWalkingExample {
       public static void main(String[] args) {
           StackWalker walker = StackWalker.getInstance();
           walker.forEach(frame -> System.out.println(frame.getClassName() + " - " + frame.getMethodName()));
       }
   }
   ```

### 11. **Optional Class Enhancements**
   - **New Methods**: Added new methods to the `Optional` class, such as `ifPresentOrElse`, `or`, and `stream`, to make it more versatile.
   ```java
   import java.util.Optional;

   public class OptionalExample {
       public static void main(String[] args) {
           Optional<String> optional = Optional.of("Hello");

           optional.ifPresentOrElse(
               value -> System.out.println("Value: " + value),
               () -> System.out.println("Value not present")
           );

           Optional<String> emptyOptional = Optional.empty();
           String result = emptyOptional.or(() -> Optional.of("Default")).get();
           System.out.println("Result: " + result);
       }
   }
   ```

### 12. **Platform Logging API and Service**
   - **Unified Logging**: Introduced a new logging API to provide a unified logging framework for the JVM.
   ```java
   import java.lang.System.Logger;
   import java.lang.System.Logger.Level;

   public class LoggingExample {
       private static final Logger logger = System.getLogger(LoggingExample.class.getName());

       public static void main(String[] args) {
           logger.log(Level.INFO, "This is an info message");
           logger.log(Level.ERROR, "This is an error message");
       }
   }
   ```

### 13. **Miscellaneous Improvements**
   - **Try-With-Resources Enhancement**: Simplified the try-with-resources statement by allowing the use of effectively final variables.
   ```java
   import java.io.BufferedReader;
   import java.io.FileReader;
   import java.io.IOException;

   public class TryWithResourcesExample {
       public static void main(String[] args) throws IOException {
           BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
           try (reader) {
               System.out.println(reader.readLine());
           }
       }
   }
   ```

   - **Diamond Operator for Anonymous Classes**: Extended the diamond operator to be used with anonymous classes.
   ```java
   import java.util.ArrayList;
   import java.util.List;

   public class DiamondOperatorExample {
       public static void main(String[] args) {
           List<String> list = new ArrayList<>() {
               {
                   add("Java");
                   add("Python");
               }
           };
           list.forEach(System.out::println);
       }
   }
   ```

   - **CompletableFuture API Enhancements**: Added new methods to the `CompletableFuture` API to improve its functionality.
   ```java
   Java 9 introduced several enhancements to the `CompletableFuture` API, adding new methods to improve its functionality and flexibility. Here are some of the key new methods along with examples:

### 1. `completeAsync`
This method completes the `CompletableFuture` asynchronously using a given `Supplier` and an optional `Executor`.

```java
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class CompleteAsyncExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        CompletableFuture<String> future = new CompletableFuture<>();

        future.completeAsync(() -> {
            try {
                Thread.sleep(1000); // Simulate long-running task
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Completed!";
        }, executor);

        future.thenAccept(result -> System.out.println("Result: " + result));
        executor.shutdown();
    }
}
```

### 2. `orTimeout`
This method completes the `CompletableFuture` exceptionally if it does not complete within the given timeout.

```java
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class OrTimeoutExample {
    public static void main(String[] args) {
        CompletableFuture<String> future = new CompletableFuture<>();

        future.orTimeout(1, TimeUnit.SECONDS)
              .exceptionally(ex -> "Timeout occurred!");

        future.completeAsync(() -> {
            try {
                Thread.sleep(2000); // Simulate long-running task
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Completed!";
        });

        future.thenAccept(result -> System.out.println("Result: " + result));
    }
}
```

### 3. `completeOnTimeout`
This method completes the `CompletableFuture` with a given value if it does not complete within the given timeout.

```java
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompleteOnTimeoutExample {
    public static void main(String[] args) {
        CompletableFuture<String> future = new CompletableFuture<>();

        future.completeOnTimeout("Default Value", 1, TimeUnit.SECONDS);

        future.completeAsync(() -> {
            try {
                Thread.sleep(2000); // Simulate long-running task
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Completed!";
        });

        future.thenAccept(result -> System.out.println("Result: " + result));
    }
}
```

### 4. `newIncompleteFuture`
This method returns a new `CompletableFuture` that is not yet completed.

```java
import java.util.concurrent.CompletableFuture;

public class NewIncompleteFutureExample {
    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.completedFuture("Initial Value");
        CompletableFuture<String> newFuture = future.newIncompleteFuture();

        newFuture.complete("New Value");
        newFuture.thenAccept(result -> System.out.println("Result: " + result));
    }
}
```

### 5. `minimalCompletionStage`
This method returns a minimal `CompletionStage` view of the `CompletableFuture`.

```java
import java.util.concurrent.CompletableFuture;

public class MinimalCompletionStageExample {
    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.completedFuture("Initial Value");
        CompletableFuture<String> minimalStage = future.minimalCompletionStage();

        minimalStage.thenAccept(result -> System.out.println("Result: " + result));
    }
}
