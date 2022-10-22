package com.zjw.list;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * 原先文章：<a>https://www.cnblogs.com/zjw-blog/p/13727231.html</a>
 * @author 朱俊伟
 * @date 2022/04/20 14:47
 */
public class ListTest {

    public List<String> files = new ArrayList<>();

    @Before
    public void before(){
        files.add("123");
        files.add("456");
        files.add("456");
    }

    /**
     * listIterator使用 从前往后遍历集合
     */
    @Test
    public void next(){
        ListIterator<String> iterator = files.listIterator();
        while (iterator.hasNext()){
            int index = iterator.nextIndex();
            String next = iterator.next();
            System.out.println(index + "-->" + next);
        }
    }

    /**
     * listIterator使用 从后往前遍历集合
     */
    @Test
    public void previous(){
        ListIterator<String> iterator = files.listIterator(files.size());
        while (iterator.hasPrevious()){
            int index = iterator.previousIndex();
            String previous = iterator.previous();
            System.out.println(index + "-->" + previous);
        }
    }

    /**
     * 集合转为数组
     */
    @Test
    public void toArray(){
        Object[] objects = files.toArray();
        System.out.println(Arrays.toString(objects));
    }

    /**
     * 集合中是否包含某些元素
     */
    @Test
    public void contains(){
        String o = "123";
        System.out.println(files.contains(o));
        o = "111";
        System.out.println(files.contains(o));
    }


    /**
     * containsAll方法
     * 集合中是否包含另外一个集合中所有元素，包含返回true,有不包含的返回false
     * @param list 集合
     */
    public void containsAll(List<String> list){
        //另外一个集合
        List<String> containsList = new ArrayList<>();
        containsList.add("123");
        containsList.add("1");

        boolean contains = list.containsAll(containsList);
        System.out.println(contains);
    }

    /**
     * 测试 集合中是否包含另外一个集合中所有元素
     */
    @Test
    public void testContainsAll(){
        //缺少"1"结果为false
        containsAll(files);
        files.add("1");
        //添加"1"后结果为true
        containsAll(files);
    }

    /**
     * 测试 取得索引出处的元素，索引从0开始
     */
    @Test
    public void testGet(){
        String s = files.get(0);
        System.out.println(s);
    }

    /**
     * 使用foreach遍历集合
     * <b>不能在遍历的时候删除元素</b>
     */
    @Test
    public void testForEach(){
        for (String s : files) {
            System.out.println(s);
        }
    }

    /**
     * 使用迭代器Iterator遍历集合
     */
    @Test
    public void testIterator(){
        Iterator<String> iterator = files.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    /**
     * 使用迭代器Iterator遍历集合,在遍历的过程中对集合修改
     */
    @Test
    public void testIteratorRemove(){
        String remove = "123";
        System.out.println(files);
        Iterator<String> iterator = files.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            if (remove.equals(next)){
                iterator.remove();
            }
        }
        System.out.println(files);
    }

    /**
     * 使用removeIf方法移除符合条件的元素
     */
    @Test
    public void testListRemove(){
        String filter = "456";
        System.out.println(files);
        files.removeIf(filter::equals);
        System.out.println(files);
    }

    /**
     * 测试从集合中删除包含在另一个集合中的元素
     */
    @Test
    public void testRemoveAll(){
        List<String> removeList = new ArrayList<>();
        removeList.add("456");
        System.out.println(files);
        files.removeAll(removeList);
        System.out.println(files);
    }
}