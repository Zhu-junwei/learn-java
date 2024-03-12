package com.zjw.reflection.classDemo;
import java.lang.reflect.Field;
/**
 * 这是一个演示如何通过反射获取类及其父类中声明的所有字段的示例代码
 * @author 朱俊伟
 * @since 2021/12/28
 */
public class ClassDemo {
    public static void main(String[] args) {

        // 获取 Student 类及其父类中声明的所有字段名
        Class<? super Student> cls = Student.class;
        while (cls != null){
            System.out.println(cls.getName());
            // 获取当前类中声明的所有字段
            Field[] fields = cls.getDeclaredFields();
            // 打印每个字段的名称
            for (Field field : fields) {
                System.out.println(field.getName());
            }
            // 获取父类，继续循环
            cls = cls.getSuperclass();
        }
    }
}