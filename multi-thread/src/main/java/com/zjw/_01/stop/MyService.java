package com.zjw._01.stop;

import lombok.Getter;

/**
 * @author 朱俊伟
 * @since 2023/02/21 21:23
 */
@Getter
public class MyService {
    private String username = "a";
    private String password = "aa";

    public void printInfo(String username, String password) {
        this.username = username;
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.password = password;
    }

    @Override
    public String toString() {
        return "MyService{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static void main(String[] args) {
        MyService service = new MyService();
        MyThreadA threadA = new MyThreadA(service);
        threadA.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //A线程终止造成数据不一致
        threadA.stop();

        System.out.println(service);
    }
}

class MyThreadA extends Thread {
    private MyService object;

    public MyThreadA(MyService object) {
        this.object = object;
    }

    @Override
    public void run() {
        object.printInfo("a_MyThreadA", "aa_MyThread");
    }
}