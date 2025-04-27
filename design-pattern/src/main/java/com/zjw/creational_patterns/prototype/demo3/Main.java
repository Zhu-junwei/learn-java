package com.zjw.creational_patterns.prototype.demo3;

/**
 * 测试浅克隆
 */
public class Main {
    public static void main(String[] args) {
        Person original = new Person("张三", 25);
        Person copy = original.clone();
        
        System.out.println("Original: " + original);
        System.out.println("Copy: " + copy);
        
        // 修改拷贝对象
        copy.setName("李四");
        copy.setAge(30);
        
        System.out.println("\nAfter modification:");
        System.out.println("Original: " + original);
        System.out.println("Copy: " + copy);
    }
}