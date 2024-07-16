package com.example.springdemo.demos.web.quartz.test;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
public class JobStartupRunner implements CommandLineRunner {
    @Autowired
    SchedulerConfig schedulerConfig;
    private static String TRIGGER_GROUP_NAME = "test_trigger";
    private static String JOB_GROUP_NAME = "test_job";

    @Override
    public void run(String... args) throws Exception {
        Scheduler scheduler;
        try {
            scheduler = schedulerConfig.scheduler();
            TriggerKey triggerKey = TriggerKey.triggerKey("trigger1", TRIGGER_GROUP_NAME);
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            if (null == trigger) {
                Class clazz = QuartzJob.class;
                JobDetail jobDetail = JobBuilder.newJob(clazz).withIdentity("job1", JOB_GROUP_NAME)
                        .usingJobData("name","weiz QuartzJob").build();
                CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/20 * * * * ?");
                trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", TRIGGER_GROUP_NAME)
                        .withSchedule(scheduleBuilder).build();
                scheduler.scheduleJob(jobDetail, trigger);
                System.out.println("Quartz 创建了job:...:" + jobDetail.getKey());
            } else {
                System.out.println("job已存在:{}" + trigger.getKey());
            }

//            TriggerKey triggerKey2 = TriggerKey.triggerKey("trigger2", TRIGGER_GROUP_NAME);
//            CronTrigger trigger2 = (CronTrigger) scheduler.getTrigger(triggerKey2);
//            if (null == trigger2) {
//                Class clazz = QuartzJob.class;
//                JobDetail jobDetail2 = JobBuilder.newJob(clazz).withIdentity("job2", JOB_GROUP_NAME).usingJobData("name","weiz QuartzJob2").build();
//                CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/10 * * * * ?");
//                trigger2 = TriggerBuilder.newTrigger().withIdentity("trigger2", TRIGGER_GROUP_NAME)
//                        .withSchedule(scheduleBuilder).build();
//                scheduler.scheduleJob(jobDetail2, trigger2);
//                System.out.println("Quartz 创建了job:...:{}" + jobDetail2.getKey());
//            } else {
//                System.out.println("job已存在:{}" + trigger2.getKey());
//            }
//            scheduler.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
