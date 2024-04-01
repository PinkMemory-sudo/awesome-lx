package com.example.springdemo.demos.web.controller;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("cache")
public class CacheApi {

    @GetMapping("/test")
    @Cacheable(value = "#result",key ="#name",cacheManager = "caffeineCacheManager")
    public String test(String name) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);

        }
        return "test";
    }

}
