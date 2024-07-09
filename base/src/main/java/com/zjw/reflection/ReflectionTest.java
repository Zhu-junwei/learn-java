package com.zjw.reflection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Constructor;

/**
 * @author 朱俊伟
 * @since 2022/03/25 11:37
 */
public class ReflectionTest {
    public static void main(String[] args) throws Exception {

        Employee e = new Employee();
        //通过对象的getClass方法获取Class对象
        Class<? extends Employee> aClass = e.getClass();
        System.out.println(aClass); // class com.zjw.reflection.Employee
        System.out.println(aClass.getName()); // com.zjw.reflection.Employee
        System.out.println(aClass.getSimpleName()); // Employee

        //通过Class.forName方法获取Class对象
        String className = "com.zjw.reflection.Employee";
        Class<?> aClass1 = Class.forName(className);

        //通过反射创建对象
        Employee emp = (Employee) aClass1.newInstance(); // jdk9后被废弃了,推荐使用constructor.newInstance创建对象
        aClass1.getMethod("setName", String.class).invoke(emp, "zjw");
        System.out.println(emp);
        //通过指定构造函数创建对象
        Constructor<Employee> constructor = Employee.class.getConstructor(String.class, int.class);
        Employee employee = constructor.newInstance("", 12);
        System.out.println(employee);
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Employee {

    private String name;
    private int age;
}
