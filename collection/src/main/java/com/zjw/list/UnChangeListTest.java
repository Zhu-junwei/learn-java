package com.zjw.list;

import org.junit.Test;

import java.util.List;

/**
 * 不可变List集合测试
 * 		不可以修改、添加、删除
 * @author 朱俊伟
 * @date 2023/07/23 9:34
 */
public class UnChangeListTest {

    /**
     * 创建不可变List集合
     */
    @Test
    public void createUnChangeList(){
        List<String> list = List.of("A", "B", "C");
        System.out.println(list);
    }

    /**
     * 尝试修改不可变List集合
     * 		抛出异常 java.lang.UnsupportedOperationException
     */
    @Test
    public void modifyUnChangeList(){
        List<String> list = List.of("A", "B", "C");
        System.out.println(list);
        list.set(0,"aa");
    }

    /**
     * 尝试添加不可变List集合
     * 		抛出异常 java.lang.UnsupportedOperationException
     */
    @Test
    public void addUnChangeList(){
        List<String> list = List.of("A", "B", "C");
        System.out.println(list);
        list.add("dd");
    }

    /**
     * 尝试删除不可变List集合中的元素
     * 		抛出异常 java.lang.UnsupportedOperationException
     */
    @Test
    public void deleteUnChangeList(){
        List<String> list = List.of("A", "B", "C");
        System.out.println(list);
        list.remove(0);
    }

}
