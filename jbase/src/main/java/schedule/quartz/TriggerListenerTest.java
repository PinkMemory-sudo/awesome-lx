package schedule.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.TriggerListener;

@Slf4j
public class TriggerListenerTest implements TriggerListener {
    @Override
    public String getName() {
        return "TriggerListenerTest";
    }

    @Override
    public void triggerFired(Trigger trigger, JobExecutionContext context) {

    }

    @Override
    public boolean vetoJobExecution(Trigger trigger, JobExecutionContext context) {
        return false;
    }

    @Override
    public void triggerMisfired(Trigger trigger) {

    }

    @Override
    public void triggerComplete(Trigger trigger, JobExecutionContext context, Trigger.CompletedExecutionInstruction triggerInstructionCode) {
        String name = trigger.getJobKey().getName();
        String codeName = triggerInstructionCode.name();
        log.info("triggerComplete，name:{}, codeName:{}", name, codeName);
    }
}
