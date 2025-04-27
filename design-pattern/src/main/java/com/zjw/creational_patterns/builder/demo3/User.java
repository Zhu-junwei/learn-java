package com.zjw.creational_patterns.builder.demo3;

import lombok.Builder;
import lombok.ToString;

/**
 * 使用 @Builder 注解
 */
@Builder
@ToString
public class User {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String phone;
}