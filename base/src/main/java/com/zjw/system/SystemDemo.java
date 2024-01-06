package com.zjw.system;

import java.util.Properties;
import java.util.Set;

/**
 * @author 朱俊伟
 * @since 2022/01/20
 */
public class SystemDemo {

    public static void main(String[] args) {

        //获取系统中的一些配置
        Properties properties = System.getProperties();
        Set<String> propertyNames = properties.stringPropertyNames();
        for (String propertyName : propertyNames) {
            System.out.println(propertyName + "--->" +properties.getProperty(propertyName) );
        }

        //获取系统使用的java版本
        String javaVersion = System.getProperty("java.version");
        System.out.println(javaVersion);

    }

}
