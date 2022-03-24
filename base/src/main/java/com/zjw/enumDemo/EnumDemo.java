package com.zjw.enumDemo;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 朱俊伟
 * @date 2022/01/06
 */
public class EnumDemo {
    public static void main(String[] args) {
        ColorEnum red = ColorEnum.RED;
        System.out.println(red.name());
        //toString() 获取枚举常量名
        System.out.println(red.toString());

        //toString的逆方法
        ColorEnum red1 = ColorEnum.valueOf("RED");
        ColorEnum red2 = Enum.valueOf(ColorEnum.class, "RED");
        System.out.println(red1.toString());
        System.out.println(red2.toString());

    }

    /**
     * values方法，返回一个包含全部枚举值的数组
     */
    @Test
    public void testValues(){
        ColorEnum[] values = ColorEnum.values();
        System.out.println(Arrays.toString(values));
    }

    /**
     * ordinal方法返回enum声明中枚举常量的位置，位置从0开始计数
     */
    @Test
    public void testOrdinal(){
        int ordinal1 = ColorEnum.BLACK.ordinal();
        int ordinal2 = ColorEnum.RED.ordinal();
        int ordinal3 = ColorEnum.GREEN.ordinal();
        System.out.println(ordinal1);
        System.out.println(ordinal2);
        System.out.println(ordinal3);
    }

    /**
     * enum的简单使用
     */
    @Test
    public void testUseEnum(){
        ColorEnum colorEnum = Enum.valueOf(ColorEnum.class, "GREEN");
        System.out.println("colorEnum=" + colorEnum);
        System.out.println("englishName=" + colorEnum.getEnglishName());
        System.out.println("chineseName=" + colorEnum.getChineseName());
    }

}
