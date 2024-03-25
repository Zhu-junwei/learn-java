package com.zjw.collection.map;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 多线程环境下使用ConcurrentHashMap来保持线程安全的并发操作
 */
public class ConcurrentHashMapTest {


    public static void main(String[] args) {

        Map<String, Integer> hashMap = new HashMap<>();
        Map<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // 模拟 10 个线程同时向 map 中写入数据
        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> {
                for (int j = 0; j < 10000; j++) {
                    hashMap.put("key" + j, j);
                    concurrentHashMap.put("key" + j, j);
                }
            });
        }

        // 关闭线程池
        executorService.shutdown();

        // 等待所有线程执行完毕
        while (!executorService.isTerminated()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 打印 map 中的元素个数
        // ConcurrentHashMap输出为 10000
        // HashMap输出的结果会大于10000
        System.out.println(hashMap.size());
        System.out.println(concurrentHashMap.size());
    }

    /**
     * ConcurrentHashMap 不能添加 null 值
     */
    @Test
    public void testAdd(){
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put(null, 1);
        System.out.println("hashMap = " + hashMap);

        Map<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
//        concurrentHashMap.put(null, 1); // NullPointerException
    }
}