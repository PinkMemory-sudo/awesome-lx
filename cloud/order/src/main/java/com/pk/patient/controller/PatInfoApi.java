package com.pk.patient.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pk.patient.feign.PatInfoFeign;
import com.pk.patient.service.PatService;
import dto.BasicPatInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pat")
@RequiredArgsConstructor
public class PatInfoApi {

    private final PatInfoFeign patInfoFeign;

    @Value("${ca.switch}")
    private String caSwitch;

    @Value("${ca.url:123}")
    private String url;

    private final PatService patService;

    @GetMapping("/{id}")
//    @GlobalTransactional(rollbackFor = Exception.class)
    public int getPatById(@PathVariable String id) throws JsonProcessingException {
        patInfoFeign.getPatById(id);
        return 1 / 0;
    }

    @PostMapping
    private void savePat(@RequestBody BasicPatInfoDto patInfoDto) {
        patInfoFeign.savePat(patInfoDto);
    }

    @GetMapping("/getCaSwitch")
    private String getCaSwitch() {
        return caSwitch;
    }

    @GetMapping("/getUrl")
    private String getUrl() {
        return patService.getUrl();
    }
}
