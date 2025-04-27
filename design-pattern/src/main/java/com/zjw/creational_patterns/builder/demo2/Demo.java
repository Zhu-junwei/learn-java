package com.zjw.creational_patterns.builder.demo2;

/**
 * 测试使用静态内部类构建者
 * @author jw
 * @since 2025/04/23 16:09
 */
public class Demo {
    public static void main(String[] args) {
        Computer computer = new Computer.Builder("Intel i7", "16GB")
                .setUsb("3.0")
                .setKeyboard("机械键盘")
                .setDisplay("4K")
                .build();
        System.out.println(computer);
    }
}
