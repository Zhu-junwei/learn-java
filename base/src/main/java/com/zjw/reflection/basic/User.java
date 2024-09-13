package com.zjw.reflection.basic;

import java.util.List;

/**
 * @author 朱俊伟
 * @since 2024/09/04 10:35
 */
@SuppressWarnings("all")
public class User extends Person {

    @MyAnnotation
    public String name;
    private final int age;
    private String email;
    private List<String> comments;
    public static int publicStaticField = 1;
    private static int privateStaticField = 10;

    static {
        System.out.println("UserClass is initialized");
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User() {
        this.age = 18;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public void myPublicMethod() {
        System.out.println("My public method");
    }

    private void myPrivateMethod() {
        System.out.println("My private method");
    }

    private void myPrivateMethod(String content) {
        System.out.println("My private method with parameters." + content);
    }

    public static void myPublicStaticMethod() {
        System.out.println("My public static method");
    }

    private static void myPrivateStaticMethod() {
        System.out.println("My private static method");
    }

    private static void myPrivateStaticMethod(String content) {
        System.out.println("My static method with parameters." + content);
    }
}
