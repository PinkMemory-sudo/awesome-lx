import java.util.stream.IntStream;

public class Temp {
    public static void main(String[] args) {

//        String cronStr = "0 30 17 * * ? ";
//        CronDefinition cronDefinition = CronDefinitionBuilder.instanceDefinitionFor(CronType.QUARTZ);
//        CronParser parser = new CronParser(cronDefinition);
//        Cron cron = parser.parse(cronStr);
//        cron.validate();
//
//        ZonedDateTime now = ZonedDateTime.of(LocalDateTime.of(LocalDate.now(), LocalTime.of(17, 31, 0)), ZoneId.systemDefault());
//        ExecutionTime executionTime = ExecutionTime.forCron(cron);
//        Optional<ZonedDateTime> nextExecution = executionTime.nextExecution(now);
//        Optional<ZonedDateTime> lastExecution = executionTime.lastExecution(now);
//        if (nextExecution.isPresent()) {
//            System.out.println("Next execution time: " + nextExecution.get());
//            System.out.println("last execution time: " + lastExecution.get());
//            System.out.println("now  execution time: " + now);
//            System.out.println(now.isAfter(lastExecution.get()) && now.isBefore(nextExecution.get()));
//            System.out.println(now.isEqual(lastExecution.get()));
//            System.out.println(now.isEqual(nextExecution.get()));
//            System.out.println(executionTime.isMatch(now));
//        } else {
//            System.out.println("No next execution time found.");
//        }
//        System.out.println("2024-06-17 11:06:04.000".substring(0, 19));
    }
}
