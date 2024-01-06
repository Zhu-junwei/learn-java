package com.zjw.domain;

import lombok.Builder;
import lombok.Data;

/**
 * lombok Builder注解使用
 * @author 朱俊伟
 * @since 2022/09/27
 */
@Builder
@Data
public class Student {

    private String name;

    private Integer age;

    public static void main(String[] args) {
        Student student = Student.builder()
                .age(18)
                .name("朱俊伟")
                .build();
        System.out.println(student);

    }
}
