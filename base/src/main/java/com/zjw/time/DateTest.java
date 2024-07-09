package com.zjw.time;

import org.junit.jupiter.api.Test;

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

    /**
     * 日期和时间格式化
     * FLAG    NOTES
     * %tA     星期的全名，例如“星期一” “Sunday”
     * %ta     工作日的缩写，例如“Sun” “星期一”（中文好像和%tA一样）
     * %tB     月份的全名，例如“January” “三月”
     * %tb     月份的全名，例如“Jan” “三月”（中文好像和%tB一样）
     * %tC     用两位数格式化的年份的世纪部分，例如“00”到“99”
     * %tc     用“”格式化的日期和时间，%ta %tb %td %tT %tZ %tY 例如 Fri Feb 17 07:45:42 PST 2017
     * %tD	    日期格式为“ %tm/%td/%ty”
     * %td	    用两位数字格式化的月份中的日期。例如“ 01”到“ 31”
     * %te	    月份中没有前导 0 的日期，例如“1”到“31”。
     * %tF	    带有“”的 ISO 8601 格式日期%tY-%tm-%td。
     * %tH	    24 小时制的一天中的小时，例如“ 00”到“ 23”。
     * %th	    与 %tb 相同。
     * %tI	    12 小时制的一天中的小时，例如“01” – “12“。
     * %tj	    用前导 0 格式化的一年中的一天，例如“001”到“ 366”。
     * %tk	    没有前导 0 的 24 小时制时钟，例如“0”到“23”。
     * %tl	    没有前导 0 的 12 小时点击的一天中的小时，例如“ 1”到“ 12”。
     * %tM	    小时内的分钟格式化为前导 0，例如“00”到“59”。
     * %tm     以 0 开头的月份格式，例如“01”到“12”。
     * %tN	    纳秒格式为 9 位数字和前导 0，例如“000000000”到“999999999”。
     * %tp	    特定于区域设置的“am”或“pm”标记。
     * %tQ	    自 1970 年 1 月 1 日 00:00:00 UTC 纪元以来的毫秒数。
     * %tR	    时间格式为 24 小时制，例如“%tH:%tM”。
     * %tr	    时间格式为 12 小时，例如“%tI:%tM:%tS %Tp”。
     * %tS	    分钟内的秒数采用 2 位数字格式，例如“00”到“60”。支持闰秒需要“60”。
     * %ts	    自 1970 年 1 月 1 日 00:00:00 UTC 纪元以来的秒数。
     * %tT	    时间格式为 24 小时制，例如“%tH:%tM:%tS”
     * %tY	    年份格式为 4 位数字，例如“0000”到“9999”。
     * %ty	    年份格式为 2 位数字，例如“00”到“99”。
     * %tZ	    时区缩写。例如“ UTC”、“ PST”等。
     * %tz     与 GMT 的时区偏移量，例如“-0800“.
     */
    @Test
    public void testDateTimeFormat() {
        Date nowDate = new Date();
        System.out.printf(String.format("%tr", nowDate));//12:05:12 上午星期一
        System.out.printf("%tA \n", nowDate);//星期一
        System.out.printf("%ta \n", nowDate);//星期一
        System.out.printf("%tB \n", nowDate);//三月
        System.out.printf("%tb \n", nowDate);//三月
        System.out.printf("%tC \n", nowDate);//20
        System.out.printf("%tc \n", nowDate);//星期一 三月 21 23:49:07 CST 2022
        System.out.printf("%tD \n", nowDate);//03/21/22
        System.out.printf("%td \n", nowDate);//21
        System.out.printf("%te \n", nowDate);//21
        System.out.printf("%tF \n", nowDate);//2022-03-21
        System.out.printf("%tH \n", nowDate);//23
        System.out.printf("%th \n", nowDate);//三月
        System.out.printf("%tI \n", nowDate);//11
        System.out.printf("%tj \n", nowDate);//080
        System.out.printf("%tk \n", nowDate);//23
        System.out.printf("%tM \n", nowDate);//55
        System.out.printf("%tm \n", nowDate);//03
        System.out.printf("%tN \n", nowDate);//425000000
        System.out.printf("%tp \n", nowDate);//下午
        System.out.printf("%tQ \n", nowDate);//1647878286300
        System.out.printf("%tR \n", nowDate);//23:58
        System.out.printf("%tr \n", nowDate);//23:58
        System.out.printf("%tS \n", nowDate);//27
        System.out.printf("%ts \n", nowDate);//1647878396
        System.out.printf("%tT \n", nowDate);//00:00:22
        System.out.printf("%tY \n", nowDate);//2022
        System.out.printf("%ty \n", nowDate);//22
        System.out.printf("%tZ \n", nowDate);//CST
        System.out.printf("%tz \n", nowDate);//+0800
    }
}
