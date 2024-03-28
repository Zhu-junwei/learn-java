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
        String formattedDate = now.format(formatter);
        System.out.println("formattedDate = " + formattedDate);
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
