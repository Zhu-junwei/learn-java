package com.zjw.time;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 朱俊伟
 * @date 2021/11/05
 */
public class TimeTest {
    public static void main(String[] args) {

    }

    /*
     * 将时间转换为时间戳
     */
    public static String dateToStamp(String time){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String stamp = "";
        if (!"".equals(time)) {//时间不为空
            try {
                stamp = String.valueOf(sdf.parse(time).getTime()/1000);
            } catch (Exception e) {
                System.out.println("参数为空！");
            }
        }else {    //时间为空
            long current_time = System.currentTimeMillis();  //获取当前时间
            stamp = String.valueOf(current_time/1000);
        }
        return stamp;
    }


    /*
     * 将时间戳转换为时间
     */
    public static String stampToDate(int time){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time_Date = sdf.format(new Date(time * 1000L));
        return time_Date;

    }
}
