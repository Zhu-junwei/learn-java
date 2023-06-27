package com.zjw.reflection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * 通过反射创建对象
 * @author zjw
 * @date 2023/06/27 9:32
 */
public class CreateObject {

    public static void main(String[] args) throws Exception {

        getObject();
    }

    public static  <T> T getObject() throws Exception {
        T instance = null;
        String className = "com.zjw.reflection.Student";
        Class<T> aClass = (Class<T>) Class.forName(className);
        instance = aClass.newInstance();
        //设置name属性的值
        instance.getClass().getMethod("setName", String.class).invoke(instance, "zjw");
        //设置不存在的address属性的值 会报错
//        instance.getClass().getMethod("setAddress", String.class).invoke(instance, "zjw");
        //没有这个方法也会异常NoSuchMethodException
//        Method method = instance.getClass().getMethod("setAddress", String.class);
//        System.out.println(method);
        System.out.println(instance);
        return instance;
    }

}
@Data
class Student {

    private String name;

    private Integer age;
}
