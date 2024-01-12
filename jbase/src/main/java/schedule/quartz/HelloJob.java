package schedule.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;

@Slf4j
@PersistJobDataAfterExecution
public class HelloJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDetail jobDetail = context.getJobDetail();
        JobKey key = jobDetail.getKey();
        JobDataMap jobDataMap = jobDetail.getJobDataMap();
        String name = jobDataMap.getString("name");
        jobDataMap.put("name",name+"*");
        log.info("hello, name:{}, key:{}", name, key.getName());
    }
}
