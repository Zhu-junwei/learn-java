package com.zjw._02.holdsLock;

/**
 * Thread.holdsLock(Object obj)
 * 判断当前线程是否持有obj对象的锁
 * @author 朱俊伟
 * @since 2023/02/25 16:55
 */
public class HoldsLock {
    public static void main(String[] args) {
        System.out.println(Thread.holdsLock(HoldsLock.class));//false
        synchronized (HoldsLock.class) {
            System.out.println(Thread.holdsLock(HoldsLock.class));//true
        }
        System.out.println(Thread.holdsLock(HoldsLock.class));//false
    }
}
