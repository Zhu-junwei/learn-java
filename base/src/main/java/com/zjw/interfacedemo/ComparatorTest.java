package com.zjw.interfacedemo;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Comparator接口
 * Arrays.sort排序时使用自定义比较器
 * @author 朱俊伟
 * @date 2022/03/31 1:02
 */
public class ComparatorTest {
    public static void main(String[] args) {
        String[] friends = {"He", "Peter", "Paul", "Mary"};
        //比较器对象
        LengthComparator comparator = new LengthComparator();
        Arrays.sort(friends,comparator);
        System.out.println(Arrays.toString(friends));
    }
}

/**
 * 比较器 根据长度比较字符串
 */
class LengthComparator implements Comparator<String>{
    @Override
    public int compare(String first, String second) {
        return first.length() - second.length();
    }
}
