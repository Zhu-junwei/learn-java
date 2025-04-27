package com.zjw.behavioral_patterns.strategy.strategy;

/**
 * 银行卡支付
 */
public class BankCardStrategy implements PaymentStrategy {
    private String cardNumber;
    private String cvv;
    
    public BankCardStrategy(String cardNumber, String cvv) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
    }
    
    @Override
    public void pay(double amount) {
        System.out.println("使用银行卡支付 " + amount + " 元");
        System.out.println("卡号: " + cardNumber.substring(cardNumber.length()-4));
    }
}