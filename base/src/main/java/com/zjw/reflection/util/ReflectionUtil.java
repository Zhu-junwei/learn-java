package com.zjw.reflection.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * 打印一个类的全部信息。 Java核心技术卷Ⅰ（第十版） page 194
 * @author 朱俊伟
 * @since 2022/03/28 23:50
 */
public class ReflectionUtil {
    public static void main(String[] args) {
        //从用户端输入类名
        String name;
        if (args.length > 0) name = args[0];
        else {
            Scanner in = new Scanner(System.in);
            System.out.println("请输入类名:");
            name = in.next();
        }
        //打印类的信息
        printClassInfo(name);
    }

    /**
     * 打印一个类的信息
     * @param cl 类
     */
    public static void printClassInfo(String cl){
        //从用户端输入类名
        try {
            Class<?> aClass = Class.forName(cl);
            Class<?> superclass = aClass.getSuperclass();
            String modifiers = Modifier.toString(aClass.getModifiers());
            if (modifiers.length() > 0) System.out.printf(modifiers+ " ");
            System.out.println("class " + cl);
            if (superclass != null && superclass != Object.class) System.out.printf(" extends "
                    + superclass.getName());
            System.out.print("\n{\n");

            //打印属性
            printFields(aClass);
            System.out.println();
            //打印构造方法
            printConstructor(aClass);
            System.out.println();
            //打印成员方法
            printMethods(aClass);
            System.out.println("}");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    /**
     * 打印一个类的属性
     * @param cl 类
     */
    public static void printFields(Class cl){
        Field[] fields = cl.getDeclaredFields();
        for (Field field : fields) {
            String fieldName = field.getName();
            System.out.print(" ");
            //打印权限修饰符
            String modifiers = Modifier.toString(field.getModifiers());
            if (!modifiers.isEmpty()) System.out.print(modifiers + " ");
            Class<?> type = field.getType();
            //打印参数类型,参数名
            System.out.println(type.getName() + " " + fieldName + ";");
        }
    }

    /**
     * 打印一个类的构造方法
     * @param cl 类
     */
    public static void printConstructor(Class cl){
        Constructor[] constructors = cl.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            String constructorName = constructor.getName();
            System.out.print(" ");
            //打印权限修饰符
            String modifiers = Modifier.toString(constructor.getModifiers());
            if (!modifiers.isEmpty()) System.out.print(modifiers + " ");

            //打印参数类型
            System.out.print(constructorName + "(");
            Class[] parameterTypes = constructor.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                if (i > 0) System.out.print(", ");
                System.out.print(parameterTypes[i].getName());
            }
            System.out.println(");");
        }
    }

    /**
     * 打印一个类的成员方法
     * @param cl 类
     */
    public static void printMethods(Class cl){
        Method[] methods = cl.getDeclaredMethods();
        for (Method method : methods) {
            String methodName = method.getName();
            System.out.print(" ");
            //打印权限修饰符
            String modifiers = Modifier.toString(method.getModifiers());
            if (!modifiers.isEmpty()) System.out.print(modifiers + " ");

            //打印返回值类型
            Class<?> returnType = method.getReturnType();
            System.out.print(returnType + " ");

            //打印参数类型
            System.out.print(methodName + "(");
            Class[] parameterTypes = method.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                if (i > 0) System.out.print(", ");
                System.out.print(parameterTypes[i].getName());
            }
            System.out.println(");");
        }
    }
}