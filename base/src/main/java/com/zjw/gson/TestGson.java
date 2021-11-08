package com.zjw.gson;

import com.google.gson.Gson;

/**
 * @author 朱俊伟
 * @date 2021/09/27
 */
public class TestGson {
    public static void main(String[] args) {
        //创建Java对象
        Employee employee = new Employee(18,"张三","110","浦东新区","上海",99.99);
        System.out.println(employee);
        //Java对象转Json
        Gson gson = new Gson();
        String json = gson.toJson(employee);
        System.out.println(json);
        //Json转Java对象
        Employee employee1 = gson.fromJson(json, Employee.class);


    }
}
