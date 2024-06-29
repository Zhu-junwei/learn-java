package com.zjw.time;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

/**
 * @author 朱俊伟
 * @since 2024/06/29 17:18
 */
public class LocalTimeTest {

    /**
     * now
     */
    @Test
    public void nowTest() {
        // 17:19:12.209005200
        LocalTime now = LocalTime.now();
        System.out.println(now);
        System.out.println(now.getHour());
        System.out.println(now.getMinute());
        System.out.println(now.getSecond());
        System.out.println(now.getNano());
        System.out.println("************");
        // 今天已过的时间
        System.out.println(now.toSecondOfDay());
        System.out.println(now.toNanoOfDay());

        // 自己定义时间 10:30
        LocalTime localTime = LocalTime.of(10, 30);
        System.out.println(localTime);

    }

    /**
     * plus
     */
    @Test
    public void plusTest() {
        LocalTime now = LocalTime.now();
        System.out.println(now.plusHours(1));
    }

    /**
     * before,after
     */
    @Test
    public void beforeAfterTest() {
        LocalTime now = LocalTime.now();
        System.out.println(now.isBefore(LocalTime.of(10, 30)));
        System.out.println(now.isAfter(LocalTime.of(10, 30)));
    }
}
