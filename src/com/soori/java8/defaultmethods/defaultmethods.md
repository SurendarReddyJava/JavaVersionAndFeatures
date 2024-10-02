Java 8 introduced several default methods in the Java API, particularly in the `java.util` package, to enhance the functionality of collections and provide backward compatibility. Here are some notable default methods added in Java 8:

### Collection Interface
- **`forEach(Consumer<? super T> action)`**: Performs the given action for each element of the `Iterable` until all elements have been processed or the action throws an exception.
- **`removeIf(Predicate<? super E> filter)`**: Removes all elements of this collection that satisfy the given predicate.
- **`spliterator()`**: Creates a `Spliterator` over the elements in this collection.

### List Interface
- **`replaceAll(UnaryOperator<E> operator)`**: Replaces each element of this list with the result of applying the operator to that element.
- **`sort(Comparator<? super E> c)`**: Sorts this list according to the order induced by the specified comparator.

### Map Interface
- **`forEach(BiConsumer<? super K, ? super V> action)`**: Performs the given action for each entry in this map until all entries have been processed or the action throws an exception.
- **`replaceAll(BiFunction<? super K, ? super V, ? extends V> function)`**: Replaces each entry's value with the result of invoking the given function on that entry until all entries have been processed or the function throws an exception.
- **`putIfAbsent(K key, V value)`**: If the specified key is not already associated with a value (or is mapped to `null`), associates it with the given value and returns `null`, else returns the current value.
- **`remove(Object key, Object value)`**: Removes the entry for the specified key only if it is currently mapped to the specified value.
- **`replace(K key, V oldValue, V newValue)`**: Replaces the entry for the specified key only if currently mapped to the specified value.
- **`replace(K key, V value)`**: Replaces the entry for the specified key only if it is currently mapped to some value.
- **`computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction)`**: If the specified key is not already associated with a value (or is mapped to `null`), attempts to compute its value using the given mapping function and enters it into this map unless `null`.
- **`computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)`**: If the value for the specified key is present and non-null, attempts to compute a new mapping given the key and its current mapped value.
- **`compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)`**: Attempts to compute a mapping for the specified key and its current mapped value (or `null` if there is no current mapping).
- **`merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction)`**: If the specified key is not already associated with a value or is associated with `null`, associates it with the given non-null value. Otherwise, replaces the associated value with the results of the given remapping function.

### Comparator Interface
- **`thenComparing(Comparator<? super T> other)`**: Returns a lexicographic-order comparator with another comparator.
- **`thenComparing(Function<? super T, ? extends U> keyExtractor, Comparator<? super U> keyComparator)`**: Returns a lexicographic-order comparator with a function that extracts a key to be compared with the given comparator.
- **`thenComparing(Function<? super T, ? extends U> keyExtractor)`**: Returns a lexicographic-order comparator with a function that extracts a `Comparable` key.
- **`reversed()`**: Returns a comparator that imposes the reverse of the natural ordering.

These default methods significantly enhance the functionality and flexibility of the Java Collections Framework, making it easier to work with collections in a more functional and expressive way¹²³.

If you have any specific questions about these methods or need examples, feel free to ask!

¹: [GeeksforGeeks](https://www.geeksforgeeks.org/default-methods-java/)
²: [DigitalOcean](https://www.digitalocean.com/community/tutorials/java-8-features-with-examples)
³: [Java Guides](https://www.javaguides.net/2018/07/java-8-static-and-default-methods-in-interface.html)

Source: Conversation with Copilot, 2/10/2024
(1) Default Methods In Java 8 - GeeksforGeeks. https://www.geeksforgeeks.org/default-methods-java/.
(2) Default methods in Java 8, and what it changes in API design - A Java geek. https://blog.frankel.ch/default-methods-java-8/.
(3) Java 8 Features with Examples - DigitalOcean. https://www.digitalocean.com/community/tutorials/java-8-features-with-examples.
(4) Java 8 Static and Default Methods in Interface - Java Guides. https://www.javaguides.net/2018/07/java-8-static-and-default-methods-in-interface.html.
