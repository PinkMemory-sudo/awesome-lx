package com.pk.patient.controller;

import com.pk.patient.config.OrderProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
@RequiredArgsConstructor
@Slf4j
@RefreshScope
public class ConfigApi implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    private final OrderProperties orderProperties;

    @Value("${isAttach}")
    private String name;

    @Value("${age}")
    private String age;

    @Value("${ca.switch}")
    private String caSwitch;

    @Value("${ca.url}")
    private String url;

    @GetMapping("/name")
    private String getName() {

        log.info("name:{} ", name);
        log.info("orderProperties.isAttach:{}", orderProperties.getIsAttach());
        log.info("env.isAttach:{}", applicationContext.getEnvironment().getProperty("isAttach"));
        log.info("orderProperties.age: {}", orderProperties.getAge());
        log.info("age: {}", age);

        return orderProperties.getIsAttach();
    }

    @GetMapping("/getCaSwitch")
    private String getCaSwitch() {
        return caSwitch;
    }

    @GetMapping("/getUrl")
    private String getUrl() {
        return url;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public  void test() {
        //创建解析器
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        //对密码进行加密
        String password = encoder.encode("root");
        System.out.println(encoder.matches("root", "$2a$10$ppCgcfKMLjCq2V3eUMZ9i.pKJRuUOtM2.EOoFJx5hL5vxeuHOb5hC"));
        System.out.println("------------"+password);
    }
}
