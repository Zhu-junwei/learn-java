package com.zjw._02.dirtyread;

/**
 * 脏读问题及解决办法
 * @author 朱俊伟
 * @since 2023/02/25 0:42
 */
public class PublicVar {
    public String username = "A";
    public String password = "AA";

    synchronized public void setValue(String username, String password) {
        try {
            this.username = username;
            Thread.sleep(5000);
            this.password = password;
            System.out.println("setValue method, ThreadName=" + Thread.currentThread().getName() + ", username=" + this.username + ",password=" + this.password);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    synchronized public void getValue() {
        System.out.println("getValue method, ThreadName=" + Thread.currentThread().getName() + ", username=" + username + ",password=" + password);
    }

    public static void main(String[] args) throws InterruptedException {
        PublicVar publicVar = new PublicVar();
        ThreadChangeValue threadChangeValueA = new ThreadChangeValue(publicVar);
        threadChangeValueA.setName("threadChangeValueA");
        threadChangeValueA.start();
        Thread.sleep(2000);
        publicVar.getValue();
        /* 在getValue方法没有synchronized关键字室，出现了脏读，在线程A还没有执行完setValue方法时，main线程就调用了getValue
         * 解决脏读的办法是在getValue方法上加上synchronized关键字
         */
    }
}

class ThreadChangeValue extends Thread {

    private final PublicVar publicVar;

    public ThreadChangeValue(PublicVar publicVar) {
        this.publicVar = publicVar;
    }

    @Override
    public void run() {
        super.run();
        publicVar.setValue("B", "BB");
    }
}
