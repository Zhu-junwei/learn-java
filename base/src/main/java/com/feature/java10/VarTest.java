package com.feature.java10;

import java.util.ArrayList;

/**
 * var类型
 * <p>
 *  Java引入var类型推断关键字是在Java 10中。这个关键字使得声明局部变量时更加简洁，编译器会根据右侧的表达式自动推断变量的类型。
 *  这是Java的一项语言增强功能，有助于减少冗长的类型声明，提高了代码的可读性。
 * @author 朱俊伟
 * @since 2023/10/13 21:10
 */
public class VarTest {
    public static void main(String[] args) {

        var greeting = "Hello, World!"; // 编译器会自动推断greeting的类型为String

        var list = new ArrayList<String>(); // 类型推断可以应用于集合

        // 在foreach循环中使用var
        for (var item : list) {
            System.out.println(item);
        }


    }
}
