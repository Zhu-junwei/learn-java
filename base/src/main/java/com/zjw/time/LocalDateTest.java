package com.zjw.time;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

/**
 * @author 朱俊伟
 * @since 2022/07/26
 */
public class LocalDateTest {

    @Test
    public void testLengthOfYear() {
        // 获取今年的天数
        int lengthOfYear = LocalDate.now().lengthOfYear();
        System.out.println(lengthOfYear);
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        // 获取指定某年的天数
        int lengthOfYear1 = LocalDate.of(2022, Month.JANUARY, 1).lengthOfYear();
        System.out.println(lengthOfYear1);

    }
}
