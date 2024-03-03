package com.zjw.arrays;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 数组扩容
 *
 * @author 朱俊伟
 * @since 2022/07/12
 */
public class ArraysTest {

    /**
     * 测试copyOf方法，将指定数组的内定拷过去
     */
    @Test
    public void testCopyOf() {
        Object[] obj1 = new Object[5];
        obj1[0] = 12;
        obj1[3] = "aaa";
        obj1[4] = "bbb";
        //原数组指向扩容后的数组
        obj1 = Arrays.copyOf(obj1, obj1.length + 2);
        System.out.println(Arrays.toString(obj1));
        //数组扩容后大小为7
        System.out.println(obj1.length);
    }

    /**
     * 拷贝数组的一部分
     */
    @Test
    public void testCopyOfRange() {
        int[] a = new int[] {5,6,4,1,3,2};
		int[] b = Arrays.copyOf(a, 3);
        int[] c = Arrays.copyOfRange(a, 2, a.length);
        System.out.println(Arrays.toString(a)); // [5, 6, 4, 1, 3, 2]
        System.out.println(Arrays.toString(b)); // [5, 6, 4]
        System.out.println(Arrays.toString(c)); // [4, 1, 3, 2]
    }

    /**
     * 测试sort排序，升序
     */
    @Test
    public void testSort() {
        int[] age = new int[10];
        for (int i = 0; i < age.length; i++) {
            age[i] = (int) (Math.random() * 100);
        }
        System.out.println("排序前:" + Arrays.toString(age));//排序前:[10, 66, 29, 81, 14, 67, 1, 39, 28, 35]
        Arrays.sort(age);
        System.out.println("排序后:" + Arrays.toString(age));//排序后:[1, 10, 14, 28, 29, 35, 39, 66, 67, 81]
    }

    /**
     * 测试使用二分搜索算法在指定的整型数组中搜索指定的值
     * binarySearch(int[] a, int key)
     */
    @Test
    public void testBinarySearch() {
        // 创建一个长度为10的整型数组age
        int[] age = new int[10];
        int searchTemp = 0;
        for (int i = 0; i < age.length; i++) {
            searchTemp = (int) (Math.random() * 100);
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

    /**
     * 测试fill方法，将指定的元素填充到数组中
     */
    @Test
    public void testFill() {
        int[] age = new int[10];
        Arrays.fill(age, 10);
        System.out.println(Arrays.toString(age));//[10, 10, 10, 10, 10, 10, 10, 10, 10, 10]
    }

    /**
     * 测试stream方法，将数组转换为流对象
     */
    @Test
    public void testStream() {
        Integer[] numbers = {1, 2, 3, 4, 5};
        // 将数组转换为流
        Stream<Integer> stream = Arrays.stream(numbers);
        // 对流进行操作，例如筛选偶数并打印
        stream.filter(n -> n % 2 == 0)
                .forEach(System.out::println);
    }

    /**
     * 测试asList方法，将数组装换为List集合
     */
    @Test
    public void testAsList() {
        Integer[] numbers = {1, 2, 3, 4, 5};
        // 将数组装换为List集合
        List<Integer> list = Arrays.asList(numbers);
        System.out.println(list);

        //基本数据类型
        int[] nums = {1, 2, 3};
        //由于不支持基本数据类型的数组，所以会把nums数组作为一个元素转为list，list的大小为1
        List<Object> numsList = Arrays.asList(nums);
        System.out.println(numsList.size());//1
        System.out.println(numsList);//[[I@1888ff2c]
    }

}
