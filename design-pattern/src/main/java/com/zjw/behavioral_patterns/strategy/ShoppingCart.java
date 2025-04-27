package com.zjw.behavioral_patterns.strategy;

import com.zjw.behavioral_patterns.strategy.strategy.PaymentStrategy;
import lombok.Setter;

/**
 * 购物车上下文
 */
public class ShoppingCart {
    @Setter
    private PaymentStrategy paymentStrategy;
    private double totalAmount;
    
    public void addItem(double price) {
        totalAmount += price;
    }

    public void checkout() {
        if (paymentStrategy == null) {
            System.out.println("请先选择支付方式");
            return;
        }
        paymentStrategy.pay(totalAmount);
    }
}