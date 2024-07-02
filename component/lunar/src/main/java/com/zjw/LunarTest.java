package com.zjw;

import com.nlf.calendar.Lunar;
import org.junit.jupiter.api.Test;

/**
 * 测试lunar用法
 *
 * @author 朱俊伟
 * @date 2024/07/01
 */
public class LunarTest {

    /**
     * 获取指定日期的阴历
     */
    @Test
    public void lunarTest() {
        //指定阴历的某一天
        Lunar date = new Lunar(1986,4,21);
        System.out.println(date.toFullString());
        System.out.println(date.getSolar().toFullString());
    }

    /**
     * 获取今天的阴历
     */
    @Test
    public void todayLunarTest() {
        Lunar todayLunar = new Lunar();
        System.out.println(todayLunar.toFullString());
        System.out.println(todayLunar.getSolar().toFullString());
    }
}
