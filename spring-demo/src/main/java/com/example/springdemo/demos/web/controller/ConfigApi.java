package com.example.springdemo.demos.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class ConfigApi {

    @Value("${spring.cloud.nacos.config.group}")
    private String name;

    @GetMapping("/name")
    private String getName(){
        return name;
    }

}
