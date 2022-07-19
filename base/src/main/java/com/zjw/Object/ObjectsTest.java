package com.zjw.Object;

import org.junit.Test;

import java.util.Objects;

/**
 * @author 朱俊伟
 * @date 2022/05/24 12:30
 */
public class ObjectsTest {

    /**
     * Objects.equals(Object a, Object b)方法的使用
     *  - 两个参数都为null返回true
     *  - 其中一个为null返回false
     *  - 否则使用equals方法进行判断（两个对象的内存地址）
     */
    @SuppressWarnings("all")
    @Test
    public  void testEquals(){
        String str1 = "hello";
        String str2 = "hello";
        System.out.println(Objects.equals(str1, str2));//true
        System.out.println(Objects.equals(null,null));//true
        System.out.println(Objects.equals(null,str2));//false
        System.out.println(Objects.equals(str1,null));//false

    }

    @Test
    public void testObjectToLong(){
        Object obj = 123;
        Long aLong = Long.parseLong(String.valueOf(obj));
        System.out.println(aLong+1);
    }
}
