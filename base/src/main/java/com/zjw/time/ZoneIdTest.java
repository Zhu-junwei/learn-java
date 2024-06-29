package com.zjw.time;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Set;

/**
 * 时区
 *
 * @author 朱俊伟
 * @since 2024/06/29 18:00
 */
public class ZoneIdTest {

    /**
     * 获取所有时区
     */
    @Test
    public void Test() {
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        availableZoneIds.forEach(System.out::println);
    }

    /**
     * toOtherTime
     */
    @Test
    public void ToOtherTimeTest() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(ZoneId.systemDefault() + " " + now);
        System.out.println("America/New_York " + LocalDateTime.now(ZoneId.of("America/New_York")));
        System.out.println("Europe/London " + LocalDateTime.now(ZoneId.of("Europe/London")));
    }
}
