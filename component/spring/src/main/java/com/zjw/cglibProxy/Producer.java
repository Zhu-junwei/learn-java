package com.zjw.cglibProxy;

/**
 * 一个生产者
 */
public class Producer {

    public void saleProduct(float money){
        System.out.println("销售产品，并拿到钱："+money);
    }

    public void afterService(float money){
        System.out.println("提供售后服务，并拿到钱："+money);
    }

    public final void hello(){
        System.out.println("你能代理我嘛？？");
    }
}