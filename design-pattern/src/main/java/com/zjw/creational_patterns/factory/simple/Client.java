package com.zjw.creational_patterns.factory.simple;

// 客户端使用简单工厂模式
public class Client {
    public static void main(String[] args) {
        Product productA = SimpleFactory.createProduct("A");
        productA.doSomething();

        Product productB = SimpleFactory.createProduct("B");
        productB.doSomething();
    }
}