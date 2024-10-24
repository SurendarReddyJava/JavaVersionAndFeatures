Here is a brief overview of Java 14 features that you can include in your `README.md` file:

### Java 14 Features

1. **Switch Expressions (Standard)**
   - Enhances the switch statement to be used as an expression.
   - Example:
     ```java
     int result = switch (day) {
         case "MONDAY", "FRIDAY", "SUNDAY" -> 6;
         case "TUESDAY" -> 7;
         case "THURSDAY", "SATURDAY" -> 8;
         case "WEDNESDAY" -> 9;
         default -> throw new IllegalStateException("Unexpected value: " + day);
     };
     ```

2. **Pattern Matching for `instanceof` (Preview)**
   - Simplifies the common pattern of using `instanceof` followed by a cast.
   - Example:
     ```java
     if (obj instanceof String s) {
         System.out.println(s.toLowerCase());
     }
     ```

3. **Records (Preview)**
   - Provides a compact syntax for declaring classes which are transparent holders for shallowly immutable data.
   - Example:
     ```java
     public record Point(int x, int y) {}
     ```

4. **Helpful NullPointerExceptions**
   - Improves the usability of `NullPointerException` by describing precisely which variable was `null`.

5. **Text Blocks (Second Preview)**
   - Continues to simplify the creation of multi-line string literals.
   - Example:
     ```java
     String textBlock = """
         This is a text block.
         It spans multiple lines.
         """;
     ```

### Documentation

#### Switch Expressions
Switch expressions simplify coding by extending the switch statement so it can be used as an expression. This feature is now standard in Java 14.

#### Pattern Matching for `instanceof`
Pattern matching for `instanceof` simplifies the common pattern of using `instanceof` followed by a cast. This feature is in preview and can be enabled with the `--enable-preview` flag.

#### Records
Records provide a compact syntax for declaring classes which are transparent holders for shallowly immutable data. This feature is in preview and can be enabled with the `--enable-preview` flag.

#### Helpful NullPointerExceptions
Helpful `NullPointerException`s improve the usability of `NullPointerException` by describing precisely which variable was `null`.

#### Text Blocks
Text blocks continue to simplify the creation of multi-line string literals. This feature is in its second preview and can be enabled with the `--enable-preview` flag.

### Enabling Preview Features
To use preview features like Pattern Matching for `instanceof`, Records, and Text Blocks, compile and run your code with the `--enable-preview` flag:
```sh
javac --enable-preview --release 14 YourClass.java
java --enable-preview YourClass
```

This summary provides an overview of the new features introduced in Java 14 and how to use them. For more detailed information, refer to the official [Java 14 documentation](https://openjdk.java.net/projects/jdk/14/).
