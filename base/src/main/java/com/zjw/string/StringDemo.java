package com.zjw.string;

import com.sun.deploy.util.StringUtils;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author 朱俊伟
 * @date 2021/11/16
 */
public class StringDemo {

    //格式化输出
    @Test
    public void testStringFormat(){
        System.out.println(String.format("默认为[%1$s]:",123));
    }

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
    public void testString(){
        System.out.println("aaa,aaa".contains(","));
    }

    @Test
    public void testSubString(){
        String str = "helloworld";
        System.out.println(str.substring(1,str.length()-1));
    }
}
