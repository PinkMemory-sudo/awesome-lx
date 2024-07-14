package com.example.springdemo.demos.web.quartz;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/quartz")
public class TestAPI {

    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;

    @GetMapping("/test/{orderId}")
    public void test(@PathVariable String orderId) throws SchedulerException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();

        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("orderId", orderId);
        // 创建 JobDetail
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                .withIdentity("jobName"+orderId, "groupName"+orderId)
                .usingJobData(jobDataMap)
                .build();

        // 创建 Trigger
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/1 * * * * ?");
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("jobName"+orderId + "Trigger", "groupName"+orderId + "Trigger")
                .withSchedule(cronScheduleBuilder)
                .build();

        // 调度 JobDetail 和 Trigger
        scheduler.scheduleJob(jobDetail, trigger);
    }


}
