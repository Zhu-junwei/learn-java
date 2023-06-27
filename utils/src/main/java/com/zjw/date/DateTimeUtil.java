package com.zjw.date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间日期转换工具类
 */
public class DateTimeUtil {

    /**
     * 将时间戳转换为指定格式的日期时间字符串
     * @param timestamp 时间戳（单位：毫秒）
     * @param pattern 日期时间格式，例如："yyyy-MM-dd HH:mm:ss.SSS"
     * @return 日期时间字符串
     */
    public static String timestampToDateTime(long timestamp, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date = new Date(timestamp);
        return sdf.format(date);
    }

    /**
     * 将时间戳转换为默认格式（"yyyy-MM-dd HH:mm:ss.SSS"）的日期时间字符串
     * @param timestamp 时间戳（单位：毫秒）
     * @return 日期时间字符串
     */
    public static String timestampToDateTime(long timestamp) {
        return timestampToDateTime(timestamp, "yyyy-MM-dd HH:mm:ss.SSS");
    }

    /**
     * 返回格式（"yyyy-MM-dd HH:mm:ss.SSS"）当前的日期时间
     * @return 前的日期时间
     */
    public static String currentDateTime() {
        return timestampToDateTime(System.currentTimeMillis());
    }

    /**
     * 将时间戳转换为默认格式（"yyyy-MM-dd"）的日期字符串
     * @param timestamp 时间戳（单位：毫秒）
     * @return 日期字符串
     */
    public static String timestampToDate(long timestamp) {
        return timestampToDateTime(timestamp, "yyyy-MM-dd");
    }

    /**
     * 返回格式（"yyyy-MM-dd"）的当前日期字符串
     * @return 日期字符串
     */
    public static String currentDate(){
        return timestampToDate(System.currentTimeMillis());
    }

    /**
     * 将时间戳转换为默认格式（"HH:mm:ss"）的时间字符串
     * @param timestamp 时间戳（单位：毫秒）
     * @return 时间字符串
     */
    public static String timestampToTime(long timestamp) {
        return timestampToDateTime(timestamp, "HH:mm:ss");
    }

    /**
     * 将日期时间字符串转换为时间戳
     * @param dateTimeStr 日期时间字符串
     * @param pattern 日期时间格式，例如："yyyy-MM-dd HH:mm:ss.SSS"
     * @return 时间戳（单位：毫秒）
     */
    public static long dateTimeToTimestamp(String dateTimeStr, String pattern) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date = sdf.parse(dateTimeStr);
        return date.getTime();
    }

    /**
     * 将默认格式（"yyyy-MM-dd HH:mm:ss.SSS"）的日期时间字符串转换为时间戳
     * @param dateTimeStr 日期时间字符串
     * @return 时间戳（单位：毫秒）
     */
    public static long dateTimeToTimestamp(String dateTimeStr) throws Exception {
        return dateTimeToTimestamp(dateTimeStr, "yyyy-MM-dd HH:mm:ss.SSS");
    }
}
