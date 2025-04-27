package com.zjw.behavioral_patterns.strategy;

import com.zjw.behavioral_patterns.strategy.strategy.AlipayStrategy;
import com.zjw.behavioral_patterns.strategy.strategy.BankCardStrategy;
import com.zjw.behavioral_patterns.strategy.strategy.WechatPayStrategy;

/**
 * 测试类
 */
public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        
        // 添加商品
        cart.addItem(99.9);
        cart.addItem(199.9);
        
        // 选择支付方式并结账
        cart.setPaymentStrategy(new AlipayStrategy("user@example.com"));
        cart.checkout();
        
        System.out.println("----------");
        
        // 更换支付方式
        cart.setPaymentStrategy(new WechatPayStrategy("wx123456789"));
        cart.checkout();
        
        System.out.println("----------");
        
        // 再次更换支付方式
        cart.setPaymentStrategy(new BankCardStrategy("6225888888888888", "123"));
        cart.checkout();
    }
}