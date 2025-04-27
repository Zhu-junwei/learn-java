package com.zjw.collection.map;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LinkedHashMap 是 Java 集合框架中基于哈希表（HashMap）和双向链表实现的有序映射表，它既能保证
 * 快速的插入、查询和删除性能（O(1)） ，又能维护键值对的插入顺序或访问顺序 。
 *
 * @author 朱俊伟
 * @since 2024/01/02 19:49
 */
public class LinkedHashMapTest {

    @Test
    public void test() {
        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(3, "val");
        map.put(2, "val");
        map.put(1, "val");
        map.put(5, "val");
        map.put(4, "val");
        // 遍历顺序与插入顺序一致
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.print(entry.getKey() + " "); // 3 2 1 5 4
        }
    }

    /**
     * LUR实现：（Least Recently Used）缓存 是一种缓存淘汰策略，它会
     * 优先移除最近最少使用（Least Recently Used）的数据。
     */
    @Test
    public void LRUTest() {
        int maxCapacity = 3;
        LinkedHashMap<String, String> lruCache = new LinkedHashMap<>(maxCapacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                return size() > maxCapacity; // 超过容量时移除最久未使用的元素
            }
        };

        lruCache.put("1", "a");
        lruCache.put("2", "b");
        lruCache.put("3", "c");
        lruCache.put("4", "d"); // 此时 "1" 会被移除
    }
}
