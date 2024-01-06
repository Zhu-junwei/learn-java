package com.zjw._02.locksupportextends;

/**
 * 锁重入支持父子类继承的环境
 * @author 朱俊伟
 * @since 2023/02/25 16:17
 */
public class Main {
    public int i = 10;

    synchronized public void operateMainMethod() {
        try {
            i--;
            System.out.println("main print i=" + i);
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Sub extends Main {
    synchronized public void operateSubMethod() {
        try {
            i--;
            System.out.println("sub print i=" + i);
            super.operateMainMethod();
            Thread.sleep(00);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


class TestMain {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Sub sub = new Sub();
                while (sub.i > 0) {
                    sub.operateSubMethod();
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}