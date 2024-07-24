package com.pk.patient.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pk.patient.domain.Abc;
import com.pk.patient.service.AbcService;
import com.pk.patient.mapper.AbcMapper;
import org.springframework.stereotype.Service;

/**
 * @author LAN-IT-0212
 * @description 针对表【abc】的数据库操作Service实现
 * @createDate 2024-07-09 21:35:33
 */
@Service
public class AbcServiceImpl extends ServiceImpl<AbcMapper, Abc>
        implements AbcService {

    @Override
    public void insert() {
        save(new Abc(1));
    }
}




