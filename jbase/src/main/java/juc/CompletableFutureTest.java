package juc;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 1. 异步执行
 */
@Slf4j
public class CompletableFutureTest {
    public static void main(String[] args) {
        // 1. 异步执行
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CompletableFuture.runAsync(() -> System.out.println(Thread.currentThread().getName()));
        CompletableFuture.runAsync(() -> System.out.println(Thread.currentThread().getName()), executorService);
        CompletableFuture.runAsync(() -> System.out.println(Thread.currentThread().getName()), executorService);
        CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> Thread.currentThread().getName(), executorService);
        try {
            System.out.println(supplyAsync.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        executorService.shutdown();

        // 任务组合
        CompletableFuture.supplyAsync(() -> "Hello, ")
                .thenApplyAsync(s -> s + "CompletableFuture!")
                .thenAcceptAsync(System.out::println);

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello, ");
        CompletableFuture<List<String>> future2 = CompletableFuture.supplyAsync(() -> Stream.of("CompletableFuture!", "!", "!").collect(Collectors.toList()));
        CompletableFuture<String> combinedFuture = future1.thenCombine(future2, (s1, s2) -> s1 + String.join("", s2));
        System.out.println(combinedFuture.join());


        // 3. 异常处理
        CompletableFuture.runAsync(() -> {
            throw new RuntimeException("政治错误");
        }).exceptionally(ex -> {
            System.out.println(ex.getMessage());
            return null;
        });

        // 等待所有任务完成/任意一个
        CompletableFuture<String> future5 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Task 1");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Task 1";
        });
        CompletableFuture<String> future4 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task 2");
            return "Task 2";
        });
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task 3");
            return "Task 3";
        });

        CompletableFuture<Void> allOf = CompletableFuture.allOf(future5, future4, future3);
        allOf.join();
        System.out.println("All tasks completed");


    }
}
