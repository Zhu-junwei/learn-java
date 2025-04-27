package com.zjw.structural_patterns.composite;

// 使用示例
public class OrganizationDemo {
    public static void main(String[] args) {
        Department engineering = new Department("工程部");
        engineering.add(new Employee("Eve", "工程部经理"));

        Department frontend = new Department("前端组");
        frontend.add(new Employee("Alice", "前端开发"));
        frontend.add(new Employee("Bob", "UI设计师"));

        Department backend = new Department("后端组");
        backend.add(new Employee("Charlie", "Java开发"));
        backend.add(new Employee("David", "数据库管理员"));

        engineering.add(frontend);
        engineering.add(backend);

        System.out.println("公司组织架构:");
        engineering.displayDetails("");
    }
}