package com.zjw.map;

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
}
