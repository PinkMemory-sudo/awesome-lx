package com.example.springdemo.demos.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @GetMapping("/getParams")
    public String getParam(String a, Integer b) {
        return "get success a=" + a + ", b=" + b;
    }

    @GetMapping("/postTest")
    public String postTest(HttpServletRequest request, HttpServletResponse response) {
        AsyncContext asyncContext = request.startAsync(request, response);
        new Thread(() -> {
            //模拟业务请求
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            String age2 = request.getParameter("age");
            log.info("age2:{}", age2);
            asyncContext.complete();
        }).start();
        String age1 = request.getParameter("age");
        log.info("age1:{}", age1);
        return "post success";
    }

}
