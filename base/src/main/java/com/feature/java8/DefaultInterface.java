package com.feature.java8;

/**
 * @author 朱俊伟
 * @since 2023/12/18 13:12
 */
public interface DefaultInterface {

    void info();

    // default方法
    default void defaultMethod(){
        System.out.println("this is a default method");
    }

    // static方法
    static void staticMethod(){
        System.out.println("this is a static method");
    }


    public static void main(String[] args) {

    }
}