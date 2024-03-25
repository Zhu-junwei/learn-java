package com.feature.java21;

/**
 * Switch Null <a href="https://openjdk.org/jeps/441">JEP441</a>
 *
 * @author 朱俊伟
 * @since 2024/03/24 16:58
 */
public class SwitchNullTest {
    public static void main(String[] args) {
        testFooBarNew(null);
        testFooBarNew("Foo");
        testFooBarNew("abc");
    }

    static void testFooBarNew(String s) {
        switch (s) {
            case null         -> System.out.println("Oops");
            case "Foo", "Bar" -> System.out.println("Great");
            default           -> System.out.println("Ok");
        }
    }
}
