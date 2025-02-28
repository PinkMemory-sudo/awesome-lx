package com.pk.patient.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
@RequiredArgsConstructor
@Slf4j
public class ConfigApi {

    @Value("${name:tom}")
    private String name;

    @GetMapping("/name")
    private String getName() {
        log.info("Processing request with traceId: {}", name);
        return name;
    }

}
