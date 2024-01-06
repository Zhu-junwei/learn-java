package com.zjw.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author 朱俊伟
 * @since 2021/09/27
 */
public class TestGson {

    /**
     * 测试序列化和反序列化
     */
    @Test
    public void test1() {
        //创建Java对象
        Employee employee1 = Employee.builder()
                .age(18)
                .birthday(new Date())
                .name("张三")
                .phone("110")
                .address("浦东新区")
                .city("上海")
                .money(99.99)
                .build();
        System.out.println(employee1);

        //Java对象转Json
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Gson gson = new GsonBuilder()
                // 设置日期格式化
                .setDateFormat(dateFormat.toPattern())
                .create();
        String json = gson.toJson(employee1);
        // {"age":18,"birthday":"2024-01-06T14:31:34.887+0800","name":"张三","phone":"110","address":"浦东新区","city":"上海","money":99.99}
        System.out.println(json);

        // Json转Java对象
        Employee employee2 = gson.fromJson(json, Employee.class);
        System.out.println(employee2);

        // 测试equals方法
        System.out.println("employee1.equals(employee2) = " + employee1.equals(employee2));
    }

    /**
     * 测试序列化和反序列化
     * 日期处理，自定义日期的序列化器和反序列化器
     */
    @Test
    public void test2() {
        //创建Java对象
        Employee employee1 = Employee.builder()
                .age(18)
                .birthday(new Date())
                .name("张三")
                .phone("110")
                .address("浦东新区")
                .city("上海")
                .money(99.99)
                .build();
        System.out.println(employee1);

        //Java对象转Json
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Date.class, new DateSerializer())
                .registerTypeAdapter(Date.class, new DateDeserializer())
                .create();
        String json = gson.toJson(employee1);
        // {"age":18,"birthday":1704522823378,"name":"张三","phone":"110","address":"浦东新区","city":"上海","money":99.99}
        System.out.println(json);

        // Json转Java对象
        Employee employee2 = gson.fromJson(json, Employee.class);
        System.out.println(employee2);

        // 测试equals方法
        System.out.println("employee1.equals(employee2) = " + employee1.equals(employee2));
    }
}
