package org.apache.shardingsphere.example.sharding.spring.boot.starter.mybatis;

import lombok.RequiredArgsConstructor;
import org.apache.shardingsphere.example.sharding.spring.boot.starter.mybatis.service.ExampleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("/tets")
@RequiredArgsConstructor
public class TestApi {

    private final ExampleService exampleService;
    @GetMapping("/init")
    public void init() throws SQLException {
        exampleService.initEnvironment();
    }

    @GetMapping("/insertData")
    public void insertData() throws SQLException {
        exampleService.insertData();
    }

}
