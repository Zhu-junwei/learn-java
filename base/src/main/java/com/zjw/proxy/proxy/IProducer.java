package com.zjw.proxy.proxy;

/**
 * @author 朱俊伟
 * @since 2021/02/19
 */
public interface IProducer {

    void saleProduct(float money);

    void afterService(float money);
}
