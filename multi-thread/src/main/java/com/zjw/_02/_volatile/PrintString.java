package com.zjw._02._volatile;

import lombok.Data;
import org.junit.Test;

/**
 * 单线程死循环，多线程解决死循环
 *
 * @author zjw
 * @date 2023/03/02 12:47
 */
@Data
public class PrintString {

    private boolean isContinuePrint = true;

    public void printStringMethod() {
        try {
            while (isContinuePrint) {
                Thread.sleep(1000);
                System.out.println("printStringMethod..." + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 多线程解决锁死问题
     */
    @Test
    public void testMultiThreadMain() throws InterruptedException {
        PrintString printString = new PrintString();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                printString.printStringMethod();
            }
        };
        new Thread(runnable).start();
        //子线程启动后，主线程依然可以接着往下执行
        Thread.sleep(5050);
        System.out.println("我想停止");
        //属性设置为了false后子线程停止
        printString.setContinuePrint(false);
    }


    /**
     * 单线程造成程序锁死
     */
    @Test
    public void testSingleThreadMain() throws InterruptedException {
        PrintString printString = new PrintString();
        printString.printStringMethod();
        //单线程情况下，程序一直卡在printStringMethod方法，下面的代码无法执行到
        Thread.sleep(5050);
        System.out.println("我想停止");
        //printStringMethod方法由main线程在一直调用未结束
        printString.setContinuePrint(false);
    }

}


