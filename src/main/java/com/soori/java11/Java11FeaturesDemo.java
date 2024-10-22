package com.soori.java11;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.stream.Stream;

public class Java11FeaturesDemo {

    /**
     * Demonstrates new String methods in Java 11.
     */
    public void newStringMethods() {
        String str = " Hello World ";
        System.out.println("isBlank: " + str.isBlank());
        System.out.println("lines: " + str.lines().count());
        System.out.println("strip: " + str.strip());
        System.out.println("stripLeading: " + str.stripLeading());
        System.out.println("stripTrailing: " + str.stripTrailing());
        System.out.println("repeat: " + str.repeat(2));
    }

    /**
     * Demonstrates Local-Variable Syntax for Lambda Parameters.
     */
    public void localVariableSyntaxForLambda() {
        Stream.of(1, 2, 3).map((var x) -> x * x).forEach(System.out::println);
    }

    /**
     * Demonstrates the HttpClient API with a synchronous request.
     */
    public void httpClientAPISynchronous() throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://example.com"))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("HttpClient API (Synchronous): " + response.body());
    }

    /**
     * Demonstrates the HttpClient API with an asynchronous request.
     */
    public void httpClientAPIAsynchronous() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://example.com"))
                .build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenAccept(response -> System.out.println("HttpClient API (Asynchronous): " + response.body()));
    }

    /**
     * Demonstrates Nest-Based Access Control.
     */
    public void nestBasedAccessControl() {
        // This feature is related to JVM internals and not directly demonstrable in code.
        System.out.println("Nest-Based Access Control: JVM internal feature.");
    }

    /**
     * Demonstrates Dynamic Class-File Constants.
     */
    public void dynamicClassFileConstants() {
        // This feature is related to JVM internals and not directly demonstrable in code.
        System.out.println("Dynamic Class-File Constants: JVM internal feature.");
    }

    /**
     * Demonstrates Epsilon: A No-Op Garbage Collector.
     */
    public void epsilonGarbageCollector() {
        // This feature is related to JVM internals and not directly demonstrable in code.
        System.out.println("Epsilon Garbage Collector: JVM internal feature.");
    }

    /**
     * Demonstrates Flight Recorder.
     */
    public void flightRecorder() {
        // This feature is related to JVM internals and not directly demonstrable in code.
        System.out.println("Flight Recorder: JVM internal feature.");
    }

    /**
     * Demonstrates Launch Single-File Source-Code Programs.
     */
    public void launchSingleFileSourceCodePrograms() {
        //java HelloWorld.java -> this command internally compiles and runs the program.
        // This feature is related to JVM internals and not directly demonstrable in code.
        System.out.println("Launch Single-File Source-Code Programs: JVM internal feature.");
    }

    /**
     * Demonstrates Deprecate the Pack200 Tools and API.
     */
    public void deprecatePack200ToolsAndAPI() {
        // This feature is related to JVM internals and not directly demonstrable in code.
        System.out.println("Deprecate Pack200 Tools and API: JVM internal feature.");
    }

    /**
     * Demonstrates Unicode 10 support.
     */
    public void unicode10Support() {
        // This feature is related to JVM internals and not directly demonstrable in code.
        System.out.println("Unicode 10 Support: JVM internal feature.");
    }

    /**
     * Demonstrates ZGC: A Scalable Low-Latency Garbage Collector.
     */
    public void zgcGarbageCollector() {
        // This feature is related to JVM internals and not directly demonstrable in code.
        System.out.println("ZGC Garbage Collector: JVM internal feature.");
    }

    /**
     * Demonstrates Remove the Java EE and CORBA Modules.
     */
    public void removeJavaEEAndCORBA() {
        // This feature is related to JVM internals and not directly demonstrable in code.
        System.out.println("Remove Java EE and CORBA Modules: JVM internal feature.");
    }

    /**
     * Demonstrates new File methods in Java 11.
     */
    public void newFileMethods() throws Exception {
        Path path = Files.createTempFile("example", ".txt");
        Files.writeString(path, "Hello, World!");
        String content = Files.readString(path);
        System.out.println("New File Methods: " + content);
    }

    /**
     * Demonstrates Key Agreement with Curve25519 and Curve448.
     */
    public void keyAgreementWithCurve25519AndCurve448() {
        // This feature is related to JVM internals and not directly demonstrable in code.
        System.out.println("Key Agreement with Curve25519 and Curve448: JVM internal feature.");
    }

    /**
     * Demonstrates ChaCha20 and Poly1305 Cryptographic Algorithms.
     */
    public void chaCha20AndPoly1305() {
        // This feature is related to JVM internals and not directly demonstrable in code.
        System.out.println("ChaCha20 and Poly1305 Cryptographic Algorithms: JVM internal feature.");
    }

    /**
     * Demonstrates TLS 1.3 support.
     */
    public void tls13Support() {
        // This feature is related to JVM internals and not directly demonstrable in code.
        System.out.println("TLS 1.3 Support: JVM internal feature.");
    }

    /**
     * Demonstrates Deprecate Nashorn JavaScript Engine.
     */
    public void deprecateNashornJavaScriptEngine() {
        // This feature is related to JVM internals and not directly demonstrable in code.
        System.out.println("Deprecate Nashorn JavaScript Engine: JVM internal feature.");
    }

    /**
     * Demonstrates new Optional methods in Java 11.
     */
    public void newOptionalMethods() {
        Optional<String> optional = Optional.of("value");
        System.out.println("isEmpty: " + optional.isEmpty());
    }

    public static void main(String[] args) throws Exception {
        Java11FeaturesDemo demo = new Java11FeaturesDemo();
        demo.newStringMethods();
        demo.localVariableSyntaxForLambda();
        demo.httpClientAPISynchronous();
        demo.httpClientAPIAsynchronous();
        demo.nestBasedAccessControl();
        demo.dynamicClassFileConstants();
        demo.epsilonGarbageCollector();
        demo.flightRecorder();
        demo.launchSingleFileSourceCodePrograms();
        demo.deprecatePack200ToolsAndAPI();
        demo.unicode10Support();
        demo.zgcGarbageCollector();
        demo.removeJavaEEAndCORBA();
        demo.newFileMethods();
        demo.keyAgreementWithCurve25519AndCurve448();
        demo.chaCha20AndPoly1305();
        demo.tls13Support();
        demo.deprecateNashornJavaScriptEngine();
        demo.newOptionalMethods();
    }
}
