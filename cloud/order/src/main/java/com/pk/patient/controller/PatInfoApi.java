package com.pk.patient.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pk.patient.feign.PatInfoFeign;
import dto.BasicPatInfoDto;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.beans.Transient;

@RestController
@RequestMapping("/pat")
@RequiredArgsConstructor
public class PatInfoApi {

    private final PatInfoFeign patInfoFeign;

    @GetMapping("/{id}")
    @GlobalTransactional(rollbackFor = Exception.class)
    public int getPatById(@PathVariable String id) throws JsonProcessingException {
        patInfoFeign.getPatById(id);
        return 1 / 0;
    }

    @PostMapping
    private void savePat(@RequestBody BasicPatInfoDto patInfoDto) {
        patInfoFeign.savePat(patInfoDto);
    }
}
