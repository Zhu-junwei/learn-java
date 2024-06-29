package com.zjw.time;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;

/**
 * Instant测试，Instant表示时间线上的某个点
 *
 * @author 朱俊伟
 * @since 2024/06/29 15:34
 */
public class InstantTest {

    /**
     * now
     */
    @Test
    @SneakyThrows
    public void nowTest() {
        // 获取当前时刻
        Instant now = Instant.now();
        System.out.println(now); //2024-06-29T07:35:09.673647900Z
        Thread.sleep(1000);
        Instant end = Instant.now();

        // 获取两个时间点之间的时间差
        Duration duration = Duration.between(now, end);
        // 相差的时间
        System.out.println(duration.toDays());
        System.out.println(duration.toHours());
        System.out.println(duration.toMinutes());
        // 相差的毫秒数
        long millis = duration.toMillis();
        System.out.println(millis);
        // 相差的纳秒数
        long nanos = duration.toNanos();
        System.out.println(nanos);
        // 相差的秒数
        long seconds = duration.getSeconds();
        System.out.println(seconds);
    }

    /**
     * min max 最小最大的时间范围
     */
    @Test
    public void minMaxTest() {
        Instant min = Instant.MIN;
        System.out.println(min);
        Instant max = Instant.MAX;
        System.out.println(max);
    }

    /**
     * days
     */
    @Test
    public void daysTest() {
    }

}
