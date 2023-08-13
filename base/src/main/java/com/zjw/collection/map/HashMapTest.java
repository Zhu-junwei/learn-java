package com.zjw.collection.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 朱俊伟
 * @date 2022/04/13 23:53
 */
public class HashMapTest {
    public static void main(String[] args) {
        Map<String , String> map = new HashMap<>();
        map.put("1","a");
        System.out.println(map);//{1=a}
        System.out.println(map.get("1"));//a
        System.out.println(map.get("2"));//null
        System.out.println(map.containsKey("1"));//true
        System.out.println(map.containsKey("2"));//false

    }

    @Test
    public void testContainsKey(){
        Map<Long , String> map = new HashMap<>();
        map.put(Long.parseLong("1"),"a");
        map.put(Long.parseLong("123456"),"b");
        map.put(Long.parseLong("123456"),"c");
        System.out.println(map);//{1=a}
        System.out.println(map.get(Long.parseLong("1")));//a
        System.out.println(map.get(Long.parseLong("123456")));//c
        System.out.println(map.get(Long.parseLong("123457")));//null
        System.out.println(map.containsKey(Long.parseLong("123456")));//true
        System.out.println(map.containsKey(Long.parseLong("123457")));//false
    }
}
