package com.zjw.gson;

import lombok.*;

/**
 * @author 朱俊伟
 * @date 2021/09/27
 */
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    /**
     * 年龄
     */
    private int age;
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
