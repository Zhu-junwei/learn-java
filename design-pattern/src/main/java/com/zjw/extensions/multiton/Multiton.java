package com.zjw.extensions.multiton;

import java.util.HashMap;
import java.util.Map;

/**
 * 多例设计模式
 */
public class Multiton {
    // 静态实例集合
    private static final Map<String, Multiton> instances = new HashMap<>();

    // 私有构造方法
    private Multiton() {
        // 初始化操作
    }

    // 获取实例的方法
    public static Multiton getInstance(String key) {
        // 如果实例不存在，则创建并加入集合
        instances.putIfAbsent(key, new Multiton());
        // 返回实例
        return instances.get(key);
    }
}
