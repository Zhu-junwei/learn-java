package com.zjw.structural_patterns.composite;

/**
 * 叶子节点 - 员工
 * @author jw
 * @since 2025/04/24 04:34
 */
class Employee implements OrganizationComponent {
    private String name;
    private String position;

    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void displayDetails(String prefix) {
        System.out.println(prefix + "├─ " + name + " (" + position + ")");
    }

    @Override
    public void add(OrganizationComponent component) {
        throw new UnsupportedOperationException("Cannot add to an employee");
    }
}
