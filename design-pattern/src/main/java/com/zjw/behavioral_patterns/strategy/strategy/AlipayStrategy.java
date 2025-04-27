package com.zjw.behavioral_patterns.strategy.strategy;

/**
 * 支付宝支付
 */
public class AlipayStrategy implements PaymentStrategy {
    private String email;
    
    public AlipayStrategy(String email) {
        this.email = email;
    }
    
    @Override
    public void pay(double amount) {
        System.out.println("使用支付宝支付 " + amount + " 元");
        System.out.println("支付宝账号: " + email);
    }
}