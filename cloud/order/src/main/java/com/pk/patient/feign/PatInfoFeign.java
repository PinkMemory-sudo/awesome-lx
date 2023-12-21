package com.pk.patient.feign;

import dto.BasicPatInfoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("patient")
public interface PatInfoFeign {

    @GetMapping("pat/{id}")
    BasicPatInfoDto getPatById(@PathVariable String id);

    @PostMapping("/pat")
    void savePat(@RequestBody BasicPatInfoDto patInfoDto);
}
