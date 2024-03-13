package com.zjw.collection.map;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 朱俊伟
 * @since 2022/04/13 23:53
 */
public class HashMapTest {

    /**
     * 测试 containsKey
     * <p>
     * 判断map中是否包含该key
     */
    @Test
    public void testContainsKey(){
        Map<String , String> map = new HashMap<>(){{
            put("1","a");
        }};
        System.out.println(map);//{1=a}
        System.out.println(map.get("1"));//a
        System.out.println(map.get("2"));//null
        System.out.println(map.containsKey("1"));//true
        System.out.println(map.containsKey("2"));//false
    }

    /**
     * 测试 putIfAbsent
     * <p>
     * 将指定的<K,V>放入map中。
     * <p>
     * 如果Map中不包含该key，那么putIfAbsent会返回null，否则返回该key对应的value
     */
    @Test
    public void testPutIfAbsent(){
        Map<Long , String> map = new HashMap<>();
        String string = map.putIfAbsent(1L, "2");
        System.out.println("string = " + string);
        System.out.println("map = " + map);

        string = map.putIfAbsent(1L, "2");
        System.out.println("string = " + string);
        System.out.println("map = " + map);
    }
}
