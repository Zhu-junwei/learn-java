package com.zjw.exception;

import org.junit.jupiter.api.Test;

/**
 * 测试异常
 *
 * @author 朱俊伟
 * @since 2021/11/12
 */
@SuppressWarnings("all")
public class ExceptionTest {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.onStart("123");
    }

    /**
     * exceptionMethod
     */
    @Test
    public void exceptionMethodTest() {
        try {
            // 故意抛出一个带有自定义消息"My Exception"的异常
            throw new Exception("我的异常");
        } catch (Exception e) {
            // 捕获到异常后打印捕获到异常的消息
            System.out.println("捕获到异常");
            // 使用getMessage()方法获取并打印异常的详细信息
            System.out.println("getMessage():" + e.getMessage());
            // 使用getLocalizedMessage()方法获取并打印本地化的异常信息
            System.out.println("getLocalizedMessage():" + e.getLocalizedMessage());
            // 使用toString()方法获取并打印异常对象的字符串表示形式
            System.out.println("toString():" + e);
            // 使用printStackTrace()方法打印异常的堆栈跟踪信息
            System.out.println("printStackTrace():");
            e.printStackTrace(System.out);
        }
    }

    /**
     * 异常丢失
     */
    @Test
    public void exceptionSilenceTest() {
        try {
            System.out.println("hello world!");
            throw new RuntimeException("有异常吗？");
        } finally {
            // 在 finally 块中使用 return，
            // 会把任何被抛出的异常都压制下来
            return;
        }
    }
}

class Animal {
    protected void onStart(String intent) {
        throw new RuntimeException("Stub!");
    }
}

class Dog extends Animal {
    @Override
    protected void onStart(String intent) {
        try {
            super.onStart(intent);
        } catch (Exception e) {
            // 详细信息
            System.out.println("************e.getMessage()************");
            System.out.println(e.getMessage());
            System.out.println("*************e.getLocalizedMessage()***********");
            System.out.println(e.getLocalizedMessage());
            System.out.println("*************e.toString()***********");
            System.out.println(e);
            System.out.println("*************e.printStackTrace()***********");
            e.printStackTrace();
        }
        System.out.println("onStart....");
    }
}
