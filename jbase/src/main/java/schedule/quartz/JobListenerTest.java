package schedule.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

@Slf4j
public class JobListenerTest implements JobListener {
    @Override
    public String getName() {
        return "JobListenerTest";
    }

    @Override
    public void jobToBeExecuted(JobExecutionContext context) {
        log.info("{} will start",context.getJobDetail().getKey().getName());
    }

    @Override
    public void jobExecutionVetoed(JobExecutionContext context) {

    }

    @Override
    public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {

    }
}
