package com.zjw.collection.map;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
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
     * 将指定的K,V放入map中。
     * <p>
     * 如果Map中不包含该key，那么putIfAbsent会返回null，并将key-value放入map中。
     * 否则返回该key对应的value，不会将key-value放入map中。
     */
    @Test
    public void testPutIfAbsent(){
        Map<Long , String> map = new HashMap<>();
        // 集合中不存在key,返回null, 并将key-value放入map中
        String string = map.putIfAbsent(1L, "2");
        System.out.println("string = " + string); // string = null
        System.out.println("map = " + map); // map = {1=2}

        // 集合中存在key,返回key对应的value, 不会将key-value放入map中
        string = map.putIfAbsent(1L, "3");
        System.out.println("string = " + string); // string = 2
        System.out.println("map = " + map); // map = {1=2}
    }

    /**
     * 测试hashmap merge
     * <p>
     * 将指定的map合并到当前map中。
     * <p>
     */
    @Test
    public void testMerge() {
        Map<String, String> map1 = new HashMap<>() {{
            put("1", "a");
            put("2", "b");
        }};
        map1.merge("1", "c", (v1, v2) -> v1 + v2);
        map1.merge("3", "d", (v1, v2) -> v1 + v2);
        System.out.println(map1); // {1=ac, 2=b, 3=d}
    }

    @Test
    public void testMerge2() {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> integerList = List.of(1, 2, 3, 4, 3);
        integerList.forEach(i -> map.merge(i, 1, Integer::sum));
        System.out.println(map); // {1=1, 2=1, 3=2, 4=1}

    }
}
