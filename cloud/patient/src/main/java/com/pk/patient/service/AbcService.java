package com.pk.patient.service;

import com.pk.patient.domain.Abc;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author LAN-IT-0212
* @description 针对表【abc】的数据库操作Service
* @createDate 2024-07-09 21:35:33
*/
public interface AbcService extends IService<Abc> {
        void insert();
}
