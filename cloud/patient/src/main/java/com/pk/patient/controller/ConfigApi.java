package com.pk.patient.controller;

import com.pk.patient.feign.OrderFeign;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
@RequiredArgsConstructor
public class ConfigApi {

    private final OrderFeign orderFeign;

    @GetMapping("/name")
    private String getName() {
        return orderFeign.getName();
    }

}
