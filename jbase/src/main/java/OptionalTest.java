import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Slf4j
public class OptionalTest {

    @Data
    static class Person {
        private String name;
        private int age;
        private House house;

    }

    @Data
    static class House {
        private long price;
        private Address address;
    }

    @Data
    static class Address {
        private String country;
        private String city;
    }

    public static void main(String[] args) {

        test(14);
    }

    private static void test(int times) {
        String[] base = {"2", "3", "5", "8"};
        BigDecimal sum = new BigDecimal("20");
        BigDecimal surplus = new BigDecimal("19.2");
        BigDecimal loss;
        if (times > 2) {
            for (int i = 2; i < times; i++) {
                int index = (i - 2) % 4;
                BigDecimal currentBase = new BigDecimal(base[index]);
                int pow = (i - 2) / 4 + 1;
                double capital = Math.pow(10, pow);
                BigDecimal currentInput = currentBase.multiply(new BigDecimal(capital));
                sum = sum.add(currentInput);
                surplus = surplus.multiply(new BigDecimal("0.92")).add(currentInput);
                loss = sum.subtract(surplus);
                log.info("{},{},{}", sum, loss, surplus);
                System.out.println(loss.divide(sum, RoundingMode.HALF_UP));
            }
        }
    }


}
