package com.zjw.time;

import java.time.LocalDate;

/**
 * @author 朱俊伟
 * @since 2022/07/26
 */
public class LocalDateTest {
    public static void main(String[] args) {
        int lengthOfYear = LocalDate.now().lengthOfYear();
        System.out.println(lengthOfYear);
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

    }
}
