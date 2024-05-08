package com.example.springdemo.demos.web.controller;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/redisson")
public class RedissonTest {

    @Autowired
    private RedissonClient redissonClient;

    @GetMapping("/test")
    public void test() {
        CompletableFuture<Void> runAsync1 = CompletableFuture.runAsync(() -> getIt("1"));
        CompletableFuture<Void> runAsync2 = CompletableFuture.runAsync(() -> getIt("2"));
        CompletableFuture<Void> runAsync3 = CompletableFuture.runAsync(() -> getIt("3"));
        CompletableFuture<Void> allOf = CompletableFuture.allOf(runAsync1, runAsync2, runAsync3);
        allOf.join();
    }

    public void getIt(String id) {
        RLock test = redissonClient.getLock("aws-lx");
        System.out.println("entry " + id + " " + Thread.currentThread().getId());
        try {
            boolean getLock = test.tryLock(60, TimeUnit.SECONDS);
            TimeUnit.SECONDS.sleep(10);
            if (getLock) {
                System.out.println("get it " + id + " " + Thread.currentThread().getId());
            }
        } catch (Exception e) {
            System.out.println("unlock " + id);
            e.printStackTrace();
        } finally {
            try {
                test.unlock();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}
