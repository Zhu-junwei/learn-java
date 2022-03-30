package com.zjw.interfacedemo.clone;

import java.util.Calendar;

/**
 * Cloneable接口 Java核心技术卷Ⅰ（第十版） page 229
 * 对象克隆
 * @author 朱俊伟
 * @date 2022/03/31 1:33
 */
public class CloneTest {
    public static void main(String[] args) {
        try {
            Employee original = new Employee("John Q. Public", 50000);
            original.setHireDay(2000, Calendar.JANUARY, 1);
            Employee copy = original.clone() ;
            copy.raiseSalary(10) ;
            copy.setHireDay(2002, Calendar.DECEMBER, 31);
            System.out.println("original=" + original) ;
            System.out.println("copy=" + copy);
        } catch (CloneNotSupportedException e){
            e.printStackTrace();
        }

    }

}


