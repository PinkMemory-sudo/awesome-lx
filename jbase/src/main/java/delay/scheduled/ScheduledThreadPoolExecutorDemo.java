package delay.scheduled;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ScheduledThreadPoolExecutorDemo {

//    public static void main(String[] args) {
//        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(2, new ThreadPoolExecutor.CallerRunsPolicy());
//
//        log.info("提交延迟任务");
//        executor.schedule(() -> log.info("执行延迟任务"), 5, TimeUnit.SECONDS);
//    }


        public static void main(String[] args) {
            long iterations = 0;
            long startTime = System.nanoTime();
            long endTime = startTime + 1_000_000; // 1 毫秒 = 1,000,000 纳秒

            while (System.nanoTime() < endTime) {
                iterations++;
            }

            System.out.println("Iterations in 1 millisecond: " + iterations);
    }

}