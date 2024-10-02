package com.soori.java8.concurrent;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000); // Simulate long-running task
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello, World!";
        });

        future.thenAccept(result -> System.out.println("Result: " + result));
        System.out.println("Doing other work...");

        // Block and get the result (for demonstration purposes)
        System.out.println("Blocking result: " + future.get());
    }
}
