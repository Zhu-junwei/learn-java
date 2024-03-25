package com.zjw.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @author 朱俊伟
 * @since 2021/03/25
 */
public class DateTest {
    public static void main(String[] args) {
        Date from = Date.from(Instant.now());
        System.out.println("from = " + from);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
        System.out.println(sdf.format(new Date()));
        //获取当前时间戳,也可以是你自己给的一个随机的或是别人给你的时间戳(一定是long型的数据)
        long timeStamp = System.currentTimeMillis();
        //这个是你要转成后的时间的格式
        SimpleDateFormat sdff=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
        // 时间戳转换成时间
        String sd = sdff.format(new Date(timeStamp));
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTimeInMillis());

        System.out.println(sd);//打印出你要的时间
        System.out.println(TimeZone.getDefault());
        System.out.println(Locale.getDefault(Locale.Category.FORMAT));
        
    }

    /*
     * 将时间转换为时间戳
     */
    public static String dateToStamp(String s) throws ParseException {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        res = String.valueOf(ts);
        return res;
    }

    /*
     * 将时间戳转换为时间
     */
    public static String stampToDate(String s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = Long.parseLong(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }
}
