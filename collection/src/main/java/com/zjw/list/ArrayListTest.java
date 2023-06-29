package com.zjw.list;


import org.junit.Test;

import java.util.*;

/**
 * 测试 ArrayList
 * @author 朱俊伟
 * @date 2022/08/15
 */
public class ArrayListTest {

    /**
     * 测试添加元素add()
     */
    @Test
    public void testAdd(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list);
    }

    /**
     * 添加元素到指定位置
     */
    @Test
    public void testAddIndex(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println("添加前:" + list);
        list.add(1,"d");//其位置元素先后移
        System.out.println("添加后:" + list);
    }

    /**
     * 测试setet()
     */

    /**
     * 测试删除单个首次出现的元素
     */
    @Test
    public void testRemove(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println("删除前:" + list);
        list.remove("a");//只会删除第一个出现的元素
        System.out.println("删除后:" + list);
    }

    /**
     * 测试删除所有指定的元素
     */
    @Test
    public void testRemoveAll(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println("删除前:" + list);
        list.removeAll(Arrays.asList("a","b"));//删除除所有指定的元素
        System.out.println("删除后:" + list);
    }

    /**
     * 删除指定位置的元素
     */
    @Test
    public void testRemoveIndex(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println("删除前:" + list);
        list.remove(1);//删除指定位置上的元素
        System.out.println("删除后:" + list);
    }

    /**
     * 测试get() 返回列表中指定位置的元素
     */
    @Test
    public void testGet(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list.get(0));
    }

    /**
     * 判断集合是否为空
     */
    @Test
    public void testEmpty(){
        List<String> list = new ArrayList<>();
        System.out.println(list.isEmpty());
        list.add("a");
        System.out.println(list.isEmpty());
    }

    /**
     * 清空集合
     */
    @Test
    public void testClear(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println("清空前:" + list);
        list.clear();//添加前: [a, b, c]
        System.out.println("清空后:" + list);
        System.out.println("清空后:" + list.size());
    }

    /**
     * 获取集合的大小
     */
    @Test
    public void testSize(){
        List<String> list = new ArrayList<>();
        System.out.println(list.size());
        list.add("a");
        System.out.println(list.size());
    }

    /**
     * 判断是否包含某个元素
     */
    @Test
    public void testContains(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list.contains("a"));
        System.out.println(list.contains("d"));
    }

    /**
     * 判断元素在集合中首次出现的位置
     */
    @Test
    public void testIndexOf(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        //返回指定元素在此列表中第一次出现的索引，如果此列表不包含该元素，则返回-1
        System.out.println(list.indexOf("a"));//0
        System.out.println(list.indexOf("d"));//-1
    }

    /**
     * 判断元素在集合中最后出现的位置
     */
    @Test
    public void testLastIndexOf(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("a");
        list.add("b");
        list.add("c");
        //返回指定元素在此列表中最后出现的索引，如果此列表不包含该元素，则返回-1
        System.out.println(list.lastIndexOf("a"));//1
        System.out.println(list.lastIndexOf("d"));//-1
    }

    /**
     * 测试subList，返回指定范围内的集合
     */
    @Test
    public void testSubList(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        System.out.println(list);
        List<String> subList = list.subList(1,3);//返回指定范围内的集合
        System.out.println(subList);
    }

    /**
     * 测试数组转List集合 Arrays.asList(T... a)
     */
    @Test
    public void testArrayToList(){
        String[] strings = {"a","b","c"};
        //要求参数不能为空
        List<String> list = Arrays.asList(strings);
        System.out.println(list);
    }

    /**
     * 测试数组转List集合
     *
     */
    @Test
    public void testArrayToList2(){
        String[] strings = {"a","b","c"};
        List<String> list = transferArrayToList(strings);
        System.out.println(list);
        String[] remove = {"a","b"};
        List<String> removeList = Arrays.asList(remove);
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
