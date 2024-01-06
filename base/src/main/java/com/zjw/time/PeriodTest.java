package com.zjw.time;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

/**
 * @author zjw
 * @since 2023/06/30 17:40
 */
public class PeriodTest {
    @Test
    public void getMonths() {
        // 创建两个 LocalDate 对象表示日期
        LocalDate date1 = LocalDate.of(2022, Month.JANUARY, 1);
        LocalDate date2 = LocalDate.of(2023, Month.MARCH, 15);

        // 计算两个日期之间的月份差值
        Period period = Period.between(date1, date2);

        // 获取月份差值
        int monthDiff = period.getMonths();

        System.out.println("相差的月份: " + monthDiff);
    }
}
