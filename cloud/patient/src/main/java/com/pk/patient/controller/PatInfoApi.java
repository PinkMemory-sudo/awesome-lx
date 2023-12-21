package com.pk.patient.controller;

import cn.hutool.core.bean.BeanUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pk.patient.dao.domain.BasicPatInfo;
import com.pk.patient.dao.service.BasicPatInfoService;
import dto.BasicPatInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pat")
@RequiredArgsConstructor
public class PatInfoApi {

    private final BasicPatInfoService basicPatInfoService;

    @GetMapping("/{id}")
    private BasicPatInfoDto getPatById(@PathVariable String id) throws JsonProcessingException {
        BasicPatInfo patInfo = basicPatInfoService.getById(id);
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(patInfo));
        return BeanUtil.toBean(patInfo, BasicPatInfoDto.class);
    }

    @PostMapping
    private void savePat(@RequestBody BasicPatInfoDto patInfoDto) {
        basicPatInfoService.save(BeanUtil.toBean(patInfoDto, BasicPatInfo.class));
    }
}
