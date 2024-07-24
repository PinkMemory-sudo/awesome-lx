package com.pk.patient.controller;

import com.pk.patient.feign.OrderFeign;
import com.pk.patient.service.AbcService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SeataTest {

private final OrderFeign orderFeign;

private final AbcService abcService;

@GlobalTransactional
@GetMapping("/seata")
    public void test(){
    abcService.insert();
//    orderFeign.getName();
}
}
