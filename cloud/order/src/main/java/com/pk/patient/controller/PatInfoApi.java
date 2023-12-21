package com.pk.patient.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pk.patient.feign.PatInfoFeign;
import dto.BasicPatInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pat")
@RequiredArgsConstructor
public class PatInfoApi {

    private final PatInfoFeign patInfoFeign;

    @GetMapping("/{id}")
    private BasicPatInfoDto getPatById(@PathVariable String id) throws JsonProcessingException {
        return patInfoFeign.getPatById(id);
    }

    @PostMapping
    private void savePat(@RequestBody BasicPatInfoDto patInfoDto) {
        patInfoFeign.savePat(patInfoDto);
    }
}
