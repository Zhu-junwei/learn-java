package com.zjw.proxy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 模拟一个消费者
 */
public class Client {
    public static void main(String[] args) {
        final Producer producer = new Producer();

        /*
          动态代理：
           特点：字节码随用随创建，随用随加载
           作用：不用修改源码的基础上对方法增强
           分类：
               基于接口的动态代理
               基于子类的动态代理

            基于接口的动态代理：
               涉及的类：Proxy
               提供者：JDK官方
            如何创建代理对象：
               使用Proxy类中的newProxyInstance方法
            创建代理对象的要求：
               被代理类最少实现一个接口，如果没有则不能使用
             newProxyInstance方法的参数：
               ClassLoader:类加载器
                   它是用于加载代理对象字节码的。和被代理对象使用相同的类加载器。固定写法。
               Class[]:字节码数组
                   它是用于让代理对象和被代理对象有相同方法。固定写法。
               InvocationHandler:用于提供增强的代码
                   它是让我们写如何代理。我们一般都是写一个接口的实现类，通常情况下都是匿名内部类，但不是必须的。
                   此接口的实现类都是谁用谁写。
         */
        IProducer proxyProducer = (IProducer) Proxy.newProxyInstance(
                producer.getClass().getClassLoader(),
                producer.getClass().getInterfaces(),
                new InvocationHandlerImpl(producer));
        proxyProducer.saleProduct(10000f);
        proxyProducer.afterService(10000f);
    }
}

/**
 * 提供增强的代码
 */
class InvocationHandlerImpl implements InvocationHandler {

    private final Producer producer;

    public InvocationHandlerImpl(Producer producer) {
        this.producer = producer;
    }

    /**
     * 作用：执行被代理对象的任何方法都会经过该方法
     * 方法参数的含义
     *
     * @param proxy  代理对象的引用
     * @param method 当前执行的方法
     * @param args   当前执行方法所需的参数
     * @return 和被代理对象方法有相同返回值
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("##invoke………start");
        System.out.println("proxy class = " + proxy.getClass().getName());
        System.out.println("method = " + method.getName());
        System.out.println("args = " + Arrays.toString(args));
        //提供增强的代码
        Object object;
        //判断当前方法是不是销售
        if ("saleProduct".equals(method.getName())) {
            //获取方法执行的参数
            Float money = (Float) args[0];
            object = method.invoke(producer, money * 0.8F);
        } else {
            //不需要代码增强
            object = method.invoke(producer, args);
        }
        System.out.println("##invoke………end\n");
        return object;
    }
}