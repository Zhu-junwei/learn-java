package com.zjw.exception;

/**
 * @author 朱俊伟
 * @since 2021/11/12
 */
public class TestException {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.onStart("123");
    }
}
