package com.feature.java11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * java11 lambda 表达式的形式参数时允许使用var <a href="https://openjdk.org/jeps/323">EJP323</a>
 *
 * @author 朱俊伟
 * @since 2024/07/03 05:18
 */
@SuppressWarnings("all")
public class VarLambdaTest {

    public static void main(String[] args) {
        // 使用var进行类型推断
        var list = new ArrayList<String>();
        list.add("Hello");
        list.add("World");

        // 使用var在lambda表达式中
        list.forEach((var s) -> System.out.println(s));

        // 复杂类型声明使用var
        var map = new HashMap<String, List<String>>();
        map.put("key", list);

        for (var entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey());
            System.out.println("Value: " + entry.getValue());
        }

        // 使用var在带注解的lambda表达式中
        list.forEach((@Deprecated var s) -> System.out.println(s));
    }
}
