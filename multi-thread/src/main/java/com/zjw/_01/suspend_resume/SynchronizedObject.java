package com.zjw._01.suspend_resume;

/**
 * suspend造成公共同步对象被占用
 * @author 朱俊伟
 * @date 2023/02/21 22:31
 */
public class SynchronizedObject {

    synchronized public void printString() {
        System.out.println("begin");
        if (Thread.currentThread().getName().equals("a")) {
            System.out.println("我被暂停了。");
            Thread.currentThread().suspend();
        }
        System.out.println("end");
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedObject synchronizedObject = new SynchronizedObject();
        Thread threadA = new Thread() {
            @Override
            public void run() {
                synchronizedObject.printString();
            }
        };
        threadA.setName("a");
        threadA.start();
        Thread.sleep(1000);

        Thread threadB = new Thread() {
            @Override
            public void run() {
                System.out.println("我还能往下执行吗");
                synchronizedObject.printString();
            }
        };
        threadB.start();
    }
}
