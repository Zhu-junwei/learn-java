package com.zjw.collection.set;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 *  TreeSet是有序的
 * <p>
 * - 基于排列顺序实现元素不重复
 * <p>
 * - 实现了SortedSet接口，对集合元素自动排序
 * <p>
 * - 元素对象的类型必须实现Comparable接口，指定排序规则
 * <p>
 * - 通过CompareTo方法确定是否为重复元素
 *
 * @author 朱俊伟
 * @since 2024/01/02 19:51
 */
public class TreeSetTest {

    /**
     * TreeSet是有序的
     */
    @Test
    public void testTreeSet() {
        Set<String> sortSet = new TreeSet<>();
        sortSet.add("1");
        sortSet.add("2");
        sortSet.add("5");
        sortSet.add("4");
        System.out.println(sortSet);//[1, 2, 4, 5]

        // 自定义比较器
        sortSet = new TreeSet<>(Comparator.reverseOrder());
        sortSet.add("1");
        sortSet.add("2");
        sortSet.add("5");
        sortSet.add("4");
        System.out.println(sortSet);//[5, 4, 2, 1]
    }
}
