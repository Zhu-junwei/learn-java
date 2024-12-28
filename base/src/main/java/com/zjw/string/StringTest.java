package com.zjw.string;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
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
        System.out.println(str.indexOf("e")); // 1
        System.out.println(str.indexOf("ll"));//2
        System.out.println(str.indexOf("hello123 456"));//0
        System.out.println(str.indexOf("AA"));//-1

        //返回最后子索引字符串的索引
        System.out.println(str.lastIndexOf("o"));// 4
        //返回索引处的字符
        System.out.println(str.charAt(2)); // l
        //截取子字符串
        System.out.println(str.substring(1)); // ello123 456
        System.out.println(str.substring(1, 3)); // el
        //除去前后的空格
        System.out.println(" ni  ".trim()); // ni
        //字符替换
        System.out.println(str.replace('l', 'L')); // 字符替换 heLLo123 456
        System.out.println(str.replace("l", "L")); // 字符串替换 heLoo123 456
        System.out.println(str.replaceAll("l", "L")); // heLLo123 456 谨慎使用，使用的是正则表达式
        System.out.println(str.replaceFirst("l", "L")); // heLlo123 456
        // 重复字符串
        System.out.println("hello".repeat(3)); // hellohellohello

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
        System.out.println("equal:" + str1.equals(str2)); // false
        //比较是忽略大小写
        System.out.println("equalsIgnoreCase:" + str1.equalsIgnoreCase(str2)); // true
        System.out.println("==:" + (str1 == str2)); // false


        /*
          按字典顺序比较
            比较的两个字符串首字符的Unicode编码的差值（后-前）
         */
        System.out.println("abc".compareTo("csdaf"));
        //大小写转换
        System.out.println("abc".toUpperCase());
        System.out.println("ABC".toLowerCase());

        // 包含
        System.out.println(str.contains("123"));//true
        System.out.println(str.contains("A"));//false
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
        String[] strings = str.split(",");
        System.out.println(Arrays.toString(strings)); // [abc, def, gh, i, jk]

        String str1 = "a_b_c";
        String str2 = "a__b_c";
        String[] strings1 = str1.split("_"); // "a","b","c"
        String[] strings2 = str2.split("_"); // "a","","b","c"
        System.out.println(Arrays.toString(strings1)); // [a, b, c]
        System.out.println(Arrays.toString(strings2)); // [a, , b, c]

        // 根据多个分隔符拆分
        String[] strings3 = "17140216;80.845,90.55,100.00".split(";|,");
        System.out.println(Arrays.toString(strings3));//[17140216, 80.845, 90.55, 100.00]
    }

    /**
     * formatted，格式化
     *
     * @since 15
     */
    @Test
    public void formattedTest() {
        String name = null;
        String formatted = "Your name is %s".formatted(name != null ? name : "unkonwn");
        System.out.println(formatted);
        // since 9
        String formatted2 = "Your name is " + Objects.requireNonNullElse(name, "unkonwn");
        System.out.println(formatted2);
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
        System.out.printf("默认为[%1$s]:%n", 123); // 默认为[123]:  %n表示一个平台无关的换行符，相当于 \n，但可以根据平台的不同输出适当的换行符。
        double dou = 3.14;
        System.out.println(dou);
        System.out.printf("%a\n", dou); // 浮点数的十六进制输出
        System.out.printf("%b \t %b\n", dou, null);
        System.out.printf("%c \t %c\n", '9', '\u03d4');
        System.out.printf("%d \t %d \t %d\n", 012, 0xa, 0b1010);
        System.out.printf("%f\n", 3.14);
        System.out.printf("%h %s\n", "I LOVE YOU.", Integer.toHexString("I LOVE YOU.".hashCode()));
        System.out.printf("%n");
        System.out.printf("%o \t %o \t %o\n", 010, 0x9, 0b1010);
        System.out.printf("%s \t %s \t %s\n", 123, "abc", new Date());
    }


    /**
     * 格式化整数
     * 使用%d格式说明符，您可以使用所有整数类型的参数，包括 byte、short、int、long 和 BigInteger。
     * 字符串使用%s格式说明符
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
     * System.out.format
     */
    @Test
    public void formatTest() {
        int x = 5;
        double y = 5.332542;
        // 旧的方式：
        System.out.println("Row 1: [" + x + " " + y + "]");
        // 新的方式：
        System.out.format("Row 1: [%d %f]%n", x, y);
        // 或者：
        System.out.printf("Row 1: [%d %f]%n", x, y);
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

    /**
     * codePoints获取Unicode编码点
     */
    @Test
    public void codePointsTest() {
        String str = "hello";
        str.codePoints().forEach(System.out::println);
        str = "你好";
        str.codePoints().forEach(System.out::println);
    }

}
