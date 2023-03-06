package com.zjw._02._volatile;

import lombok.Data;

/**
 * 单线程死循环，多线程解决死循环
 * @author zjw
 * @date 2023/03/02 12:47
 */
@Data
public class PrintString {

    private boolean isContinuePrint = true;

    public void printStringMethod(){
        try {
            while (isContinuePrint){
                Thread.sleep(1000);
                System.out.println("printStringMethod..." + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        PrintString printString = new PrintString();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                printString.printStringMethod();
            }
        };
        new Thread(runnable).start();
        Thread.sleep(5050);
        System.out.println("我想停止");
        //printStringMethod方法由main线程在一直调用未结束
        printString.setContinuePrint(false);
    }

}


