package juc;

import lombok.extern.slf4j.Slf4j;

/**
 * 1. 异步执行
 */
@Slf4j
public class CompletableFutureTest {
    public static void main(String[] args) throws InterruptedException {
        // 1. 异步执行
//        ExecutorService executorService = Executors.newFixedThreadPool(3);
//        CompletableFuture.runAsync(() -> System.out.println(Thread.currentThread().getName()));
//        CompletableFuture.runAsync(() -> System.out.println(Thread.currentThread().getName()), executorService);
//        CompletableFuture.runAsync(() -> System.out.println(Thread.currentThread().getName()), executorService);
//        CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> Thread.currentThread().getName(), executorService);
//        try {
//            System.out.println(supplyAsync.get());
//        } catch (InterruptedException | ExecutionException e) {
//            throw new RuntimeException(e);
//        }
//        executorService.shutdown();
//
//        // 任务组合
//        CompletableFuture.supplyAsync(() -> "Hello, ")
//                .thenApplyAsync(s -> s + "CompletableFuture!")
//                .thenAcceptAsync(System.out::println);
//
//        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello, ");
//        CompletableFuture<List<String>> future2 = CompletableFuture.supplyAsync(() -> Stream.of("CompletableFuture!", "!", "!").collect(Collectors.toList()));
//        CompletableFuture<String> combinedFuture = future1.thenCombine(future2, (s1, s2) -> s1 + String.join("", s2));
//        System.out.println(combinedFuture.join());
//
//
//        // 3. 异常处理
//        CompletableFuture.runAsync(() -> {
//            throw new RuntimeException("错误");
//        }).exceptionally(ex -> {
//            System.out.println(ex.getMessage());
//            return null;
//        });
//
//        // 等待所有任务完成/任意一个
//        CompletableFuture<String> future5 = CompletableFuture.supplyAsync(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(10);
//                System.out.println("Task 1");
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            return "Task 1";
//        });
//        CompletableFuture<String> future4 = CompletableFuture.supplyAsync(() -> {
//            System.out.println("Task 2");
//            return "Task 2";
//        });
//        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
//            System.out.println("Task 3");
//            return "Task 3";
//        });
//
////        CompletableFuture.anyOf()
//        // 组合成一个
//        CompletableFuture<Void> allOf = CompletableFuture.allOf(future5, future4, future3);
//        System.out.println("j");
//        // 等待组合成的Future完成
//        allOf.join();
//        System.out.println("oin");
//        System.out.println(future3.join());
//        log.info("{}.{}.{}", future5.join(), future4.join(), future3.join());
//        System.out.println("All tasks completed");
//        System.out.println(CompletableFuture.completedFuture("speed").join());
//        // 获得计算值，get(),get(timeout),getNow,join
//        // complete(T value)  没完成时给个默认值
//
//        // 将结果传给另一个future执行,与前一个future使用同一个线程
//        System.out.println(CompletableFuture.supplyAsync(() -> "123").thenApply(it -> it + "ml").join());
//        //
//        System.out.println(CompletableFuture.supplyAsync(() -> "123").thenApplyAsync(it -> it + "ml").join());
//
//        CompletableFuture.supplyAsync(() -> "123").thenAccept(it -> {
//            System.out.println("hahah" + it);
//        });
//        // 用两个future的计算结果进行计算
//        CompletableFuture<List<Integer>> future123 = CompletableFuture.supplyAsync(() -> Stream.of(1, 2, 3).collect(Collectors.toList()));
//        CompletableFuture<List<Integer>> future456 = CompletableFuture.supplyAsync(() -> Stream.of(4, 5, 6).collect(Collectors.toList()));
//        future123.thenAcceptBoth(future456, (r1, r2) -> {
//            r1.addAll(r2);
//            r1.sort(Comparator.comparingInt(Integer::intValue).reversed());
//            System.out.println(r1);
//        });
//        // 计算完成后执行的操作，不要计算结果  thenRun
//
//        // 合并两个计算结果
//        CompletableFuture<List<Integer>> future789 = CompletableFuture.supplyAsync(() -> Stream.of(7,8,9).collect(Collectors.toList()));
//        CompletableFuture<List<Integer>> combine = future123.thenCombine(future456, (r1, r2) -> {
//            r1.addAll(r2);
//            return r1;
//        }).thenCombine(future789, (r1, r2) -> {
//            r1.addAll(r2);
//            return r1;
//        });
//        System.out.println(combine.join());

//        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
//            throw new RuntimeException("tt");
//        });
//        voidCompletableFuture.join();
//        try {
//            TimeUnit.SECONDS.sleep(10);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

//        System.out.println(DigestUtil.md5Hex("1922年12月初，宋子文在上海莫利哀路孙中山寓所举办社区基督教晚会，蒋、宋美龄都参加，二人首次谋面"));

//        Executors.newFixedThreadPool(1).submit(() -> {
//            try {
//            log.info(Thread.currentThread().getName());
                throw new RuntimeException("haha");
//            } catch (RuntimeException e) {
//                log.error("error", e);
//            }
//        });
//        TimeUnit.SECONDS.sleep(10);

    }

}

