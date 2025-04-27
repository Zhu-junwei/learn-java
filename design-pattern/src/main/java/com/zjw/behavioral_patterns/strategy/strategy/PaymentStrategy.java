package com.zjw.behavioral_patterns.strategy.strategy;

/**
 * 支付策略接口
 */
public interface PaymentStrategy {
    void pay(double amount);
}