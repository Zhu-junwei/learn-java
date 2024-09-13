package com.zjw.reflection.practice;

import com.zjw.reflection.practice.anno.Printable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 朱俊伟
 * @since 2024/09/04 17:36
 */
public class PracticeMain {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchFieldException {
        Container container = new Container();
        container.init();

        String className = "com.zjw.reflection.practice.Order";
        Class<?> aClass = Class.forName(className);
        Object instance = container.createInstance(aClass);

        execService(aClass, instance, "customer");
        execService(aClass, instance, "address");

    }

    private static void execService(Class<?> aClass, Object instance, String fieldName) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException {
        System.out.println("\nexecute service: " + fieldName);
        // 获取服务的实例对象
        Field field = aClass.getDeclaredField(fieldName);
        field.setAccessible(true);
        Object service = field.get(instance);

        // 执行服务中可打印的方法
        Method[] methods = service.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.getAnnotation(Printable.class) != null) {
                method.invoke(service);
            }
        }

    }
}
