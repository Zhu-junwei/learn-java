package com.zjw.collection.map;

import org.junit.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * TreeMap中的元素默认按照keys的自然排序排列。
 *
 * （对Integer来说，其自然排序就是数字的升序；对String来说，其自然排序就是按照字母表排序）
 *
 * @author 朱俊伟
 * @since 2024/01/02 19:44
 */
public class TreeMapTest {

    /**
     * 创建一个空TreeMap，keys按照自然排序
     */
    @Test
    public void test1(){
        TreeMap<Integer, String> treeMap = new TreeMap<>();
    }

    /**
     * 创建一个空TreeMap，按照指定的comparator排序
     */
    @Test
    public void test2(){
        TreeMap<Integer, String> map = new TreeMap<>(Comparator.reverseOrder());
        map.put(3, "val");
        map.put(2, "val");
        map.put(1, "val");
        map.put(5, "val");
        map.put(4, "val");
        System.out.println(map); // {5=val, 4=val, 3=val, 2=val, 1=val}
    }

    /**
     * 由给定的map创建一个TreeMap，keys按照自然排序
     */
    @Test
    public void test3(){
        Map<Integer, String> map = new HashMap<>();
        map.put(3, "val");
        map.put(2, "val");
        map.put(1, "val");
        map.put(5, "val");
        map.put(4, "val");
        TreeMap<Integer, String> treeMap = new TreeMap<>(map);
        System.out.println(treeMap); // {1=val, 2=val, 3=val, 4=val, 5=val}
    }


}

