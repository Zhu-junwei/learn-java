package com.zjw.classDemo;

import java.lang.reflect.Field;

/**
 * @author 朱俊伟
 * @date 2021/12/28
 */
public class ClassDemo {
    public static void main(String[] args) {
        Student student = new Student();

        Class<? super Student> cls = Student.class;
        while (cls != null){
            Field[] fields = cls.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(field.getName());
            }
            cls = cls.getSuperclass();
        }

    }
}
