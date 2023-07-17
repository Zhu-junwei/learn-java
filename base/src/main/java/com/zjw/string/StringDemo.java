package com.zjw.string;

import org.junit.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author 朱俊伟
 * @date 2021/11/16
 */
public class StringDemo {

    //split
    @Test
    public void testStringSplit(){
        String str = "abc,def,gh,i,jk";
        //下面两个结果一样，为啥？
        String[] strings = str.split(",");
        String[] strings2 = str.split("\\,");
        System.out.println(Arrays.toString(strings));
        System.out.println(Arrays.toString(strings2));
    }

    @Test
    public void testStringSplit2(){
        String str1 = "a_b_c";
        String str2 = "a__b_c";
        //下面两个结果一样，为啥？
        String[] strings = str1.split("_");
        String[] strings2 = str2.split("_");//"a","","b","c"
        System.out.println(Arrays.toString(strings));
        System.out.println(Arrays.toString(strings2));
    }

    @Test
    public void testSubString(){
        String str = "helloWorld";
        System.out.println(str.substring(1,str.length()-1));
    }

    /**
     * 格式化输出 https://mp.weixin.qq.com/s/yCSIujfPtwuYY5FcdzHHXg
     * 说明符      适用于     输出
     * %a          浮点数     浮点数的十六进制输出
     * %b          任意种类   如果为非空，则为“真”，如果为空，则为“假”
     * %c          字符       Unicode字符
     * %d          整数       十进制整数
     * %e          浮点       科学计数法中的十进制数
     * %f          浮点       十进制数
     * %g          浮点       十进制数，可能采用科学计数法，具体取决于精度和值
     * %h          任意种类   来自hashCode()方法的十六进制字符串值
     * %n          没有       特定于平台的行分隔符（和\n类型）
     * %o          整数       八进制数
     * %s          任意种类   字符串值
     * %t          日期/时间(包括long、Calendar、Date和TemporalAccessor) %t是日期/时间转换的前缀。在此之后需要更多的格式标志。请参考下面的日期/时间转换
     * %x          整数       十六进制字符串
     */
    @Test
    public void testStringFormat(){
        System.out.printf("默认为[%1$s]:%n",123);
        double dou = 3.14;
        System.out.println(dou);
        System.out.printf("%a\n",dou);
        System.out.printf("%b \t %b\n",dou,null);
        System.out.printf("%c \t %c\n",'9','\u03d4');
        System.out.printf("%d \t %d \t %d\n",012,0xa,0b1010);
        System.out.printf("%f\n",3.14);
        System.out.printf("%h\n","I LOVE YOU.");
        System.out.printf("%n");
        System.out.printf("%o \t %o \t %o\n",010,0x9,0b1010);
        System.out.printf("%s \t %s \t %s\n",123,"abc",new Date());
    }

    /**
     * 日期和时间格式化
     *  FLAG    NOTES
     *  %tA     星期的全名，例如“星期一” “Sunday”
     *  %ta     工作日的缩写，例如“Sun” “星期一”（中文好像和%tA一样）
     *  %tB     月份的全名，例如“January” “三月”
     *  %tb     月份的全名，例如“Jan” “三月”（中文好像和%tB一样）
     *  %tC     用两位数格式化的年份的世纪部分，例如“00”到“99”
     *  %tc     用“”格式化的日期和时间，%ta %tb %td %tT %tZ %tY 例如 Fri Feb 17 07:45:42 PST 2017
     *  %tD	    日期格式为“ %tm/%td/%ty”
     *  %td	    用两位数字格式化的月份中的日期。例如“ 01”到“ 31”
     *  %te	    月份中没有前导 0 的日期，例如“1”到“31”。
     *  %tF	    带有“”的 ISO 8601 格式日期%tY-%tm-%td。
     *  %tH	    24 小时制的一天中的小时，例如“ 00”到“ 23”。
     *  %th	    与 %tb 相同。
     *  %tI	    12 小时制的一天中的小时，例如“01” – “12“。
     *  %tj	    用前导 0 格式化的一年中的一天，例如“ 001”到“ 366”。
     *  %tk	    没有前导 0 的 24 小时制时钟，例如“ 0”到“ 23”。
     *  %tl	    没有前导 0 的 12 小时点击的一天中的小时，例如“ 1”到“ 12”。
     *  %tM	    小时内的分钟格式化为前导 0，例如“ 00”到“ 59”。
     *  %tm     以 0 开头的月份格式，例如“ 01”到“ 12”。
     *  %tN	    纳秒格式为 9 位数字和前导 0，例如“000000000”到“999999999”。
     *  %tp	    特定于区域设置的“am”或“pm”标记。
     *  %tQ	    自 1970 年 1 月 1 日 00:00:00 UTC 纪元以来的毫秒数。
     *  %tR	    时间格式为 24 小时制，例如“ %tH:%tM”。
     *  %tr	    时间格式为 12 小时，例如“ %tI:%tM:%tS %Tp”。
     *  %tS	    分钟内的秒数采用 2 位数字格式，例如“00”到“60”。支持闰秒需要“60”。
     *  %ts	    自 1970 年 1 月 1 日 00:00:00 UTC 纪元以来的秒数。
     *  %tT	    时间格式为 24 小时制，例如“ %tH:%tM:%tS”
     *  %tY	    年份格式为 4 位数字，例如“ 0000”到“ 9999”。
     *  %ty	    年份格式为 2 位数字，例如“ 00”到“ 99”。
     *  %tZ	    时区缩写。例如“ UTC”、“ PST”等。
     *  %tz     与 GMT 的时区偏移量，例如“-0800“.
     */
    @Test
    public void testDateTimeFormat(){
        Date nowDate = new Date();
        System.out.printf("%tA \n",nowDate);//星期一
        System.out.printf("%ta \n",nowDate);//星期一
        System.out.printf("%tB \n",nowDate);//三月
        System.out.printf("%tb \n",nowDate);//三月
        System.out.printf("%tC \n",nowDate);//20
        System.out.printf("%tc \n",nowDate);//星期一 三月 21 23:49:07 CST 2022
        System.out.printf("%tD \n",nowDate);//03/21/22
        System.out.printf("%td \n",nowDate);//21
        System.out.printf("%te \n",nowDate);//21
        System.out.printf("%tF \n",nowDate);//2022-03-21
        System.out.printf("%tH \n",nowDate);//23
        System.out.printf("%th \n",nowDate);//三月
        System.out.printf("%tI \n",nowDate);//11
        System.out.printf("%tj \n",nowDate);//080
        System.out.printf("%tk \n",nowDate);//23
        System.out.printf("%tM \n",nowDate);//55
        System.out.printf("%tm \n",nowDate);//03
        System.out.printf("%tN \n",nowDate);//425000000
        System.out.printf("%tp \n",nowDate);//下午
        System.out.printf("%tQ \n",nowDate);//1647878286300
        System.out.printf("%tR \n",nowDate);//23:58
        System.out.printf("%tr \n",nowDate);//23:58
        System.out.printf("%tS \n",nowDate);//27
        System.out.printf("%ts \n",nowDate);//1647878396
        System.out.printf("%tT \n",nowDate);//00:00:22
        System.out.printf("%tY \n",nowDate);//2022
        System.out.printf("%ty \n",nowDate);//22
        System.out.printf("%tZ \n",nowDate);//CST
        System.out.printf("%tz \n",nowDate);//+0800


    }

    /**
     * 格式化整数
     * 使用%d格式说明符，您可以使用所有整数类型的参数，包括 byte、short、int、long 和 BigInteger。
     *
     */
    @Test
    public void testNumberFormat(){
        System.out.printf("%d%n",93);//默认格式   93
        System.out.printf("|%20d|%n",93);//指定宽度,右对齐   |                  93|
        System.out.printf("|%-20d|%n",93);//指定宽度,左对齐   |93                  |
        System.out.printf("|%020d|%n",93);//指定宽度,0填充   |00000000000000000093|
        System.out.printf("|%+20d|%n",93);//显示正负号   |                 +93|
        System.out.printf("|%+20d|%n",-93);//显示正负号   |                 -93|
        System.out.printf("|% d|%n",93);//正数显示空格，负号显示符号| 93|
        System.out.printf("|% d|%n",-93);//正数显示空格，负号显示符号|-93|
        //使用特定于语言环境的千位分隔符：对于美国语言环境，它是“，”：
        System.out.printf("%,d%n",10000000);//10,000,000
        System.out.printf("%(d%n", -36);//将负数括在括号（“（）”）中并跳过“-”： 打印: (36)
        System.out.printf("%o%n",93);//八进制输出：打印: 135
        System.out.printf("%x%n",93);//十六进制输出：打印: 5d

    }

    /**
     * DecimalFormat的使用
     */
    @Test
    public void testNumberFormat2(){
        DecimalFormat decimalFormat1 = new DecimalFormat(",##0.00");
        BigDecimal bg  = new BigDecimal("789464984984.128456");
        String format = decimalFormat1.format(bg);
        System.out.println(format);//789,464,984,984.13
    }

    @Test
    public void testIndexOf(){
        String str = "hello world";
        System.out.println(str.indexOf("ll"));//2
        System.out.println(str.indexOf("hello world"));//0
        System.out.println(str.indexOf("AA"));//-1
    }

}
