package com.zjw.collection.set;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zjw
 * @since 2023/07/07 15:46
 */
public class HashSetTest {

    /**
     * HashSet是无序的，不允许重复
     */
    @Test
    public void testSet() {
        Set<String> set = new HashSet<>();
        set.add("1");
        set.add("2");
        set.add("2");
        set.add("5");
        set.add("4");
        set.add("6");
        set.add("9");
        set.add("11");
        set.add("10");
        set.add("8");
        System.out.println(set);//[11, 1, 2, 4, 5, 6, 8, 9, 10]
    }

    /**
     * 两个集合取 交集
     */
    @Test
    public void retainAllTest(){
        Set<String> set1 = new HashSet<>();
        set1.add("1");
        set1.add("2");
        set1.add("5");
        Set<String> set2 = new HashSet<>();
        set2.add("1");
        set2.add("5");
        set2.add("8");
        set1.retainAll(set2); // set1 中只保留 set2 中也存在的元素
        System.out.println(set1); // [1, 5]
        System.out.println(set2); // [1, 5, 8]
    }

    /**
     * 差集
     */
    @Test
    public void removeAllTest(){
        Set<String> set1 = new HashSet<>();
        set1.add("1");
        set1.add("2");
        set1.add("5");
        Set<String> set2 = new HashSet<>();
        set2.add("1");
        set2.add("5");
        set2.add("8");
        set1.removeAll(set2); // set1 删除 set2 中也存在的元素
        System.out.println(set1); // [2]
        System.out.println(set2); // [1, 5, 8]
    }

    /**
     * 并集
     */
    @Test
    public void addAllTest(){
        Set<String> set1 = new HashSet<>();
        set1.add("1");
        set1.add("2");
        set1.add("5");
        Set<String> set2 = new HashSet<>();
        set2.add("1");
        set2.add("5");
        set2.add("8");
        set1.addAll(set2); // set1 添加 set2 中所有的元素
        System.out.println(set1); // [1, 2, 5, 8]
        System.out.println(set2); // [1, 5, 8]
    }

}
