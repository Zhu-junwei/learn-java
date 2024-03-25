package com.zjw.time;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author 朱俊伟
 * @since 2024/03/24 20:43
 */
public class DateTimeFormatterTest {

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
}
