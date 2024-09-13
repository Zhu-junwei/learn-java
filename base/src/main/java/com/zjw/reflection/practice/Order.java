package com.zjw.reflection.practice;

import com.zjw.reflection.practice.anno.AutoWried;

/**
 * 订单类
 *
 * @author 朱俊伟
 * @since 2024/09/04 14:06
 */
@SuppressWarnings("all")
public class Order {
    private Customer customer;
    private Address address;

    @AutoWried
    public Order(Customer customer, Address address) {
        this.customer = customer;
        this.address = address;
    }

    public Order() {
    }

}
