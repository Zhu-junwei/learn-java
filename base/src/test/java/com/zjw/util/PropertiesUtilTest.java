package com.zjw.util;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author 朱俊伟
 * @date 2023/07/14 23:21
 */
public class PropertiesUtilTest {

    /**
     * 测试获取instance对象
     */
    @Test
    public void getInstance() {
        PropertiesUtil instance = PropertiesUtil.getInstance();
        System.out.println(instance);
    }

    /**
     * 测试获取instance对象中的值
     */
    @Test
    public void testGetValue() {
        PropertiesUtil instance = PropertiesUtil.getInstance();
        String value = instance.getValue("username");
        System.out.println(value);
    }

    /**
     * 测试获取缺省值
     */
    @Test
    public void testGetValueDefault() {
        PropertiesUtil instance = PropertiesUtil.getInstance();
        String value = instance.getValue("password1","password1");
        System.out.println(value);
    }

    /**
     * 测试获取所有值
     */
    @Test
    public void getAllValue() {
        PropertiesUtil instance = PropertiesUtil.getInstance();
        Map<String, String> allValue = instance.getAllValue();
        System.out.println(allValue);
    }
}