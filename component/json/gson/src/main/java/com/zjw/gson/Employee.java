package com.zjw.gson;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
    /**
     * 年龄
     */
    private int age;
    /**
     * 生日
     */
    private Date birthday;
    /**
     * 名字
     */
    private String name;
    /**
     * 手机
     */
    private String phone;
    /**
     * 住址
     */
    private String address;
    /**
     * 城市
     */
    private String city;
    /**
     * 金额
     */
    private double money;
}
