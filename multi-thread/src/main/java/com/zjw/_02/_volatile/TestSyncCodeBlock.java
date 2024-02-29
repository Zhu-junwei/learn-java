package com.zjw._02._volatile;

/**
 * 测试Synchronized代码块具有增加可见性的作用。
 * @author 朱俊伟
 * @since 2023/03/02 23:19
 */
public class TestSyncCodeBlock {
    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();

        Thread threadA = new Thread(service::runMethod);
        Thread threadB = new Thread(service::stopMethod);
        threadA.start();
        Thread.sleep(1000);
        threadB.start();
    }
}

class Service{

    private boolean isContinueRun = true;
    public void runMethod(){
        System.out.println("runMethod..start");
        String str = "";
        while (isContinueRun){
            // 增加synchronized代码块，增加可见性
            // 它仍然迫使线程在每次循环时，都去检查共享变量isContinueRun的最新值
            // 但是最佳实践是使用volatile关键字来声明isContinueRun变量
            synchronized (str){};
        }
        System.out.println("runMethod..end");
    }

    public void stopMethod(){
        isContinueRun = false;
        System.out.println("isContinueRun设置为false");
    }
}
