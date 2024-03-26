package juc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
        for (int i = 0; i <args.length ; i++) {

        }
        long begin = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CompletableFuture<Void> task1 = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+" :task2");
        });
        CompletableFuture<Void> task2 = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+" :task2");
        });
        CompletableFuture<Void> task3 = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+" :task2");
        });
        CompletableFuture.allOf(task1,task2,task3).join();
        long end = System.currentTimeMillis();
        System.out.println(end-begin);
    }

}
