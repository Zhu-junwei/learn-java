package com.zjw.collection.map;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 根据插入的顺序排序
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
        System.out.println(map); // {3=val, 2=val, 1=val, 5=val, 4=val}
    }
}
