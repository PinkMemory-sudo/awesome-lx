package re;

import cn.hutool.core.date.DateUtil;

import java.time.LocalDate;

public class B extends P{
    @Override
    void test() {
        System.out.println("b");
    }

    public static void main(String[] args) {
        System.out.println(DateUtil.formatLocalDateTime(LocalDate.now().atStartOfDay()));
    }
}
