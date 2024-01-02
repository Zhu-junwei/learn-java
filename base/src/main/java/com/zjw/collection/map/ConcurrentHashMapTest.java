package com.zjw.collection.map;

import org.junit.Test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 多线程环境使用ConcurrentHashMap
 * @author 朱俊伟
 * @since 2024/01/02 20:51
 */
public class ConcurrentHashMapTest {

    @Test
    public void test1(){
        Map<Integer, String> map = new ConcurrentHashMap<>();
        map.put(3, "val");
        map.put(2, "val");
        map.put(1, "val");
        System.out.println(map);

    }
}
