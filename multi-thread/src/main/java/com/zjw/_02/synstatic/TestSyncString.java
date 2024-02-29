package com.zjw._02.synstatic;

/**
 * 锁同一个String变量，一般不用
 *
 * @author 朱俊伟
 * @since 2023/02/28 22:09
 */
public class TestSyncString {
    public static void main(String[] args) {

        String str1 = "AA";
        String str2 = "AA";
        // 因为有String常量池的存在，结果为true
        System.out.println(str1 == str2);

        new MyThread2(str1).start();
        new MyThread2(str2).start();
        //发现只有线程Thread-0被执行了，因为锁的String是同一个对象
    }
}

class MyService2 {
    public static void print(String name) {
        try {
            //同步String变量
            synchronized (name) {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + ":" +name);
                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class MyThread2 extends Thread{

    private final String str;

    public MyThread2(String str) {
        this.str = str;
    }

    @Override
    public void run() {
        super.run();
        MyService2.print(this.str);
    }
}
