package com.zjw._03._04_producer_consumer;

import java.util.LinkedList;
import java.util.List;

/**
 * 测试生产者消费者
 * @author 朱俊伟
 * @since 2023/03/18 21:36
 */
public class ProducerConsumerTest {

    public static void main(String[] args) {
        Producer producer = new Producer();
        Consumer consumer = new Consumer();
        Thread producerThread = new Thread(producer);
        producerThread.start();
        for (int i = 0; i < 2; i++) {
            Thread consumerThread = new Thread(consumer);
            consumerThread.setName("C"+i);
            consumerThread.setPriority(Thread.MAX_PRIORITY);
            consumerThread.start();
        }
    }
}

/**
 * 生产者
 */
class Producer implements Runnable{

    int count = 0;

    @Override
    public void run() {
        produce();
    }

    public void produce(){
        while (true){
            try {
                synchronized (Container.food){
                    while (Container.food.size()>4){
                        Container.food.wait();
                    }
                    count++;
                    String food = "[食物" + count + "]";
                    Container.food.add(food);
                    System.out.println("P:-->做好饭了。" + food);
                    System.out.println(Container.food);
                    Thread.sleep(500);
                    Container.food.notifyAll();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

/**
 * 消费者
 */
class Consumer implements Runnable{

    @Override
    public void run() {
        consum();
    }

    public void consum(){
        while (true){
            try {
                synchronized (Container.food){
                    while (Container.food.isEmpty()){
                        Container.food.wait();
                    }
                    String food = Container.food.remove(0);
                    System.out.println(Thread.currentThread().getName()+ ":我把"+food+"吃了。");
                    System.out.println(Container.food);
                    Thread.sleep(500);
                    Container.food.notifyAll();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}

class Container {
    public static int MAX_FOOD = 5;
    public static final List<String> food = new LinkedList<>();
}


