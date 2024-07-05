package com.feature.java5.enumDemo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author 朱俊伟
 * @since 2022/01/06
 */
public class EnumTest {

    /**
     * enum的简单使用
     */
    @Test
    public void testUseEnum(){
        ColorEnum red = ColorEnum.RED;
        // red.name()返回此枚举常量的名称，与该枚举声明中声明的名称完全相同, 官方推荐toString()方法
        System.out.println(red.name()); // RED
        System.out.println(red); // RED

        ColorEnum red1 = ColorEnum.valueOf("RED");
        ColorEnum red2 = Enum.valueOf(ColorEnum.class, "RED");
        System.out.println(red1); // RED
        System.out.println(red2); // RED

        ColorEnum colorEnum = Enum.valueOf(ColorEnum.class, "GREEN");
        System.out.println("colorEnum=" + colorEnum);
        System.out.println("englishName=" + colorEnum.getEnglishName());
        System.out.println("chineseName=" + colorEnum.getChineseName());
        System.out.println("chineseName=" + ColorEnum.RED.getChineseName());
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
        System.out.println(ordinal1); // 2
        System.out.println(ordinal2); // 1
        System.out.println(ordinal3); // 0
    }

}
