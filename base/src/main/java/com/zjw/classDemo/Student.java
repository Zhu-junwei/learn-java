package com.zjw.classDemo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 学生类
 * @author 朱俊伟
 * @since 2021/12/28
 */
@Data
@EqualsAndHashCode(callSuper = true)
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
