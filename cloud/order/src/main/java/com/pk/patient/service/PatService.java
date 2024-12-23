package com.pk.patient.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

@Service
@RefreshScope
public class PatService {


    @Value("${ca.switch}")
    private String caSwitch;

    @Value("${ca.url:123}")
    private String url;


    public String getCaSwitch() {
        return caSwitch;
    }

    public String getUrl() {
        return url;
    }
}
