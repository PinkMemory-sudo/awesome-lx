package schedule.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

@Slf4j
public class QuartzTest {
    public static void main(String[] args) throws SchedulerException, InterruptedException {
        SchedulerFactory schedFact = new StdSchedulerFactory();

        Scheduler sched = schedFact.getScheduler();

        sched.start();

        // define the job and tie it to our HelloJob class
        JobDetail job = newJob(HelloJob.class)
                .withIdentity("myJob", "group1")
                .usingJobData("name", "pk")
                .build();

        // Trigger the job to run now, and then every 40 seconds
        Trigger trigger = newTrigger()
                .withIdentity("myTrigger", "group1")
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(4)
                        .repeatForever())
                .build();

        // Tell quartz to schedule the job using our trigger
        sched.scheduleJob(job, trigger);
        sched.getListenerManager().addTriggerListener(new TriggerListenerTest());
        sched.getListenerManager().addJobListener(new JobListenerTest());
        sched.getListenerManager().addSchedulerListener(new SchedulerListenerTest());
    }

}
