package com.zjw.string;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

/**
 * @author 朱俊伟
 * @since 2021/11/16
 */
@SuppressWarnings("all")
public class StringTest {

    /**
     * 测试String常用方法
     */
    @Test
    public void testStringMethod() {
        String str = "hello123 456";
        //返回子字符串处的索引
        System.out.println(str.indexOf("e"));
        //返回最后子索引字符串的索引
        System.out.println(str.lastIndexOf("6"));
        //返回索引处的字符
        System.err.println(str.charAt(2));
        //截取子字符串
        System.out.println(str.substring(1));
        System.out.println(str.substring(1, 3));
        //除去前后的空格
        System.out.println(" ni  ".trim());
        //字符替换
        System.out.println(str.replace('l', 'L'));
        System.out.println(str.replaceAll("l", "L"));

        //判断开始结尾
        System.out.println(str.startsWith("he"));
        System.out.println(str.endsWith("56"));
        /*
          比较字符串是否相等
            equal比较的是两个对象的内容
            ==比较的是地址是否相等
         */
        System.out.println("*************************");
        String str1 = new String("I'm Junwei Zhu");
        String str2 = new String("I'M Junwei Zhu");
        System.out.println("equal:" + str1.equals(str2));
        //比较是忽略大小写
        System.out.println("equalsIgnoreCase:" + str1.equalsIgnoreCase(str2));
        System.out.println("==:" + (str1 == str2));


        /*
          按字典顺序比较
            比较的两个字符串首字符的Unicode编码的差值（后-前）
         */
        System.out.println("abc".compareTo("csdaf"));
        //大小写转换
        System.out.println("abc".toUpperCase());
        System.out.println("ABC".toLowerCase());
    }

    /**
     * 测试基本数据类型和String类互转
     * <p>
     * 基本数据类型：byte、short、int、long、char、float、double、boolean
     * 基本数据类型->String：利用String类提供的ValueOf（基本类型）方法转换
     * 基本数据类型<-String:利用包装类的parseXXX（）方法；
     */
    @Test
    public void toTypeConvert() {
        //byte
        byte by = 5;
        String str_by = String.valueOf(by);
        by = Byte.parseByte(str_by);

        //int转String
        int a = 100;
        String str = String.valueOf(a);
        a = Integer.parseInt(str);

        //char型
        char ch = 'a';
        String str_ch = String.valueOf(ch);
        ch = str_ch.charAt(0);//使用String类的charAt()方法

        //boolean型
        boolean boo = true;
        String str_boo = String.valueOf(boo);
        boo = Boolean.parseBoolean(str_boo);

        //float型
        float flo = 10.2f;
        String str_flo = String.valueOf(flo);
        flo = Float.parseFloat(str_flo);

        //double型
        double dou = 10.1d;
        String str_dou = String.valueOf(dou);
        dou = Double.parseDouble(str_dou);
    }

    //split
    @Test
    public void testStringSplit() {
        String str = "abc,def,gh,i,jk";
        //下面两个结果一样，为啥？
        String[] strings = str.split(",");
        String[] strings2 = str.split("\\,");
        System.out.println(Arrays.toString(strings));
        System.out.println(Arrays.toString(strings2));
    }

    @Test
    public void testStringSplit2() {
        String str1 = "a_b_c";
        String str2 = "a__b_c";
        //下面两个结果一样，为啥？
        String[] strings = str1.split("_");
        String[] strings2 = str2.split("_");//"a","","b","c"
        System.out.println(Arrays.toString(strings));
        System.out.println(Arrays.toString(strings2));
    }

    /**
     * 根据多个分隔符拆分
     */
    @Test
    public void testStringSplit3() {
        String str = "17140216;80.845,90.55,100.00";
        String[] strings = str.split(";|,");
        System.out.println(Arrays.toString(strings));//[17140216, 80.845, 90.55, 100.00]
    }

    @Test
    public void testSubString() {
        String str = "helloWorld";
        System.out.println(str.substring(1, str.length() - 1));
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
    public void testStringFormat() {
        System.out.printf("默认为[%1$s]:%n", 123);
        double dou = 3.14;
        System.out.println(dou);
        System.out.printf("%a\n", dou);
        System.out.printf("%b \t %b\n", dou, null);
        System.out.printf("%c \t %c\n", '9', '\u03d4');
        System.out.printf("%d \t %d \t %d\n", 012, 0xa, 0b1010);
        System.out.printf("%f\n", 3.14);
        System.out.printf("%h\n", "I LOVE YOU.");
        System.out.printf("%n");
        System.out.printf("%o \t %o \t %o\n", 010, 0x9, 0b1010);
        System.out.printf("%s \t %s \t %s\n", 123, "abc", new Date());
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
     * %tj	    用前导 0 格式化的一年中的一天，例如“ 001”到“ 366”。
     * %tk	    没有前导 0 的 24 小时制时钟，例如“ 0”到“ 23”。
     * %tl	    没有前导 0 的 12 小时点击的一天中的小时，例如“ 1”到“ 12”。
     * %tM	    小时内的分钟格式化为前导 0，例如“ 00”到“ 59”。
     * %tm     以 0 开头的月份格式，例如“ 01”到“ 12”。
     * %tN	    纳秒格式为 9 位数字和前导 0，例如“000000000”到“999999999”。
     * %tp	    特定于区域设置的“am”或“pm”标记。
     * %tQ	    自 1970 年 1 月 1 日 00:00:00 UTC 纪元以来的毫秒数。
     * %tR	    时间格式为 24 小时制，例如“ %tH:%tM”。
     * %tr	    时间格式为 12 小时，例如“ %tI:%tM:%tS %Tp”。
     * %tS	    分钟内的秒数采用 2 位数字格式，例如“00”到“60”。支持闰秒需要“60”。
     * %ts	    自 1970 年 1 月 1 日 00:00:00 UTC 纪元以来的秒数。
     * %tT	    时间格式为 24 小时制，例如“ %tH:%tM:%tS”
     * %tY	    年份格式为 4 位数字，例如“ 0000”到“ 9999”。
     * %ty	    年份格式为 2 位数字，例如“ 00”到“ 99”。
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

    /**
     * 格式化整数
     * 使用%d格式说明符，您可以使用所有整数类型的参数，包括 byte、short、int、long 和 BigInteger。
     */
    @Test
    public void testNumberFormat() {
        System.out.printf("%d%n", 93);//默认格式   93
        System.out.printf("|%20d|%n", 93);//指定宽度,右对齐   |                  93|
        System.out.printf("|%-20d|%n", 93);//指定宽度,左对齐   |93                  |
        System.out.printf("|%020d|%n", 93);//指定宽度,0填充   |00000000000000000093|
        System.out.printf("|%+20d|%n", 93);//显示正负号   |                 +93|
        System.out.printf("|%+20d|%n", -93);//显示正负号   |                 -93|
        System.out.printf("|% d|%n", 93);//正数显示空格，负号显示符号| 93|
        System.out.printf("|% d|%n", -93);//正数显示空格，负号显示符号|-93|
        //使用特定于语言环境的千位分隔符：对于美国语言环境，它是“，”：
        System.out.printf("%,d%n", 10000000);//10,000,000
        System.out.printf("%(d%n", -36);//将负数括在括号（“（）”）中并跳过“-”： 打印: (36)
        System.out.printf("%o%n", 93);//八进制输出：打印: 135
        System.out.printf("%x%n", 93);//十六进制输出：打印: 5d

    }

    /**
     * DecimalFormat的使用
     */
    @Test
    public void testNumberFormat2() {
        DecimalFormat decimalFormat1 = new DecimalFormat(",##0.00");
        BigDecimal bg = new BigDecimal("789464984984.128456");
        String format = decimalFormat1.format(bg);
        System.out.println(format);//789,464,984,984.13
    }

    @Test
    public void testIndexOf() {
        String str = "hello world";
        System.out.println(str.indexOf("ll"));//2
        System.out.println(str.indexOf("hello world"));//0
        System.out.println(str.indexOf("AA"));//-1
    }

    @Test
    public void testContains() {
        String str = "123456";
        System.out.println(str.contains("1"));//true
        System.out.println(str.contains("A"));//false
    }

    /**
     * String format
     * 为什么在Test里面不能输入呀？
     */
    @Test
    public void stringFormatTest() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入整数：");
        int anInt = scanner.nextInt();
        System.out.println(anInt);
        System.out.print("输入小数：");
        double aDouble = scanner.nextDouble();
        System.out.println(aDouble);
        String doubleFormat = String.format(".3f", aDouble);
        System.out.println(doubleFormat);
    }

    @Test
    public void stringFormat2Test() {


        System.out.printf("|%s|%n", "hello");
        System.out.printf("|%20s|%n", "hello");//指定宽度,右对齐   |                  93|
        System.out.printf("|%20s|%n", "hellohellohellohellohellohellohellohellohellohellohellohellohello");//指定宽度,右对齐   |                  93|
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入整数：");
        int anInt = scanner.nextInt();
        System.out.println(anInt);
        System.out.print("输入小数：");
        double aDouble = scanner.nextDouble();
        System.out.println(aDouble);
        String doubleFormat = String.format("%.3f", aDouble);
        System.out.println(doubleFormat);
    }

}
