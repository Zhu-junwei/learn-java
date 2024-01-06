package com.zjw.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author 朱俊伟
 * @since 2022/07/14
 */
public class PropertiesUtil {

    private final Properties prop = new Properties();

    private static final PropertiesUtil instance = new PropertiesUtil();

    private PropertiesUtil() {
        try(InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties")) {
            this.prop.load(inputStream);
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

    public Map<String,String> getAllValue() {
        Map<String,String> map = new HashMap<>();
        this.prop.stringPropertyNames().forEach(key -> map.put(key, this.prop.getProperty(key)));
        return map;
    }
}
