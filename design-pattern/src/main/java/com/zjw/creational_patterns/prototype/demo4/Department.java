package com.zjw.creational_patterns.prototype.demo4;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * 对象深克隆
 */
@Data
@ToString
public class Department implements Cloneable {
    private String name;
    private List<Employee> employees;
    
    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }
    
    public void addEmployee(Employee emp) {
        employees.add(emp);
    }
    
    // 深拷贝实现
    @Override
    public Department clone() {
        try {
            Department cloned = (Department) super.clone();
            
            // 对引用类型进行深拷贝
            cloned.employees = new ArrayList<>();
            for (Employee emp : this.employees) {
                cloned.employees.add(emp.clone());
            }
            
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

@Data
@ToString
class Employee implements Cloneable {
    private String name;
    private String position;
    
    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }
    
    @Override
    public Employee clone() {
        try {
            return (Employee) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}