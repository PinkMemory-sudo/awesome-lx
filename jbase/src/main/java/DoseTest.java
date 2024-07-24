import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class TimeSegment {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private BigDecimal rate;
    private String type;

    public TimeSegment(LocalDateTime startTime, LocalDateTime endTime, BigDecimal rate, String type) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.rate = rate;
        this.type = type;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public String getType() {
        return type;
    }
}

public class DoseTest {
    public static void main(String[] args) {
        // 示例输入
        List<TimeSegment> segments = new ArrayList<>();
        segments.add(new TimeSegment(LocalDateTime.of(2024, 7, 1, 0, 0), LocalDateTime.of(2024, 7, 1, 6, 0), new BigDecimal("0.5"), "A"));
        segments.add(new TimeSegment(LocalDateTime.of(2024, 7, 1, 6, 0), LocalDateTime.of(2024, 7, 1, 12, 0), new BigDecimal("1.0"), "B"));
        segments.add(new TimeSegment(LocalDateTime.of(2024, 7, 1, 12, 0), LocalDateTime.of(2024, 7, 1, 18, 0), new BigDecimal("0.75"), "A"));
        segments.add(new TimeSegment(LocalDateTime.of(2024, 7, 1, 18, 0), LocalDateTime.of(2024, 7, 2, 0, 0), new BigDecimal("1.25"), "B"));

        LocalDateTime startTime = LocalDateTime.of(2024, 7, 1, 0, 0);
        LocalDateTime endTime = LocalDateTime.of(2024, 7, 2, 0, 0);
        int hoursPerGroup = 6;

        Map<String, Map<Integer, BigDecimal>> groupedExecution = calculateGroupedExecution(segments, startTime, endTime, hoursPerGroup);

        groupedExecution.forEach((type, map) -> {
            System.out.println("Type " + type + ":");
            map.forEach((group, execution) -> {
                System.out.println("  Group " + group + ": " + execution + " ml");
            });
        });
    }

    public static Map<String, Map<Integer, BigDecimal>> calculateGroupedExecution(List<TimeSegment> segments, LocalDateTime startTime, LocalDateTime endTime, int hoursPerGroup) {
        Map<String, Map<Integer, BigDecimal>> groupedExecution = new TreeMap<>();

        for (TimeSegment segment : segments) {
            LocalDateTime segmentStart = segment.getStartTime().isBefore(startTime) ? startTime : segment.getStartTime();
            LocalDateTime segmentEnd = segment.getEndTime().isAfter(endTime) ? endTime : segment.getEndTime();
            BigDecimal rate = segment.getRate();
            String type = segment.getType();

            // If the segment is outside the specified time range, skip it
            if (segmentStart.isAfter(endTime) || segmentEnd.isBefore(startTime)) {
                continue;
            }

            while (segmentStart.isBefore(segmentEnd)) {
                LocalDateTime nextGroupEnd = segmentStart.plusHours(hoursPerGroup).truncatedTo(ChronoUnit.HOURS);
                if (nextGroupEnd.isAfter(endTime)) {
                    nextGroupEnd = endTime;
                }
                LocalDateTime effectiveEnd = segmentEnd.isBefore(nextGroupEnd) ? segmentEnd : nextGroupEnd;
                long seconds = Duration.between(segmentStart, effectiveEnd).getSeconds();
                BigDecimal execution = rate.multiply(BigDecimal.valueOf(seconds)).divide(BigDecimal.valueOf(60), 2, RoundingMode.HALF_UP);

                int group = (int) Duration.between(startTime, segmentStart).toHours() / hoursPerGroup;

                groupedExecution.computeIfAbsent(type, k -> new TreeMap<>())
                        .merge(group, execution, BigDecimal::add);

                segmentStart = effectiveEnd;
            }
        }

        return groupedExecution;
    }
}
