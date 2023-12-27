package com.pk.patient.controller;

import cn.hutool.core.bean.BeanUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pk.patient.dao.service.BasicPatInfoService;
import com.pk.patient.domain.convert.PatConvert;
import com.pk.patient.domain.entity.BasicPatInfo;
import dto.BasicPatInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pat")
@RequiredArgsConstructor
public class PatInfoApi {

    private final BasicPatInfoService basicPatInfoService;

    private final PatConvert patConvert;

    @GetMapping("/{id}")
    private BasicPatInfoDto getPatById(@PathVariable String id) throws JsonProcessingException {
        BasicPatInfo patInfo = basicPatInfoService.getById(id);
        ObjectMapper objectMapper = new ObjectMapper();
        StopWatch stopWatch = new StopWatch();
        BasicPatInfoDto beanDto = new BasicPatInfoDto();
        BasicPatInfoDto mapDto = new BasicPatInfoDto();
        stopWatch.start("BeanUtil");
        for (int i = 0; i < 2; i++) {
            beanDto = BeanUtil.toBean(patInfo, BasicPatInfoDto.class);
        }
        stopWatch.stop();
        stopWatch.start("mapStruct");
        for (int i = 0; i < 2; i++) {
            mapDto = patConvert.getDto(patInfo);
        }
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
        System.out.println(beanDto);
        System.out.println(mapDto);
        System.out.println(mapDto.equals(beanDto));

        return BeanUtil.toBean(patInfo, BasicPatInfoDto.class);
    }

    @PostMapping
    private void savePat(@RequestBody BasicPatInfoDto patInfoDto) {
        basicPatInfoService.save(BeanUtil.toBean(patInfoDto, BasicPatInfo.class));
    }
}
