package com.zjw.classDemo;

import lombok.Data;

/**
 * 学生类
 * @author 朱俊伟
 * @date 2021/12/28
 */
@Data
public class Student extends Person{
    /**
     * 学校
     */
    private String school;

    /**
     * 年级
     */
    private String grade;

    /**
     * 名字
     */
    private String name;
}
