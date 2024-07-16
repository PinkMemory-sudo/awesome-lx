package com.example.springdemo.demos.web.quartz.cluster;

import org.quartz.JobBuilder;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.TriggerBuilder;
import org.quartz.Trigger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;
import org.quartz.JobDetail;

@Configuration
public class QuartzConfig implements CommandLineRunner {

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setJobFactory(new SpringBeanJobFactory());
        return factory;
    }

    @Bean
    public JobDetail myJobDetail() {
        return JobBuilder.newJob(MyJob.class)
                .withIdentity("myJob")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger myJobTrigger1() {
        return TriggerBuilder.newTrigger()
                .forJob(myJobDetail())
                .withIdentity("myJobTrigger1")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(2)
                        .repeatForever())
                .build();
    }

    @Bean
    public Trigger myJobTrigger2() {
        return TriggerBuilder.newTrigger()
                .forJob(myJobDetail())
                .withIdentity("myJobTrigger2")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(4)
                        .repeatForever())
                .build();
    }

    @Override
    public void run(String... args) throws Exception {
        schedulerFactoryBean().getScheduler().scheduleJob(myJobDetail(), myJobTrigger1());
    }
}

