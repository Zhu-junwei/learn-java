package com.zjw._03._05_producer_consumer;

import lombok.SneakyThrows;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 *
 * @author 朱俊伟,ChatGPT
 * @since 2023/03/18 23:55
 */
public class ProducerConsumerExample {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        int capacity = 10;

        // Create multiple producers and consumers
        for (int i = 1; i <= 5; i++) {
            new Producer(queue, capacity, "Producer" + i).start();
            new Consumer(queue, capacity, "Consumer" + i).start();
        }
    }
}

class Producer extends Thread {

    private Queue<Integer> queue;
    private int capacity;
    private String name;

    public Producer(Queue<Integer> queue, int capacity, String name) {
        this.queue = queue;
        this.capacity = capacity;
        this.name = name;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.size() == capacity) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int num = new Random().nextInt(100);
                queue.add(num);
                System.out.println(name + " produced " + num);
                System.out.println(queue);
                Thread.sleep(250);
                queue.notifyAll();
            }
        }
    }
}

class Consumer extends Thread {

    private Queue<Integer> queue;
    private int capacity;
    private String name;

    public Consumer(Queue<Integer> queue, int capacity, String name) {
        this.queue = queue;
        this.capacity = capacity;
        this.name = name;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.isEmpty()) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int num = queue.poll();
                System.out.println(name + " consumed " + num);
                System.out.println(queue);
                Thread.sleep(500);
                queue.notifyAll();
            }
        }
    }
}
