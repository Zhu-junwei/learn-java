package com.zjw.time;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * @author 朱俊伟
 * @since 2024/03/24 20:43
 */
public class LocalDateTimeTest {

    /**
     * 测试日期格式化
     */
    @Test
    public void LocalDateTimeFormatTest() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("now = " + now); // 2024-12-04T09:47:48.997058900
        String formattedDate = now.format(formatter);
        System.out.println("formattedDate = " + formattedDate); // 2024-12-04 09:47:48

    }

    /**
     * 测试日期解析
     */
    @Test
    public void LocalDateTimeParseTest() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = "2024-03-24 20:43:20";
        LocalDateTime dateTime = LocalDateTime.parse(formattedDate, formatter);
        System.out.println("dateTime = " + dateTime);
    }

    /**
     * 时间戳转日期
     */
    @Test
    public void TimestampToDateTest() {
        // 给定的时间戳 秒
        long timestamp = 1718474125L;
        // 将时间戳转换为Instant对象
        Instant instant = Instant.ofEpochSecond(timestamp);

        // 将Instant对象转换为本地日期时间对象
        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        LocalDateTime dateTime2 = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
        // 定义日期时间格式化器
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // 格式化并打印日期时间
        String formattedDate = dateTime.format(formatter);
        System.out.println("Formatted Date: " + formattedDate);
        System.out.println("Formatted Date: " + dateTime2.format(formatter));
    }

    /**
     * utc时间转为北京时间
     */
    @Test
    public void utcToBjTime(){
        String utcTime = "2019-07-31T16:00:00.000Z";

        // 解析世界标准时间
        Instant instant = Instant.parse(utcTime);

        // 转换为北京时间
        ZoneId beijingZoneId = ZoneId.of("Asia/Shanghai");
        LocalDateTime beijingTime = LocalDateTime.ofInstant(instant, beijingZoneId);
        System.out.println(beijingTime);

        // 格式化输出
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedBeijingTime = beijingTime.format(formatter);

        System.out.println("北京时间: " + formattedBeijingTime);
    }

    /**
     * plusXXX 增加时间
     */
    @Test
    public void plusTest() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = "2025-04-16 01:34:00";
        LocalDateTime beforeDateTime = LocalDateTime.parse(formattedDate, formatter);
        System.out.println("before:" + beforeDateTime.format(formatter));
        // 增加60s，即一分钟，生成新的LocalDateTime对象，原来的对象不会改变
        LocalDateTime plusSecondsDateTime = beforeDateTime.plusSeconds(60L);
        System.out.println("after plusSeconds :" + plusSecondsDateTime.format(formatter)); // 2025-04-16 01:35:00
        // 增加两分钟，生成新的LocalDateTime对象
        LocalDateTime plusMinutesDateTime = beforeDateTime.plusMinutes(2L);
        System.out.println("after plusMinutes :" + plusMinutesDateTime.format(formatter)); // 2025-04-16 01:36:00
        // 增加3天
        LocalDateTime plusDaysDateTime = beforeDateTime.plusDays(3L);
        System.out.println("after plusDays :" + plusDaysDateTime.format(formatter)); // 2025-04-19 01:34:00
        // 增加4个月
        LocalDateTime plusMonthsDateTime = beforeDateTime.plusMonths(4L);
        System.out.println("after plusMonths :" + plusMonthsDateTime.format(formatter)); // 2025-08-16 01:34:00
        // 增加1年
        LocalDateTime plusYearsDateTime = beforeDateTime.plusYears(1L);
        System.out.println("after plusYears :" + plusYearsDateTime.format(formatter)); // 2026-04-16 01:34:00
    }


}
