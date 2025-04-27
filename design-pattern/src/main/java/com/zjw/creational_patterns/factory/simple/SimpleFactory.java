package com.zjw.creational_patterns.factory.simple;

// 简单工厂模式示例
public class SimpleFactory {
    public static Product createProduct(String type) {
        if ("A".equals(type)) {
            return new ConcreteProductA();
        } else if ("B".equals(type)) {
            return new ConcreteProductB();
        }
        // 可以添加其他产品类型的判断
        return null;
    }
}

interface Product {
    void doSomething();
}

class ConcreteProductA implements Product {
    @Override
    public void doSomething() {
        System.out.println("Product A is doing something.");
    }
}

class ConcreteProductB implements Product {
    @Override
    public void doSomething() {
        System.out.println("Product B is doing something.");
    }
}