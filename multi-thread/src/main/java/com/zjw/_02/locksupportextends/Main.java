package com.zjw._02.locksupportextends;

import cn.hutool.core.thread.ThreadUtil;

/**
 * 锁重入支持父子类继承的环境
 *
 * @author 朱俊伟
 * @since 2023/02/25 16:17
 */
public class Main {
    public int i = 10;

    synchronized public void operateMainMethod() {
        i--;
        System.out.println("main print i=" + i);
    }
}

class Sub extends Main {

    synchronized public void operateSubMethod() {
        i--;
        System.out.println("sub print i=" + i);
        super.operateMainMethod();
        ThreadUtil.sleep(100);
    }
}

class TestMain {
    public static void main(String[] args) {
        new Thread(() -> {
            Sub sub = new Sub();
            while (sub.i > 0) {
                sub.operateSubMethod();
            }
        }).start();
    }
}