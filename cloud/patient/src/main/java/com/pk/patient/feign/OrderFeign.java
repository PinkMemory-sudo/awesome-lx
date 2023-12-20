package com.pk.patient.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "order")
public interface OrderFeign {

    @GetMapping("/config/name")
    String getName();
}
