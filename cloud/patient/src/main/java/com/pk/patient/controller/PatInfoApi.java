package com.pk.patient.controller;

import cn.hutool.core.bean.BeanUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.pk.patient.dao.service.BasicPatInfoService;
import com.pk.patient.domain.entity.BasicPatInfo;
import dto.BasicPatInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pat")
@RequiredArgsConstructor
public class PatInfoApi {

    private final BasicPatInfoService basicPatInfoService;


    @GetMapping("/{id}")
    public void getPatById(@PathVariable String id) throws JsonProcessingException {
        basicPatInfoService.save(new BasicPatInfo(Long.parseLong(id), "123"));
    }

    @PostMapping
    private void savePat(@RequestBody BasicPatInfoDto patInfoDto) {
        basicPatInfoService.save(BeanUtil.toBean(patInfoDto, BasicPatInfo.class));
    }
}
