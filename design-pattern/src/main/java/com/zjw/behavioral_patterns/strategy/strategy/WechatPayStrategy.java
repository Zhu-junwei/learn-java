package com.zjw.behavioral_patterns.strategy.strategy;

/**
 * 微信支付
 */
public class WechatPayStrategy implements PaymentStrategy {
    private String openId;
    
    public WechatPayStrategy(String openId) {
        this.openId = openId;
    }
    
    @Override
    public void pay(double amount) {
        System.out.println("使用微信支付 " + amount + " 元");
        System.out.println("微信OpenID: " + openId);
    }
}