package com.pk.patient.domain.convert;


import com.pk.patient.domain.entity.BasicPatInfo;
import dto.BasicPatInfoDto;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

/**
 * 1.实体转实体，名字不相同
 */
@Mapper(componentModel = "spring")
public interface PatConvert {


    @Mapping(target = "delete", source = "isDelete")
    BasicPatInfoDto getDto(BasicPatInfo basicPatInfo);

    List<BasicPatInfoDto> getDtoList(List<BasicPatInfo> basicPatInfoList);

    BasicPatInfo copyPatInfo(BasicPatInfo basicPatInfo);

    List<BasicPatInfo> copyPatInfoList(List<BasicPatInfo> basicPatInfoList);

    default LocalDateTime formDate(Date date) {
        return date == null ? null : LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    default String formString(String str) {
        return StringUtils.isBlank(str) ? "-" : str;
    }

}
