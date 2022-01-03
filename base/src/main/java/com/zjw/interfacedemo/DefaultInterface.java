package com.zjw.interfacedemo;

/**
 * @author 朱俊伟
 */
public interface DefaultInterface {


    /**
     * default 方法 Java8新特性
     */
    default void defaultFunction(){
        System.out.println("this is a default function");
    }

    /**
     * static 方法 Java8新特性
     */
    static void staticFunction(){
        System.out.println("this is a static function");
    }
}
