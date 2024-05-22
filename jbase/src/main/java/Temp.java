import com.cronutils.model.Cron;
import com.cronutils.model.CronType;
import com.cronutils.model.definition.CronDefinition;
import com.cronutils.model.definition.CronDefinitionBuilder;
import com.cronutils.model.time.ExecutionTime;
import com.cronutils.parser.CronParser;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;

public class Temp {
    public static void main(String[] args) {
        System.out.println(LocalDate.now().toString());
//        BigDecimal m = new BigDecimal("0.146").multiply(new BigDecimal("0")).subtract(new BigDecimal("3.517"));
////        if (true) {
////            m = m.add(new BigDecimal("0.603"));
////        }
//        System.out.println(m.toString());
//        double exp = Math.exp(m.doubleValue());
//        System.out.println(exp / (1 + exp));
//        BigDecimal divide = new BigDecimal("0.07").divide(new BigDecimal("0.04"), 4, RoundingMode.HALF_UP).multiply(new BigDecimal("100"));
//        System.out.println(String.format("%.2f%%",divide));
//
//        PatData patData = new PatData();
//        patData.setName("Tom");
//        System.out.println(ReflectUtil.getFieldValue(patData, "name"));

        String cronStr="0 30 17 * * ? ";
        CronDefinition cronDefinition = CronDefinitionBuilder.instanceDefinitionFor(CronType.QUARTZ);
        CronParser parser = new CronParser(cronDefinition);
        Cron cron = parser.parse(cronStr);
        cron.validate();

        ZonedDateTime now = ZonedDateTime.of(LocalDateTime.of(LocalDate.now(), LocalTime.of(17,31,0)), ZoneId.systemDefault());
        ExecutionTime executionTime = ExecutionTime.forCron(cron);
        Optional<ZonedDateTime> nextExecution = executionTime.nextExecution(now);
        Optional<ZonedDateTime> lastExecution = executionTime.lastExecution(now);
        if (nextExecution.isPresent()) {
            System.out.println("Next execution time: " + nextExecution.get());
            System.out.println("last execution time: " + lastExecution.get());
            System.out.println("now  execution time: " + now);
            System.out.println(now.isAfter(lastExecution.get()) && now.isBefore(nextExecution.get()));
            System.out.println(now.isEqual(lastExecution.get()));
            System.out.println(now.isEqual(nextExecution.get()));
            System.out.println(executionTime.isMatch(now));
        } else {
            System.out.println("No next execution time found.");
        }
    }
}
