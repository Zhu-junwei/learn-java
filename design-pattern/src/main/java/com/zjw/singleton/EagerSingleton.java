package com.zjw.singleton;

/**
 * 饿汉式 单例设计模式
 */
public class EagerSingleton {

    private static final EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {
        // 私有构造方法
    }

    public static EagerSingleton getInstance() {
        return instance;
    }
}