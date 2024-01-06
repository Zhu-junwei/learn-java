package com.zjw.interfacedemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Collections;

/**
 *
 * 接口的使用 实现Comparable接口
 * @author 朱俊伟
 * @since 2022/03/30 15:17
 */
public class EmployeeSortTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Harry Hacker", 35000);
        staff[1] = new Employee("Harry Hacker", 75000);
        staff[2] = new Employee("Harry Hacker", 38000);
        //按照雇员的薪资排序 sort
        Arrays.sort(staff);
        for (Employee employee : staff) {
            System.out.println(employee);
        }
        // Collections.reverse 可以实现List数组的反转
        Collections.reverse(Arrays.asList(staff));
        for (Employee employee : staff) {
            System.out.println(employee);
        }
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Employee implements Comparable<Employee>{

    /**
     * 名字
     */
    private String name;

    /**
     * 金额
     */
    private double salary;

    @Override
    public int compareTo(Employee other) {
        return Double.compare(this.salary,other.getSalary());
    }

}
