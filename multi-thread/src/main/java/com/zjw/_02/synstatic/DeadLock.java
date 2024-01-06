package com.zjw._02.synstatic;

/**
 * 什么是死锁？
 * 　　死锁是指两个或两个以上的进程在执行过程中，由于竞争资源或者由于彼此通信而造成的一种阻塞的现象，若无外力作用，它们都将无法推进下去。此时称系统处于死锁状态或系统产生了死锁，这些永远在互相等待的进程称为死锁进程。
 * 　　例如，在某个计算机系统中只有一台打印机和一台输入 设备，进程P1正占用输入设备，同时又提出使用打印机的请求，但此时打印机正被进程P2 所占用，而P2在未释放打印机之前，又提出请求使用正被P1占用着的输入设备。这样两个进程相互无休止地等待下去，均无法继续执行，此时两个进程陷入死锁状态。
 * 产生死锁的四个必要条件：
 * 　　● 互斥条件：指进程对所分配到的资源进行排它性使用，即在一段时间内某资源只由一个进程占用。如果此时还有其它进程请求资源，则请求者只能等待，直至占有资源的进程用毕释放。
 * 　　● 请求与保持条件：进程已经保持了至少一个资源，但又提出了新的资源请求，而该资源 已被其他进程占有，此时请求进程被阻塞，但对自己已获得的资源保持不放。
 * 　　● 不可剥夺条件：进程所获得的资源在未使用完毕之前，不能被其他进程强行夺走，即只能 由获得该资源的进程自己来释放（只能是主动释放)。
 * 　　● 循环等待条件：指在发生死锁时，必然存在一个进程——资源的环形链，即进程集合{P0，P1，P2，···，Pn}中的P0正在等待一个P1占用的资源；P1正在等待P2占用的资源，……，Pn正在等待已被P0占用的资源。
 * 　　这四个条件是死锁的必要条件，只要系统发生死锁，这些条件必然成立，而只要上述条件之一不满足，就不会发生死锁。
 *
 * @author 朱俊伟
 * @since 2023/03/01 23:22
 */
public class DeadLock {
    public static void main(String[] args) {

        DeadService deadService = new DeadService();

        Thread threadA = new Thread(new DeadRunnable(deadService));
        Thread threadB = new Thread(new DeadRunnable(deadService));
        threadA.setName("a");
        threadB.setName("b");
        threadA.start();
        threadB.start();
    }
}

class DeadRunnable implements Runnable {

    DeadService deadService;

    public DeadRunnable(DeadService deadService) {
        this.deadService = deadService;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        if ("a".equals(name)) {
            try {
                deadService.methodA();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else if ("b".equals(name)) {
            try {
                deadService.methodB();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class DeadService {

    final Object objectA = new Object();
    final Object objectB = new Object();

    /**
     * 互斥条件:objectA、objectB对象只能同一时间被一个方法锁住
     * 请求与保持条件：methodA()方法锁objectA对象的时候未释放又申请锁objectB对象，methodB()方法锁objectB对象的时候未释放又申请锁objectA对象
     * 不可剥夺条件: 锁objectA,锁objectB未释放前不能再被其他方法剥夺锁
     * 循环等待条件：methodA()、methodB()互相等待对象释放锁
     */
    public void methodA() throws InterruptedException {
        synchronized (objectA) {
            System.out.println("methodA() start.." + Thread.currentThread().getName());
            Thread.sleep(3000);
            System.out.println("methodA() end.." + Thread.currentThread().getName());
            synchronized (objectB) {
                methodB();
            }
        }
    }

    public void methodB() throws InterruptedException {
        synchronized (objectB) {
            System.out.println("methodB() start.." + Thread.currentThread().getName());
            Thread.sleep(3000);
            System.out.println("methodB() end.." + Thread.currentThread().getName());
            synchronized (objectA) {
                methodA();
            }
        }
    }
}
