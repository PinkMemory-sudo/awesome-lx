package com.example.springdemo.demos.web;

import com.xxl.job.core.context.XxlJobContext;
import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import groovy.util.logging.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;


@Component
@Slf4j
public class Xxljob {

    @XxlJob("demoJobHandler")
    public void demoJobHandler() throws Exception {
        XxlJobContext xxlJobContext = XxlJobContext.getXxlJobContext();
        String jobParam = xxlJobContext.getJobParam();
        XxlJobHelper.log("XXL-JOB, Hello World.");
        System.out.println(LocalDateTime.now()+"  hahha "+jobParam);
        for (int i = 0; i < 5; i++) {
            XxlJobHelper.log("beat at:" + i);
            TimeUnit.SECONDS.sleep(2);
        }
        // default success
    }
}
