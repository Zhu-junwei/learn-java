package com.zjw.collection.set;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author zjw
 * @date 2023/07/07 15:46
 */
public class SetTest {

    /**
     * 测试TreeSet
     */
    @Test
    public void testTreeSet() {
        Set<String> sortSet = new TreeSet<String>((o1, o2) -> o1.compareTo(o2));
        sortSet.add("1");
        sortSet.add("2");
        sortSet.add("5");
        sortSet.add("4");
        System.out.println(sortSet);//[1, 2, 4, 5]
        sortSet = new TreeSet<String>((o1, o2) -> o2.compareTo(o1));
        sortSet.add("1");
        sortSet.add("2");
        sortSet.add("5");
        sortSet.add("4");
        System.out.println(sortSet);//[5, 4, 2, 1]
    }

    /**
     * 测试TreeSet
     */
    @Test
    public void testSet() {
        Set<String> set = new HashSet<>();
        set.add("1");
        set.add("2");
        set.add("5");
        set.add("4");
        set.add("6");
        set.add("9");
        set.add("10");
        set.add("8");
        System.out.println(set);//[1, 2, 4, 5]
    }


}
