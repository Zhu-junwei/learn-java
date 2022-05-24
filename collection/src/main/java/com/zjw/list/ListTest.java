package com.zjw.list;

import java.util.*;

/**
 * 原先文章：<a>https://www.cnblogs.com/zjw-blog/p/13727231.html</a>
 * @author 朱俊伟
 * @date 2022/04/20 14:47
 */
public class ListTest {
    public static void main(String[] args) {

        List<String> files = new ArrayList<>();
        files.add("123");
        files.add("456");
        files.add("456");
        testNext(files);
//        testPrevious(files,files.size());
//        testToArray(files);
//        testContains(files,"123");
//        testContainsAll(files);
//        testGet(files,1);
//        testForEach(files);
//        testIterator(files);
//        testIteratorRemove(files,"456");
//        testListRemove(files,"456");
    }

    /**
     * listIterator使用 从前往后遍历集合
     * @param list 集合
     */
    public static void testNext(List<String> list){
        ListIterator<String> iterator = list.listIterator();
        while (iterator.hasNext()){
            int index = iterator.nextIndex();
            String next = iterator.next();
            System.out.println(index + "-->" + next);
        }
    }

    /**
     * listIterator使用 从后往前遍历集合
     * @param list 集合
     */
    public static void testPrevious(List<String> list,int ind){
        ListIterator<String> iterator = list.listIterator(ind);
        while (iterator.hasPrevious()){
            int index = iterator.previousIndex();
            String previous = iterator.previous();
            System.out.println(index + "-->" + previous);
        }
    }

    /**
     * 集合转为数组
     * @param list 集合
     */
    public static void testToArray(List<String> list){
        Object[] objects = list.toArray();
        System.out.println(Arrays.toString(objects));
    }

    /**
     * 集合中是否包含某些元素
     * @param list 集合
     * @param o 元素
     */
    public static void testContains(List<String> list,String o){
        boolean contains = list.contains(o);
        System.out.println(contains);
    }

    /**
     * containsAll方法
     * 集合中是否包含另外一个集合中所有元素，包含返回true,有不包含的返回false
     * @param list 集合
     */
    public static void testContainsAll(List<String> list){
        //另外一个集合
        List<String> containsList = new ArrayList<>();
        containsList.add("123");
        containsList.add("1");

        boolean contains = list.containsAll(containsList);
        System.out.println(contains);
    }

    /**
     * 取得索引出处的元素，索引从0开始
     * @param list 集合
     * @param index 索引
     */
    public static void testGet(List<String> list,int index){
        String s = list.get(index);
        System.out.println(s);
    }

    /**
     * 使用foreach遍历集合，
     * <b>不能在遍历的时候删除元素</b>
     * @param list 集合
     */
    public static void testForEach(List<String> list){
        for (String s : list) {
            System.out.println(s);
        }
    }

    /**
     * 使用迭代器Iterator遍历集合
     * @param list 集合
     */
    public static void testIterator(List<String> list){
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    /**
     * 使用迭代器Iterator遍历集合,在遍历的过程中对集合修改
     * @param list 集合
     */
    public static void testIteratorRemove(List<String> list,String remove){
        System.out.println(list);
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            if (remove.equals(next)){
                iterator.remove();
            }
        }
        System.out.println(list);
    }

    /**
     * 使用removeIf方法移除符合条件的元素
     * @param list 集合
     * @param filter 待移除的元素
     */
    public static void testListRemove(List<String> list,String filter){
        System.out.println(list);
        list.removeIf(filter::equals);
        System.out.println(list);
    }
}
