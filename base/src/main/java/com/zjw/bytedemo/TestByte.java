package com.zjw.bytedemo;

import sun.nio.cs.ext.GBK;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @author 朱俊伟
 * @date 2021/11/09
 * 参考
 * https://www.cnblogs.com/zhuxiaopijingjing/p/12695782.html#:~:text=%E6%88%91%E4%BB%AC%E5%AD%A6%E4%B9%A0%20java%20%E5%9F%BA%E7%A1%80%E7%9A%84%E6%97%B6%E5%80%99.%20%E6%88%91%E4%BB%AC%E9%83%BD%E7%9F%A5%E9%81%93%E5%9C%A8%20main%20%E6%96%B9%E6%B3%95%E4%B8%AD%20String%20%E7%9A%84,getBytes%20%28%29%20%E6%96%B9%E6%B3%95%E5%A6%82%E6%9E%9C%E4%B8%8D%E6%8C%87%E5%AE%9A%E7%BC%96%E7%A0%81%E6%A0%BC%E5%BC%8F%2C%20%E9%BB%98%E8%AE%A4%E6%98%AF%20UTF-8%20%E7%9A%84%E6%96%B9%E6%B3%95%E8%BF%9B%E8%A1%8C%E7%9A%84%E7%BC%96%E7%A0%81.%20%E6%88%91%E4%BB%AC%E4%B8%80%E7%9B%B4%E8%AE%A4%E4%B8%BA%E9%BB%98%E8%AE%A4%E7%9A%84%E7%BC%96%E7%A0%81%E6%A0%BC%E5%BC%8F%E5%B0%B1%E6%98%AF%20UTF-8.
 */
public class TestByte {
    public static void main(String[] args) {
        String str = "ni hao";
        System.out.println("系统编码：" + System.getProperty("file.encoding"));
        //getBytes()默认采用系统使用的编码，也可以使用-Dfile.encoding进行的设置
        System.out.println(Arrays.toString("你好".getBytes()));
        //StandardCharsets.UTF_8 的值为UTF-8
        System.out.println(Arrays.toString("你好".getBytes(StandardCharsets.UTF_8)));
        //使用GBK格式取值
        System.out.println(Arrays.toString("你好".getBytes(new GBK())));
    }
}
