package com.zjw.list;


import org.junit.Test;

import java.util.*;

/**
 * @author 朱俊伟
 * @date 2022/08/15
 */
public class ArrayListTest {

    public static void main(String[] args) {
        Map<String,List<String>> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add("a");
        map.put("1",list);
        map.get("1").add("b");
        System.out.println(map);
        System.out.println(map.get("11"));
    }

    /**
     * 测试数组转List集合
     */
    @Test
    public void testTransferArrayToList(){
        String[] strings = {"a","b","c"};
        List<String> list = transferArrayToList(strings);
        String[] remove = {"a","b"};
        List<String> removeList = new ArrayList<>();
        list.removeAll(removeList);
        System.out.println(list);
    }

    /**
     * 数组转List集合
     * @param array 数组
     * @param <E> 泛型
     * @return List集合
     */
    public static <E>  List<E> transferArrayToList(E[] array){
        List<E> transferList = new ArrayList<>();
        Arrays.stream(array).forEach(arr -> transferList.add(arr));
        return transferList;
    }
}
