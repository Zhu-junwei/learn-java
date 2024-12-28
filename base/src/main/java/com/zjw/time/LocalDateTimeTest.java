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


}
