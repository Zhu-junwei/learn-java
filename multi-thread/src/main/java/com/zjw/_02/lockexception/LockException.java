package com.zjw._02.lockexception;

/**
 * @author 朱俊伟
 * @since 2023/02/25 16:29
 */
public class LockException {

    synchronized public void testMethod() throws InterruptedException {
        if (Thread.currentThread().getName().equals("a")) {
            System.out.println("ThreadName=" + Thread.currentThread().getName() + ",run beginTime=" + System.currentTimeMillis());
            int i = 1;
            while (i == 1) {
                if ((Math.random() + "").startsWith("0.123456")) {
                    Thread.sleep(5000);
                    System.out.println("ThreadName=" + Thread.currentThread().getName() + ",exception beginTime=" + System.currentTimeMillis());
                    throw new RuntimeException("我异常了");
                }
            }
        } else {
            System.out.println("ThreadName=" + Thread.currentThread().getName() + ",run beginTime=" + System.currentTimeMillis());
        }
    }
}

class TestMain{
    public static void main(String[] args) throws InterruptedException {
        LockException lockException = new LockException();
        Thread threadA = new Thread(new MyRunnable(lockException));
        Thread threadB = new Thread(new MyRunnable(lockException));
        threadA.setName("a");
        threadB.setName("b");
        threadA.start();
        Thread.sleep(100);
        //线程A执行的时候出现异常释放锁，线程B接着执行
        threadB.start();
    }
}

class MyRunnable implements Runnable{

    private final LockException lockException;

    public MyRunnable(LockException lockException) {
        this.lockException = lockException;
    }

    @Override
    public void run() {
        try {
            lockException.testMethod();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}