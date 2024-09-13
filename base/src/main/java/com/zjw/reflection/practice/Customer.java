package com.zjw.reflection.practice;

import com.zjw.reflection.practice.anno.Printable;

/**
 * 顾客类
 *
 * @author 朱俊伟
 * @since 2024/09/04 14:07
 */
public class Customer {

    private String name;
    private String email;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Printable
    public void printName(){
        System.out.println("Customer name: " + name);
    }

    @Printable
    public void printEmail(){
        System.out.println("Customer email: " + email);
    }
}
