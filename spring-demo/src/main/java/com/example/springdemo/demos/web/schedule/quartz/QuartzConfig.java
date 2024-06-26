//package com.example.springdemo.demos.web.schedule.quartz;
//
//
//import org.quartz.JobDetail;
//import org.quartz.Trigger;
//import org.springframework.context.annotation.Bean;
//
//import java.time.Instant;
//import java.time.LocalDateTime;
//import java.time.ZoneId;
//import java.util.Date;
//
//import static org.quartz.CronScheduleBuilder.cronSchedule;
//import static org.quartz.JobBuilder.newJob;
//import static org.quartz.SimpleScheduleBuilder.repeatSecondlyForTotalCount;
//import static org.quartz.TriggerBuilder.newTrigger;
//
////@Configuration
//public class QuartzConfig {
//
//    @Bean
//    public JobDetail myJobDetail() {
//        return newJob(MyJob.class)
//                .withIdentity("myJob")
//                .storeDurably()
//                .build();
//    }
//
//    @Bean
//    public Trigger myTrigger() {
//        return newTrigger()
//                .startAt(Date.from(Instant.now().plusSeconds(10)))
//                .endAt(Date.from(LocalDateTime.now().plusHours(10).atZone(ZoneId.systemDefault()).toInstant()))
//                .forJob(myJobDetail())
//                .withIdentity("myTrigger")
//                .withSchedule(cronSchedule("0/10 * * * * ?")) // 每隔5秒执行一次
//                .build();
//    }
//
//    @Bean
//    public Trigger simpleTrigger() {
//        return newTrigger()
//                .forJob(myJobDetail())
//                .withIdentity("simpleTrigger")
//                .withSchedule(repeatSecondlyForTotalCount(6)) // 每隔5秒执行一次
//                .build();
//    }
//
//    @Bean
//    public Trigger calendarTrigger() {
//        return newTrigger()
//                .forJob(myJobDetail())
//                .withIdentity("simpleTrigger")
//                .withSchedule(repeatSecondlyForTotalCount(6)) // 每隔5秒执行一次
//                .build();
//    }
//
//    @Bean
//    public Trigger dailyTrigger() {
//        return newTrigger()
//                .forJob(myJobDetail())
//                .withIdentity("simpleTrigger")
//                .withSchedule(repeatSecondlyForTotalCount(6)) // 每隔5秒执行一次
//                .build();
//    }
//
////    @Bean
////    public Scheduler scheduler(JobDetail myJobDetail, Trigger myTrigger, Trigger simpleTrigger) throws SchedulerException {
////        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
////        scheduler.scheduleJob(myJobDetail, myTrigger);
////        scheduler.scheduleJob(simpleTrigger);
////        scheduler.start();
////        return scheduler;
////    }
//}
