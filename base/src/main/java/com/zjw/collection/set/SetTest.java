package com.zjw.collection.set;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zjw
 * @date 2023/07/07 15:46
 */
public class SetTest {

    /**
     * HashSet是无序的，不允许重复
     * 测试TreeSet
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


}
