package com.zjw._02.hasself;

/**
 * 方法中的变量不存在非线程安全问题，永远都是线程安全的，这是因为方法内部的变量具有私有特性。
 * 成员变量age是线程间共享的，存在非线程安全问题，解决的方法实在方法前加上synchronized关键字
 * @author zjw
 * @since 2023/02/23 13:23
 */
public class HasSelfPrivateArg {

    private int age = 1;

    public void add(String name) {
        try {
            String str = "test";
            if (name.equals("a")) {
                age += 100;
                Thread.sleep(2000);
            } else {
                age += 200;
            }
            str += name;
            System.out.println("name=" + name + ",str=" + str + ",age=" + age);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        HasSelfPrivateArg hasSelfPrivateArg = new HasSelfPrivateArg();
        MyThread myThreadA = new MyThread(hasSelfPrivateArg);
        MyThread myThreadB = new MyThread(hasSelfPrivateArg);
        myThreadA.setName("a");
        myThreadB.setName("b");
        myThreadA.start();
        myThreadB.start();
        /*
         *方法中的变量不存在非线程安全问题，永远都是线程安全的，这是因为方法内部的变量具有私有特性。
         * 成员变量age是线程间共享的，存在非线程安全问题，解决的方法实在方法前加上synchronized关键字
         * name=b,str=testb,age=301
         * name=a,str=testa,age=301
         */
    }
}

class MyThread extends Thread {
    private final HasSelfPrivateArg hasSelfPrivateArg;

    public MyThread(HasSelfPrivateArg hasSelfPrivateArg) {
        this.hasSelfPrivateArg = hasSelfPrivateArg;
    }

    @Override
    public void run() {
        super.run();
        hasSelfPrivateArg.add(MyThread.currentThread().getName());
    }
}