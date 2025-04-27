package com.zjw.creational_patterns.builder.demo3;

/**
 * 测试 Lombok @Builder
 * @author jw
 * @since 2025/04/23 16:17
 */
public class Demo {
    public static void main(String[] args) {
        User user = User.builder()
                .firstName("张")
                .lastName("三")
                .age(30)
                .phone("123456789")
                .build();
        System.out.println(user);
    }
}
