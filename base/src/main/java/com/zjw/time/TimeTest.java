package com.zjw.time;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 朱俊伟
 * @date 2021/11/05
 */
public class TimeTest {
    public static void main(String[] args) throws InterruptedException {
        getTime();
        Thread.sleep(10);
        getTime();
        Thread.sleep(10);
        getTime();
        Thread.sleep(10);
        getTime();
    }

    public static void getTime(){
        System.out.println(System.currentTimeMillis());
    }

    /**
     * 将时间转换为时间戳
     */
    public static String dateToStamp(String time){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String stamp = "";
        //时间不为空
        if (!"".equals(time)) {
            try {
                stamp = String.valueOf(sdf.parse(time).getTime()/1000);
            } catch (Exception e) {
                System.out.println("参数为空！");
            }
            //时间为空
        }else {
            //获取当前时间
            long currentTime = System.currentTimeMillis();
            stamp = String.valueOf(currentTime/1000);
        }
        return stamp;
    }


    /**
     * 将时间戳转换为时间
     */
    public static String stampToDate(int time){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeDate = sdf.format(new Date(time * 1000L));
        return timeDate;

    }

    /**
     * public boolean after(Date when)
     * 判断一个日期是否在另一个日期后面
     * @throws ParseException
     */
    @Test
    public void testDateAfter() throws ParseException {
        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse("2022-02-03");
        Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse("2022-02-04");
        //false
        System.out.println(date1.after(date2));
        //true
        System.out.println(date2.after(date1));
        //false
        System.out.println(date1.after(date1));
    }


}
