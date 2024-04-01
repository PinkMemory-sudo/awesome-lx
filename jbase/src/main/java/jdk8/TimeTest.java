package jdk8;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TimeTest {
    public static void main(String[] args) {
//        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.of(12, 0));
//        System.out.println(DateUtil.formatLocalDateTime(localDateTime));

//        for (int i = 1; i < 13; i++) {
//            System.out.print(i+"-");
//            System.out.println((LocalDate.of(2021, i, 1).getMonthValue() - 1) / 3 + 1);
//        }
//        System.out.println(getScaleData(LocalDateTime.of(LocalDate.of(2013, 1, 1), LocalTime.now()),
//                LocalDateTime.of(LocalDate.of(2022, 12, 31), LocalTime.now()),
//                TimeScale.YEAR
//        ));

        System.out.printf("%.2f%%", new BigDecimal("0")
                .divide(new BigDecimal("21"), 4, RoundingMode.HALF_UP)
                .multiply(new BigDecimal("100")).doubleValue());

    }

    private static List<String> getScaleData(LocalDateTime startTime, LocalDateTime stopTime, TimeScale timeScale) {
        List<String> scaleList = new ArrayList<>();
        while (startTime.isBefore(stopTime)) {
            if (timeScale == TimeScale.YEAR) {
                scaleList.add(startTime.format(DateTimeFormatter.ofPattern("yyyy")));
                startTime = startTime.plusYears(1L);
            } else if (timeScale == TimeScale.MONTH) {
                scaleList.add(startTime.format(DateTimeFormatter.ofPattern("MM")));
                startTime = startTime.plusMonths(1L);
            } else if (timeScale == TimeScale.QUARTER) {
                scaleList.add(String.valueOf((startTime.getMonthValue() - 1) / 3 + 1));
                startTime = startTime.plusMonths(3L);
            }
        }
        return scaleList;
    }

    enum TimeScale {
        YEAR,
        QUARTER,
        MONTH,
        WEEK,
        CUSTOM // 自定义时间尺度，需要传入起始日期和结束日期
    }
}
