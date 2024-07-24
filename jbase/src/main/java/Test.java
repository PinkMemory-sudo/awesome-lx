import java.math.BigDecimal;
import java.math.RoundingMode;

public class Test {
    public static void main(String[] args) {
        BigDecimal rate = new BigDecimal("4")
                .divide(BigDecimal.valueOf(60), 10, RoundingMode.HALF_UP);
        System.out.println(rate);
        BigDecimal duration = new BigDecimal("1")
                .divide(  rate , 0, RoundingMode.CEILING);
        System.out.println(duration);
    }
}
