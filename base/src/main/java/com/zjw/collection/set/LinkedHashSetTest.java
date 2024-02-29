package com.zjw.collection.set;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author 朱俊伟
 * @since 2024/01/02 19:57
 */
public class LinkedHashSetTest {

    /**
     * LinkedHashSet保证取出的顺序和插入的顺序一致
     */
    @Test
    public void test1(){
        Set<Integer> set = new LinkedHashSet<>();
        set.add(1);
        set.add(3);
        set.add(5);
        set.add(4);
        set.add(0);
        Iterator<Integer> iterator = set.stream().iterator();
        // [1, 3, 5, 4, 0]
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println(set);//[1, 3, 5, 4]
    }
}
