package com.advanced.future;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;

/**
 * CompletableFuture 是 Java 8 中提供的一个用于处理异步任务的类。
 * 它提供了一系列方法用于执行异步操作，例如 supplyAsync()、thenApply()、thenAcceptAsync()、thenCompose() 等。
 * 它还提供了 Future 接口的所有方法，例如 get()、cancel() 等。
 * <p>
 * CompletableFuture 类的构造函数接收一个 Supplier 对象作为参数，Supplier 是一个函数式接口，
 * 它只有一个方法 apply()，用于生成异步任务的结果。
 * <p>
 * CompletableFuture 类还提供了一些方法用于处理异步任务的结果，例如 get()、join()、thenApply()、thenCompose() 等。
 */
public class CompletableFutureTest {

    /**
     * 测试 CompletableFuture 类的 supplyAsync() 方法
     * <p>
     * supplyAsync: 异步执行任务，并返回一个 CompletableFuture 对象
     * get: 获取异步任务的结果，如果任务未完成，则阻塞等待
     */
    @Test
    @SneakyThrows
    public void testCompletableFutureSupplyAsync() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            // 模拟耗时操作
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Hello from CompletableFuture!";
        });

        System.out.println("Doing something else...");

        // 获取结果，这里会阻塞直到结果可用
        String result = future.get();
        System.out.println(result);
    }

    /**
     * 测试 CompletableFuture 类的 thenApply() 方法
     * <p>
     * thenApply: 在前一个任务的结果上进行转换，并返回一个新的 CompletableFuture 对象
     * thenAccept: 在前一个任务的结果上进行操作，并返回一个新的 CompletableFuture 对象
     * <p>
     * thenApply和thenAccept区别：thenApply返回一个新的CompletableFuture对象，
     * 而thenAccept返回一个CompletableFuture对象，但是这个对象没有结果，只是用来处理结果。
     */
    @Test
    @SneakyThrows
    public void testCompletableFutureThenApply() {
        CompletableFuture.supplyAsync(() -> "Hello")
                .thenApplyAsync(s -> s + " World") // 在前一个结果上进行转换
                .thenAcceptAsync(s -> System.out.println("Result: " + s)); // 处理结果，无返回值

        // 确保所有任务完成
        Thread.sleep(1000);
    }

    /**
     * 测试 CompletableFuture 类的 thenCombine() 方法
     * <p>
     * thenCombine: 在两个任务的结果上进行合并，并返回一个新的 CompletableFuture 对象
     */
    @Test
    @SneakyThrows
    public void testCompletableFutureThenCombine() {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "World");

        CompletableFuture<String> combined = future1.thenCombine(future2, (s1, s2) -> s1 + " " + s2);

        System.out.println(combined.get()); // 输出 "Hello World"
    }

    /**
     * 测试 CompletableFuture 类的 join() 方法
     * <p>
     * join: 等待异步任务的结果，如果任务未完成，则阻塞等待
     */
    @Test
    @SneakyThrows
    public void testCompletableFutureJoin() {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            // 模拟耗时操作
            try {
                System.out.println("future1 is running...");
                Thread.sleep(3000);
                System.out.println("future1 is done!");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Hello from future1 !";
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            // 模拟耗时操作
            try {
                System.out.println("future2 is running...");
                Thread.sleep(500);
                System.out.println("future2 is done!");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Hello from future2 !";
        });
        // 等待两个任务完成
        CompletableFuture.allOf(future1, future2).join();
        CompletableFuture.supplyAsync(() -> "Hello World!")
                .thenAcceptAsync(s -> System.out.println("Result: " + s)); // 处理结果，无返回值
        // 确保所有任务完成
        Thread.sleep(1000);
    }

    /**
     * 测试 CompletableFuture 类的 exceptionally() 方法
     * <p>
     * exceptionally: 处理异常，并返回一个新的 CompletableFuture 对象
     */
    @Test
    public void testCompletableFutureExceptionally() {
        CompletableFuture.supplyAsync(() -> {
            if (true) {
                throw new RuntimeException("Oops!");
            } else {
                return "Hello";
            }
        }).exceptionally(ex -> { // 处理异常
            System.err.println("Caught exception: " + ex.getMessage());
            return "Recovery message";
        }).thenAccept(System.out::println); // 输出恢复信息
    }
}
