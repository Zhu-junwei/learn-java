package com.zjw.url;

import java.net.URL;

/**
 * @author jw
 * @since 2025/11/10 09:25
 */
public class URLTest {
    public static void main(String[] args) {
        URL location = URLTest.class.getProtectionDomain().getCodeSource().getLocation();
        System.out.println("当前源码位置 = " + location);
    }
}
