package com.zjw.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 朱俊伟
 * @date 2023/07/23 23:20
 */
public class StreamListTest {

    /**
     *
     */
    @Test
    public void streamListTest(){
        /*
         * 创建集合添加元素，完成以下需求:
         * 	1.把所有以“张”开头的元素存储到新集合中
         * 	2.把“张”开头的，长度为3的元素再存储到新集合中
         * 	3.遍历打印最终结果
         */
        ArrayList<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");
		//1.把所有以“张”开头的元素存储到新集合中
        List<String> list2 = new ArrayList<>();
        for (String str : list) {
            if (str.startsWith("张"))
            	list2.add(str);
        }
        System.out.println(list2);
        list.stream().filter(str -> str.startsWith("张")).forEach(str -> System.out.println(str));
//        System.out.println(list22);
        //2.把“张”开头的，长度为3的元素再存储到新集合中
        List<String> list3 = new ArrayList<>();
        for (String str : list2) {
            if (str.length() == 3)
                list3.add(str);
        }
        System.out.println(list3);

    }
}
