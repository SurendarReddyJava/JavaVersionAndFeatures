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
