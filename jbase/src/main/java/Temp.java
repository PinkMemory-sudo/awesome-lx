import cn.hutool.core.date.DateUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;

public class Temp {
    public static void main(String[] args) {
        long seconds = Duration.between(DateUtil.parseLocalDateTime("2024-07-17 22:25:00"),
                DateUtil.parseLocalDateTime("2024-07-17 22:25:20")).getSeconds();
        System.out.println(new BigDecimal("2").multiply(BigDecimal.valueOf(seconds))
                .divide(BigDecimal.valueOf(60), 2, RoundingMode.HALF_UP));

    }
}
