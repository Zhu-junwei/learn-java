package com.zjw._02.sync;

/**
 * 方法中的变量不存在非线程安全问题，永远都是线程安全的，这是因为方法内部的变量具有私有特性。
 * @author zjw
 * @date 2023/02/23 13:23
 */
public class HasSelfPrivateArg {

    public void add(String name) {
        try {
            String str = "test";
            if (name.equals("a")) {
                str += name;
                Thread.sleep(2000);
                System.out.println("name=" + name + ",str=" + str);
            }
            if (name.equals("b")) {
                str += name;
                System.out.println("name=" + name + ",str=" + str);
            }
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
         * name=b,str=testb
         * name=a,str=testa
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