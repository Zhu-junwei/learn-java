package com.zjw.arrays;

import org.junit.Test;

import java.util.Arrays;

/**
 * 数组扩容
 * @author 朱俊伟
 * @date 2022/07/12
 */
public class ArraysTest {
    public static void main(String[] args) {
        Object[] obj1 = new Object[5];
        obj1[0] = 12;
        obj1[3] = "aaa";
        obj1[4] = "bbb";
        //原数组指向扩容后的数组
        obj1 = Arrays.copyOf(obj1,obj1.length+2);
        System.out.println(Arrays.toString(obj1));
        //数组扩容后大小为7
        System.out.println(obj1.length);
    }

    /**
     * 测试排序
     */
    @Test
    public void testSort(){
        int age[] = new int[10];
        for (int i = 0; i < age.length; i++) {
            age[i] = (int) (Math.random()*100);
        }
        System.out.println("排序前:" + Arrays.toString(age));
        Arrays.sort(age);
        System.out.println("排序后:" + Arrays.toString(age));
    }

    /**
     * 测试使用二分搜索算法在指定的整型数组中搜索指定的值
     * binarySearch(int[] a, int key)
     */
    @Test
    public void testSap(){
        // 创建一个长度为10的整型数组age
        int age[] = new int[10];
        int searchTemp = 0;
        for (int i = 0; i < age.length; i++) {
            searchTemp = (int) (Math.random()*100);
            age[i] = searchTemp;
        }
        // 使用搜索算法前需要对数组进行排序
        Arrays.sort(age);
        System.out.println("数组:" + Arrays.toString(age));
        // 查找元素在数组中的位置
        int index = Arrays.binarySearch(age, searchTemp);
        System.out.println(searchTemp + " at index " + index);
        // 不存在的元素返回 -(插入点)-1，为了保证不存在的元素返回的都是负数
        index = Arrays.binarySearch(age, 18);
        System.out.println(18 + " at index " + index);
    }


}
