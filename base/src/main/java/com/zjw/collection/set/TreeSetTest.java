package com.zjw.collection.set;

import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author 朱俊伟
 * @since 2024/01/02 19:51
 */
public class TreeSetTest {

    /**
     * TreeSet是有序的
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
}
