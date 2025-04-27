package com.zjw.creational_patterns.prototype.demo4;

/**
 * 测试对象深克隆
 */
public class Main {
    public static void main(String[] args) {
        Department original = new Department("研发部");
        original.addEmployee(new Employee("张三", "工程师"));
        original.addEmployee(new Employee("李四", "经理"));
        
        Department copy = original.clone();
        
        System.out.println("Original: " + original);
        System.out.println("Copy: " + copy);
        
        // 修改拷贝对象
        copy.getEmployees().getFirst().setName("王五");
        
        System.out.println("\nAfter modification:");
        System.out.println("Original: " + original);
        System.out.println("Copy: " + copy);
    }
}