package com.zjw.system;

import org.junit.jupiter.api.Test;

import java.util.Properties;
import java.util.Set;

/**
 * @author 朱俊伟
 * @since 2022/01/20
 */
public class SystemDemo {

    public static void main(String[] args) {

        // 获取系统中的一些配置
        Properties properties = System.getProperties();
        Set<String> propertyNames = properties.stringPropertyNames();
        for (String propertyName : propertyNames) {
            System.out.println(propertyName + "--->" +properties.getProperty(propertyName) );
        }

        // 获取系统使用的java版本
        String javaVersion = System.getProperty("java.version");
        System.out.println(javaVersion);

    }

    @Test
    public void sysInfoTest(){
        // 可用处理器的数量
        System.out.println(Runtime.getRuntime().availableProcessors());
        // 版本信息
        System.out.println(Runtime.version());
        // 总内存大小
        System.out.println(Runtime.getRuntime().totalMemory()/1024/1024 + "M");
        // 可用内存大小
        System.out.println(Runtime.getRuntime().freeMemory()/1024/1024 + "M");
    }

}
