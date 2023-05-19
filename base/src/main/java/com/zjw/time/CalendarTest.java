package com.zjw.time;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * @author zjw
 * @date 2023/05/19 14:15
 */
public class CalendarTest {

    @Test
    public void testCalendar(){
        //初始化对象
        Calendar calendar = Calendar.getInstance();
        //打印基本信息
        System.out.println(calendar);
        //打印时间信息
        System.out.println(calendar.getTime());
        //设置时间
        calendar.setTime(new Date(System.currentTimeMillis()-1000000000));
        System.out.println(calendar.getTime());
        //减去20天
        calendar.add(Calendar.DAY_OF_YEAR, -20);
        System.out.println(calendar.getTime());
    }
}
