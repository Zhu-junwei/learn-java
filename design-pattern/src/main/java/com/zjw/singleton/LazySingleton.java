package com.zjw.singleton;

/**
 * 懒汉式 单例设计模式
 */
public class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {
        // 私有构造方法
    }

    // 懒汉式，添加同步锁保证线程安全
    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

    public static void main(String[] args) {
        LazySingleton instance1 = LazySingleton.getInstance();
    }
}
