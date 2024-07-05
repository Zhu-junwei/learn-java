package com.feature.java9;

/**
 * 可以在接口中定义私有方法和私有静态方法<a href="https://openjdk.org/jeps/213">EJP213</a>，
 * 作为对 Lambda 表达式支持的一部分
 */
interface MyInterface {

    // 定义一个默认方法
    default void defaultMethod() {
        System.out.println("Default Method");
        // 调用私有实例方法
        privateMethod();
    }

    // 定义一个私有实例方法
    private void privateMethod() {
        System.out.println("Private Method");
    }

    // 定义一个静态方法
    static void staticMethod() {
        System.out.println("Static Method");
        // 调用私有静态方法
        privateStaticMethod();
    }

    // 定义一个私有静态方法
    private static void privateStaticMethod() {
        System.out.println("Private Static Method");
    }
}

public class PrivateMethod implements MyInterface {
    public static void main(String[] args) {
        // 创建 MyClass 的实例
        PrivateMethod privateMethod =  new PrivateMethod();
        // 调用默认方法
        privateMethod.defaultMethod();
        // 输出:
        // Default Method
        // Private Method

        // 调用静态方法
        MyInterface.staticMethod();
        // 输出:
        // Static Method
        // Private Static Method
    }
}