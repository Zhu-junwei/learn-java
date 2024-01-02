package com.feature.java5;

import java.util.ArrayList;

/**
 * @author 朱俊伟
 * @since 2024/01/02 19:00
 */
public class GenericsTest {

    public static void main(String[] args) {
        //测试泛型使用
        genericsTest1();
    }

    private static void genericsTest1() {
        // Java 泛型（Generics） 是 JDK 5 中引入的一个新特性。使用泛型参数，可以增强代码的可读性以及稳定性。
        // 编译器可以对泛型参数进行检测，并且通过泛型参数可以指定传入的对象类型。
        // 比如  ArrayList<String> list = new ArrayList<>();
        // 这行代码就指明了该 ArrayList 对象只能传入 String 对象，如果传入其他类型的对象就会报错。
        ArrayList<String> list = new ArrayList<>();
    }


}
