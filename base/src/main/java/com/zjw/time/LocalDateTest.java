package com.zjw.time;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * LocalDate 没有时区信息
 *
 * @author 朱俊伟
 * @since 2022/07/26
 */
public class LocalDateTest {

    @Test
    public void testLengthOfYear() {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        // 获取今年的天数
        int lengthOfYear = LocalDate.now().lengthOfYear();
        System.out.println(lengthOfYear);
        // 获取指定某年的天数
        int lengthOfYear1 = LocalDate.of(2025, Month.JANUARY, 1).lengthOfYear();
        System.out.println(lengthOfYear1);
    }

    /**
     * plus加上指定的时间
     */
    @Test
    public void plusTest() {
        // 加1天
        LocalDate localDate = LocalDate.now().plusDays(1);
        System.out.println(localDate);
        // 加1周
        LocalDate localDate1 = LocalDate.now().plusWeeks(1);
        System.out.println(localDate1);
        // 加1月
        /*
            返回此副本 LocalDate ，并添加指定的月数。
            此方法分三个步骤将指定的金额添加到月字段：
             - 将输入月份添加到年月字段
             - 检查生成的日期是否无效
             - 如有必要，将月份中的某一天调整为最后有效日
            例如，2007-03-31 加一个月将导致日期 2007-04-31 无效。选择当月的最后一个有效日期 2007-04-30 不是返回无效结果
         */
        LocalDate localDate2 = LocalDate.now().plusMonths(1);
        System.out.println(localDate2);
        // 加1年
        LocalDate localDate3 = LocalDate.now().plusYears(1);
        System.out.println(localDate3);
        System.out.println(LocalDate.of(2023, 5, 1).plus(Period.ofYears(1)));
    }

    /**
     * betweenDays
     */
    @Test
    public void betweenDaysTest() {
        LocalDate start = LocalDate.of(2000, 1, 1);
        LocalDate now = LocalDate.now();
        long daysBetween = ChronoUnit.DAYS.between(start, now);
        long daysBetween2 = start.until(now, ChronoUnit.DAYS);
        System.out.println("Days between: " + daysBetween);
        System.out.println("Days between: " + daysBetween2);
        long monthsBetween = ChronoUnit.MONTHS.between(start, now);
        System.out.println("Months between: " + monthsBetween);
        long yearsBetween = ChronoUnit.YEARS.between(start, now);
        System.out.println("Years between: " + yearsBetween);
    }

}
