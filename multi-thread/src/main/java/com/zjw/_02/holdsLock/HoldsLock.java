package com.zjw._02.holdsLock;

/**
 * @author 朱俊伟
 * @since 2023/02/25 16:55
 */
public class HoldsLock {
    public static void main(String[] args) {
        System.out.println(Thread.holdsLock(HoldsLock.class));
        synchronized (HoldsLock.class) {
            System.out.println(Thread.holdsLock(HoldsLock.class));
        }
        System.out.println(Thread.holdsLock(HoldsLock.class));
    }
}
