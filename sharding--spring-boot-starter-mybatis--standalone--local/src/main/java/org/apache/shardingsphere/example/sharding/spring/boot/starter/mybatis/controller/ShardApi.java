package org.apache.shardingsphere.example.sharding.spring.boot.starter.mybatis.controller;

import lombok.RequiredArgsConstructor;
import org.apache.shardingsphere.example.sharding.spring.boot.starter.mybatis.service.ExampleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@RequestMapping("shard")
@RequiredArgsConstructor
public class ShardApi {

    private ExampleService exampleService;

    @GetMapping("test")
    public void test(){
        try {
            exampleService.run();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
