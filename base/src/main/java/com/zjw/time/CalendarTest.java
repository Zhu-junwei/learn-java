package com.zjw.time;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author zjw
 * @since 2023/05/19 14:15
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

    @Test
    public void testCalendar2(){
        //Calendar类不能通过new来实例化对象
        Calendar calendar = Calendar.getInstance();
//		System.out.println(calendar);

        Date date = new Date();
        System.out.println(date);
        //本地化显示
        System.out.println(date.toLocaleString());
        //距离1970-1-1 00:00:00经历了多少毫秒
        System.out.println(date.getTime());
        System.out.println(System.currentTimeMillis());

        //查看日期和时间
        Date nowDate = calendar.getTime();
        System.out.println(nowDate.toLocaleString());
        //日期格式化
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = sdf.format(nowDate);
        System.out.println(str);
        System.out.println("*********************");
        //获取某个字段
        int year = calendar.get(Calendar.YEAR);//年
        System.out.println("年:"+year);
        int month = calendar.get(Calendar.MONTH)+1;//月
        System.out.println("月:"+month);
        int day = calendar.get(Calendar.DATE);//日
        System.out.println("日:"+day);
        int hour1 = calendar.get(Calendar.HOUR_OF_DAY);//24时
        int hour2 = calendar.get(Calendar.HOUR);//12时
        System.out.println("24时:"+hour1);
        System.out.println("12时:"+hour2);
        int minute = calendar.get(Calendar.MINUTE);//分
        System.out.println("分:"+minute);
        int second = calendar.get(Calendar.SECOND);//秒
        System.out.println("秒:"+second);
        int millisecond = calendar.get(Calendar.MILLISECOND);//毫秒
        System.out.println("毫秒"+millisecond);
        int day_of_week = calendar.get(Calendar.DAY_OF_WEEK);//一周中的第几天
        System.out.println("一周中的第几天:" + day_of_week);
        /* 今天是这一年的第几天 */
        int day_of_year = calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println("今天是这一年的第几天:" + day_of_year);
        /* 今天是这一年的第几周 */
        int week_of_year = calendar.get(Calendar.WEEK_OF_YEAR);
        System.out.println("今天是这一年的第几周:" + week_of_year);

        calendar.add(Calendar.DATE, 100);//日期增加100天
        System.out.println("日期增加100天后的日期:"+calendar.getTime().toLocaleString());
    }
}
