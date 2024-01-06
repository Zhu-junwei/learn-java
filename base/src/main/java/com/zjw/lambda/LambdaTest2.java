package com.zjw.lambda;

import java.util.ArrayList;
import java.util.Objects;

/**
 * lambda表达式 ArrayList removeIf方法
 * 删除数组所有null值
 * @author 朱俊伟
 * @since 2022/03/31 18:37
 */
public class LambdaTest2 {
    public static void main(String[] args) {

//        testPredicate();
        testMethodReference();

    }

    /**
     * Predicate 接口使用
     */
    public static void testPredicate(){
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add(null);
        list.add("c");
        System.out.println(list);
        //removeIf 方法接受一个Predicate类型的对象
        list.removeIf(e -> e == null);
        System.out.println(list);
    }

    /**
     * 方法引用 ::操作符分割方法名和类名 主要有3中情况
     *  - object::instanceMethod
     *  - Class::staticMethod   System.out::println 等价于 x-> System.out.println(x)
     *  - Class::instanceMethod     String::compareToIgnoreCase 等价于 (x,y) -> x.compareToIgnoreCase(y)
     * ref:Java核心技术卷Ⅰ（第十版） page 236
     *
     * 方法引用 将Objects类的isNull方法传递到removeIf中
     */
    public static void testMethodReference(){
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add(null);
        list.add("c");
        System.out.println(list);
        //方法引用
        list.removeIf(Objects::isNull);
        System.out.println(list);
    }
}
