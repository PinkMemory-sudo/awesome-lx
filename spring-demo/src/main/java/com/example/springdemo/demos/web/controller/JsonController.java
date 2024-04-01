package com.example.springdemo.demos.web.controller;

import com.example.springdemo.demos.web.model.entity.Order;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RequestMapping("/json")
@RestController
public class JsonController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    @PostMapping("/getJsonNode")
    @Cacheable(value = "redis",key = "'getJsonNode'")
    public Map<String, String> getJsonNode() throws JsonProcessingException, InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        Map<String,String> map=new HashMap<>();
        map.put("name","Tom");
        System.out.println("===================================");
        return map;
    }

    @PostMapping("/putJsonNode")
    public Order getJsonNode(@RequestBody JsonNode jsonNode) throws IOException {
        JsonParser traverse = jsonNode.traverse();
        return new ObjectMapper().readValue(traverse, Order.class);
    }



}
