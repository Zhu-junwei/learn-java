package com.zjw._02._volatile;

import org.junit.Test;

/**
 * 测试Synchronized代码块具有增加可见性的作用。
 * @author 朱俊伟
 * @date 2023/03/02 23:19
 */
public class TestSyncCodeBlock {
    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();

        Runnable runnableA = new Runnable() {
            @Override
            public void run() {
                service.runMethod();
            }
        };
        Runnable runnableB = new Runnable() {
            @Override
            public void run() {
                service.stopMethod();
            }
        };

        Thread threadA = new Thread(runnableA);
        Thread threadB = new Thread(runnableB);
        threadA.start();
        Thread.sleep(1000);
        threadB.start();
    }

    @Test
    public void testTestSyncCodeBlock() throws InterruptedException {



    }
}

class Service{

    private boolean isContinueRun = true;
    public void runMethod(){
        System.out.println("runMethod..start");
        String str = "";
        while (isContinueRun){
            //增加synchronized代码块，增加可见性
            //可见公共堆栈中的值？
            synchronized (str){};
        }
        System.out.println("runMethod..end");
    }

    public void stopMethod(){
        isContinueRun = false;
        System.out.println("stopMethod()...end");
    }
}
