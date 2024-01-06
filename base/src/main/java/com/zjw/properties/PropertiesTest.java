package com.zjw.properties;

import com.zjw.util.PropertiesUtil;

/**
 * @author 朱俊伟
 * @since 2022/07/06
 */
public class PropertiesTest {
    public static void main(String[] args) {
        String username = PropertiesUtil.getInstance().getValue("username");
        System.out.println(username);
    }
}
