package com.zjw.util;

import java.io.IOException;
import java.util.Properties;

/**
 * @author 朱俊伟
 * @date 2022/07/14
 */
public class PropertiesUtil {

    private final Properties prop = new Properties();

    private static final PropertiesUtil instance = new PropertiesUtil();

    private PropertiesUtil() {
        try {
            this.prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static PropertiesUtil getInstance() {
        return instance;
    }

    public String getValue(String key){
        return (String)this.prop.get(key);
    }

    public String getValue(String key, String defaultValue){
        return this.prop.getProperty(key, defaultValue);
    }

}
