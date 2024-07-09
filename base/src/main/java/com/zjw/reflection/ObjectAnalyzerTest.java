package com.zjw.reflection;

import com.zjw.reflection.util.ObjectAnalyzer;

/**
 * 利用反射获取对象的属性信息 测试
 * @author 朱俊伟
 * @since 2022/03/30 0:06
 */
public class ObjectAnalyzerTest {
    public static void main(String[] args) {
        Employee employee = new Employee("小明", 12);
        System.out.println(new ObjectAnalyzer().toString(employee));
    }
}
