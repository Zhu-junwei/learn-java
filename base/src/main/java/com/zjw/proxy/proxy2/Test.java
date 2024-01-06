package com.zjw.proxy.proxy2;

/**
 * @author 朱俊伟
 * @since 2021/02/20
 */

public class Test {

    public static void main(String[] args) {
        JdkDynamicProxy proxy = new JdkDynamicProxy(new ServiceImpl());
        Service service = proxy.getProxy();
        service.login("zjw", "123456");
        service.getUserInfo("zjw");
    }

}
