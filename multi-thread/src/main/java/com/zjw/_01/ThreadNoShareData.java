package com.zjw._01;

/**
 * 线程间不共享数据
 * @author 朱俊伟
 * @date 2023/02/18 23:34
 */
public class ThreadNoShareData extends Thread{

    int count = 5 ;

    public ThreadNoShareData(String name) {
        this.setName(name);
    }

    @Override
    public void run() {
        while (count > 0 ){
            count-- ;
            System.out.println(Thread.currentThread().getName() + "=" + count);
        }
    }

    public static void main(String[] args) {
        //每个线程都有各自的变量，不共享数据
        Thread threadA = new ThreadNoShareData("A");
        Thread threadB = new ThreadNoShareData("B");
        Thread threadC = new ThreadNoShareData("C");
        threadA.start();
        threadB.start();
        threadC.start();
    }
}
