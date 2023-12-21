package com.pk.patient.dao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pk.patient.dao.domain.BasicPatInfo;
import com.pk.patient.dao.mapper.BasicPatInfoMapper;
import com.pk.patient.dao.service.BasicPatInfoService;
import org.springframework.stereotype.Service;

/**
* @author LAN-IT-0212
* @description 针对表【basic_pat_info(患者基本信息表)】的数据库操作Service实现
* @createDate 2023-12-21 14:29:50
*/
@Service
public class BasicPatInfoServiceImpl extends ServiceImpl<BasicPatInfoMapper, BasicPatInfo>
    implements BasicPatInfoService {

}




