package com.zjw.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *不可变Map集合测试
 *		不可以修改、添加、删除
 * @author 朱俊伟
 * @date 2023/07/23 22:42
 */
public class UnChangeMapTest {

    /**
     * 创建不可变Map集合
     */
    @Test
    public void createUnChangeMap(){
        Map<Integer, String> map = Map.of(0, "a", 2, "b", 3, "c");
        System.out.println(map);
        //创建不可变Map集合的key不能重复 java.lang.IllegalArgumentException: duplicate key: 0
//        Map<Integer, String> map2 = Map.of(0, "a", 0, "a",2, "b", 3, "c");
//        System.out.println(map2);

        //需要注意的是，这种方式创建的不可变Map集合最后只能有20个key value
//        Map<Integer, String> map = Map.of(0, "a", 2, "b", 3, "c", 4, "d", 5, "e", 6, "a", 7, "b", 8, "c", 9, "d", 10, "e",
//                11, "a", 12, "b", 13, "c", 14, "d", 15, "e", 16, "a", 17, "b", 18, "c", 19, "d", 20, "e", 21, "a" );

        //如果超过20个元素，可以采用下面的方法创建不可变Map集合
        Map<Integer, String> hashMap = new HashMap<>();
        for (int i = 0; i < 21; i++) {
            hashMap.put(i,"a");
        }
        Set<Map.Entry<Integer, String>> entries = hashMap.entrySet();
        Map.Entry[] mapEntry = new Map.Entry[entries.size()];
        entries.toArray(mapEntry);
        Map unChangeMap = Map.ofEntries(mapEntry);
        System.out.println(unChangeMap);
    }

    /**
     * 尝试修改不可变Map集合
     * 		抛出异常 java.lang.UnsupportedOperationException
     */
    @Test
    public void modifyUnChangeList(){
        Map<Integer, String> map = Map.of(0, "a", 2, "b", 3, "c");
        System.out.println(map);
        map.put(1,"a");
    }

    /**
     * 尝试删除不可变Map集合中的元素
     * 		抛出异常 java.lang.UnsupportedOperationException
     */
    @Test
    public void deleteUnChangeList(){
        Map<Integer, String> map = Map.of(0, "a", 2, "b", 3, "c");
        System.out.println(map);
        map.remove(0);
    }
}
