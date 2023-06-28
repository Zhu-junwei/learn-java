package com.zjw.proxy.proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 * @author 朱俊伟
 * @date 2021/02/20
 */

public class JdkDynamicProxy implements InvocationHandler {

    //获取用户信息的方法名
    private static final String METHOD_GET_USERINFO = "getUserInfo";

    private final Object target;

    public JdkDynamicProxy(Object target) {
        this.target = target;
    }

    /**
     * 提供给 JVM 动态反射调用目标类的方法，返回结果
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        long start = System.currentTimeMillis();//计时开始
        String className = target.getClass().getName();
        String methodName = className + "." + method.getName();
        System.out.println("[" + methodName + "] start: " + new Date());
        System.out.println("[" + methodName + "] args: " + Arrays.toString(args));
        if (METHOD_GET_USERINFO.equals(methodName)) {//获取用户信息方法
            if (checkIsLogin()) {//校验是否登录
                result = method.invoke(target, args);//目标类的方法调用，与结果获取
            }
        } else {//非获取用户信息方法，不校验是否登录
            result = method.invoke(target, args);//目标类的方法调用，与结果获取
        }
        long end = System.currentTimeMillis();//计时结束
        System.out.println("[" + methodName + "] end: " + new Date());
        System.out.println("[" + methodName + "] 耗时: " + (end - start) + "毫秒");//打印耗时
        System.out.println("[" + methodName + "] result: " + result);
        return result;
    }

    /**
     * 获取代理类对象
     *
     * @return
     */
    @SuppressWarnings("all")
    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }

    /**
     * 模拟  当前用户是否登录
     */
    private boolean checkIsLogin() {
        Random r = new Random();
        int i = r.nextInt(10);
        if (i % 2 == 0) {
            System.out.println("已登录");
            return true;
        }
        System.out.println("未登录");
        return false;
    }

}