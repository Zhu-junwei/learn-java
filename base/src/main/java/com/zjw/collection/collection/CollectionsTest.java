package com.zjw.collection.collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collections工具类的使用
 */
public class CollectionsTest {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(23);
        list.add(4);
        list.add(45);
        list.add(76);
        list.add(12);
        System.out.println("原始集合：" + list);

        //排序
        Collections.sort(list); //升序
        System.out.println("排序后：" + list);

        //排序后可以二分查找
        int index = Collections.binarySearch(list, 45);//查找位置，没有找到结果为负
        System.out.println(index);

        //拷贝
        //需要拷贝到的目的集合要先有数据，才能拷贝
        List<Integer> dest = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            dest.add(0);
        }
        Collections.copy(dest, list);
        System.out.println("拷贝后的集合：" + dest);

        //反转
        Collections.reverse(list);
        System.out.println("反转后：" + list);

        //打乱
        Collections.shuffle(list);
        System.out.println("打乱后：" + list);
        Collections.shuffle(list);
        System.out.println("打乱后：" + list);

        //最大，最小
        Integer max = Collections.max(list);
        System.out.println("最大：" + max);
        Integer min = Collections.min(list);
        System.out.println("最小：" + min);

        //使用指定元素替换集合中的所有元素
        Collections.fill(list, 0);
        System.out.println("元素填充后：" + list);

    }

    /**
     * 测试向一个集合中添加数组元素
     */
    @Test
    public void testAddAll() {
        String[] strings = {"a", "b", "c", null};

        List<String> list1 = new ArrayList<>();
        Collections.addAll(list1, strings);  // modifiable List，这种方法更容易理解
        list1.add("d");
        Collections.addAll(list1, "e", "f");
        System.out.println("list1 = " + list1);
    }

}
 