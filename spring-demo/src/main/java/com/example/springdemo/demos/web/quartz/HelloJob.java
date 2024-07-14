package com.example.springdemo.demos.web.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

//@Slf4j
public class HelloJob extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {

        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
        String orderId = jobDataMap.getString("orderId");
        // get parameters
        context.getJobDetail().getJobDataMap().forEach(
                (k, v) -> System.out.println("param, key:{}, value:{}" + k + "," + v+"====="+orderId)
        );
        // your logics
        System.out.println("Hello Job执行时间: " + new Date());
    }
}