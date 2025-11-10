package com.zjw.collection.map;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

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
        map.computeIfAbsent(2L, k -> "3");

        // 集合中存在key,返回key对应的value, 不会将key-value放入map中
        string = map.putIfAbsent(1L, "3");
        System.out.println("string = " + string); // string = 2
        System.out.println("map = " + map); // map = {1=2}
    }

    /**
     * computeIfAbsent 测试
     * 此方法演示了如何使用computeIfAbsent作为缓存机制，避免重复计算。
     * 假设我们有一个昂贵的计算过程，它接受一个ID并返回与之关联的数据。
     * 我们可以使用HashMap来存储已经计算过的数据，以避免重复计算。
     */
    @Test
    public void computeIfAbsentTest() {
        // 初始化一个空的HashMap来存储计算结果
        Map<Long, String> cache = new HashMap<>();

        // 定义一个模拟的昂贵计算过程
        Function<Long, String> dataCalculator = id -> {
            // 模拟耗时计算
            try {
                Thread.sleep(1000); // 睡眠1秒，代表耗时操作
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "Data for ID: " + id;
        };

        // 计算ID为1的数据，如果不在缓存中，会调用dataCalculator进行计算并存入缓存
        String data1 = cache.computeIfAbsent(1L, dataCalculator);
        System.out.println("Data for ID 1: " + data1);

        // 尝试再次计算ID为1的数据，由于已存在于缓存中，不会重新计算
        String data1Again = cache.computeIfAbsent(1L, dataCalculator);
        System.out.println("Data for ID 1 (cached): " + data1Again);

        // 计算ID为2的数据，假设之前未计算过
        String data2 = cache.computeIfAbsent(2L, dataCalculator);
        System.out.println("Data for ID 2: " + data2);
    }

    /**
     * computeIfPresent
     * 指定键存在时重新计算其对应的值
     */
    @Test
    public void computeIfPresentTest() {
        HashMap<Long, Long> hashMap = new HashMap<>();
        hashMap.computeIfPresent(1L, (k, v) -> v * 2);
        System.out.println(hashMap); // {}
        hashMap.put(1L, 2L);
        hashMap.computeIfPresent(1L, (k, v) -> v * 2);
        System.out.println(hashMap); // {1=4}
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
