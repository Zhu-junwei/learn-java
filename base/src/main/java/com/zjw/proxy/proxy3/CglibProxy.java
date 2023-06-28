package com.zjw.proxy.proxy3;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author 朱俊伟
 * @date 2023/06/22 7:43
 */
public class CglibProxy implements MethodInterceptor {

    private final Object target;

    public CglibProxy(Object target) {
        this.target = target;
    }

    /**
     * @param obj 代理对象的引用
     * @param method 当前执行的方法
     * @param args 当前执行方法所需的参数
     * @param proxy 当前执行方法的代理对象
     * @return Object 方法的返回值
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        long start = System.nanoTime();
        Object result;
        if ("saleProduct".equals(method.getName())){
            result = method.invoke(target,(float)(args[0])*0.8F);
        } else {
            result = method.invoke(target,args);
        }
        long end = System.nanoTime();
        System.out.println("耗时"+(end-start));
        return result;
    }

    @SuppressWarnings("unchecked")
    public <T> T getProxy() {
        return (T)Enhancer.create(target.getClass(), this);
    }


    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy(new Producer());
        Producer cglibProducer = proxy.getProxy();
        cglibProducer.saleProduct(100F);
        cglibProducer.afterService(10F);
        cglibProducer.hello();
    }
}
