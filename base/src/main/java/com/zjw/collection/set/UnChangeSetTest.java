package com.zjw.collection.set;

import org.junit.jupiter.api.Test;

import java.util.Set;

/**
 * 不可变Set集合测试
 * 		不可以修改、添加、删除
 * @author 朱俊伟
 * @since 2023/07/23 22:37
 */
public class UnChangeSetTest {

    /**
     * 创建不可变Set集合
     */
    @Test
    public void createUnChangeSet(){
        Set<String> set = Set.of("A", "B", "C");
        System.out.println(set);

        //需要注意的是创建不可变Set集合的元素不能重复
        //java.lang.IllegalArgumentException: duplicate element: C
//        Set<String> set2 = Set.of("A", "B", "C", "C");
    }

    /**
     * 尝试添加不可变Set集合
     * 		抛出异常 java.lang.UnsupportedOperationException
     */
    @Test
    public void addUnChangeSet(){
        Set<String> set = Set.of("A", "B", "C");
        System.out.println(set);
        set.add("d");
    }

    /**
     * 尝试删除不可变Set集合中的元素
     * 		抛出异常 java.lang.UnsupportedOperationException
     */
    @Test
    public void deleteUnChangeSet(){
        Set<String> set = Set.of("A", "B", "C");
        System.out.println(set);
        set.remove("A");
    }
}
