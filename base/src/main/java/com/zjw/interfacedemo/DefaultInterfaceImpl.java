package com.zjw.interfacedemo;

/**
 * 演示java8中新特性 接口使用default方法和static方法
 * @author 朱俊伟
 * @since 2022/01/03 13:50
 */
public class DefaultInterfaceImpl implements DefaultInterface{

    public static void main(String[] args) {

        new DefaultInterfaceImpl().defaultFunction();

        DefaultInterface.staticFunction();
    }


}
