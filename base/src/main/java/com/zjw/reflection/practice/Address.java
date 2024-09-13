package com.zjw.reflection.practice;

import com.zjw.reflection.practice.anno.Printable;

/**
 * 地址类
 *
 * @author 朱俊伟
 * @since 2024/09/04 14:07
 */
public class Address {
    public String street;
    public String postCode;

    public String getStreet() {
        return street;
    }

    public String getPostCode() {
        return postCode;
    }

    public Address(String street, String postCode) {
        this.street = street;
        this.postCode = postCode;
    }

    @Printable
    public void printStreet() {
        System.out.println("Address street: " + street);
    }

    @Printable
    public void printPostCode() {
        System.out.println("Address postCode: " + postCode);
    }
}
