package com.zjw.interfacedemo.clone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 类继承Cloneable接口 实现深克隆方法
 * @author 朱俊伟
 * @since 2022/03/31 1:37
 */
@NoArgsConstructor @AllArgsConstructor
@Data
public class Employee implements Cloneable{

    private String name;
    private double salary;
    private Date hireDay;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public Employee clone() throws CloneNotSupportedException{
        //call Object.clone()
        Employee cloned = (Employee) super.clone();
        //clone mutable fields
        cloned.hireDay = (Date) hireDay.clone();

        return cloned;
    }

    public void setHireDay(int year, int month, int day){
        this.hireDay = new GregorianCalendar(year, month, day).getTime();
    }

    public void raiseSalary(double byPercent){
        double raise = salary * byPercent / 100;
        this.salary += raise;
    }

}
