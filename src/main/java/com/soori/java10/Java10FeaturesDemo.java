package com.soori.java10;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java10FeaturesDemo {

    /**
     * Demonstrates Local-Variable Type Inference using the `var` keyword.
     * This feature allows the compiler to infer the type of a local variable.
     */
    public void localVariableTypeInference() {
        var list = List.of("a", "b", "c");
        System.out.println("Local-Variable Type Inference: " + list);
    }

    /**
     * Demonstrates Unmodifiable Collections.
     * This feature provides new methods to create unmodifiable collections more easily.
     */
    public void unmodifiableCollections() {
        List<String> list = List.of("a", "b", "c");
        List<String> copy = List.copyOf(list);
        System.out.println("Unmodifiable Collections: " + copy);
    }

    /**
     * Demonstrates the Optional.orElseThrow() method.
     * This method throws NoSuchElementException if no value is present.
     */
    public void optionalOrElseThrow() {
        Optional<String> optional = Optional.of("value");
        String value = optional.orElseThrow();
        System.out.println("Optional.orElseThrow(): " + value);
    }

    /**
     * Acknowledges Performance Improvements in Java 10.
     * These improvements are internal and not directly demonstrable in code.
     */
    public void performanceImprovements() {
        System.out.println("Performance Improvements: Internal JVM enhancements.");
    }

    /**
     * Acknowledges Application Class-Data Sharing.
     * This feature reduces the startup time and footprint of Java applications by sharing common class metadata across different Java processes.
     */
    public void applicationClassDataSharing() {
        System.out.println("Application Class-Data Sharing: JVM internal feature.");
    }

    /**
     * Acknowledges Thread-Local Handshakes.
     * This feature allows executing a callback on threads without performing a global VM safepoint, improving performance.
     */
    public void threadLocalHandshakes() {
        System.out.println("Thread-Local Handshakes: JVM internal feature.");
    }

    /**
     * Acknowledges Root Certificates.
     * This feature includes the default set of root Certification Authority (CA) certificates in the JDK.
     */
    public void rootCertificates() {
        System.out.println("Root Certificates: JVM internal feature.");
    }

    /**
     * Acknowledges Heap Allocation on Alternative Memory Devices.
     * This feature enables the JVM to allocate the Java heap on an alternative memory device, such as an NVMe device.
     */
    public void heapAllocationOnAlternativeMemoryDevices() {
        System.out.println("Heap Allocation on Alternative Memory Devices: JVM internal feature.");
    }

    /**
     * Acknowledges the Experimental Java-Based JIT Compiler.
     * This feature allows the Graal JIT compiler to be used as an experimental feature.
     */
    public void experimentalJavaBasedJITCompiler() {
        System.out.println("Experimental Java-Based JIT Compiler: JVM internal feature.");
    }

    /**
     * Acknowledges Deprecated APIs and Tools.
     * Some APIs and tools have been deprecated for removal in future releases.
     */
    public void deprecatedAPIsAndTools() {
        System.out.println("Deprecated APIs and Tools: JVM internal feature.");
    }

    public static void main(String[] args) {
        Java10FeaturesDemo demo = new Java10FeaturesDemo();
        demo.localVariableTypeInference();
        demo.unmodifiableCollections();
        demo.optionalOrElseThrow();
        demo.performanceImprovements();
        demo.applicationClassDataSharing();
        demo.threadLocalHandshakes();
        demo.rootCertificates();
        demo.heapAllocationOnAlternativeMemoryDevices();
        demo.experimentalJavaBasedJITCompiler();
        demo.deprecatedAPIsAndTools();
    }
}
