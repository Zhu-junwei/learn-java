package com.feature.java8;

/**
 * @author 朱俊伟
 * @since 2023/12/18 13:11
 */
public class DefaultInterfaceImpl implements DefaultInterface{
    public static void main(String[] args) {
        DefaultInterfaceImpl defaultInterface = new DefaultInterfaceImpl();
        // 调用接口的普通方法
        defaultInterface.info();
        // 调用接口的默认实现
        defaultInterface.defaultMethod();
        // 调用接口的static方法
        DefaultInterface.staticMethod();
    }

    @Override
    public void info() {
        System.out.println("实现接口的info方法");
    }
}

