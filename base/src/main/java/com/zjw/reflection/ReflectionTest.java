package com.zjw.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author 朱俊伟
 * @since 2022/03/25 11:37
 */
public class ReflectionTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<? extends ReflectionTest> aClass2 = ReflectionTest.class;
        System.out.println(aClass2.getName());
        Employee e = new Employee();
        //通过对象的getClass方法获取Class对象
        Class<? extends Employee> aClass = e.getClass();
        System.out.println(aClass);
        //获取类名 com.zjw.reflection.Employee
        System.out.println(aClass.getName());

        //通过Class.forName方法获取Class对象
        String className = "com.zjw.reflection.Employee";
        Class<?> aClass1 = Class.forName(className);
        System.out.println(aClass1.getName());

        //通过反射创建对象
        Employee emp = (Employee)aClass1.newInstance();
        System.out.println(emp);
        //通过指定构造函数创建对象
        Constructor constructor = Employee.class.getConstructor(String.class, int.class);
        Employee employee = (Employee)constructor.newInstance("",12);
        System.out.println(employee);
    }
}

class Employee{

    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
