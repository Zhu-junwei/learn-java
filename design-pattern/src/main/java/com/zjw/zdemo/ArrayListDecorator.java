package com.zjw.zdemo;

import java.util.ArrayList;

/**
 * @author jw
 * @since 2025/04/28 03:33
 */
public class ArrayListDecorator<E> extends ArrayList<E> {

    @Override
    public boolean add(E e) {
        System.out.println("向集合中添加元素");
        return super.add(e);
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayListDecorator<>();
        list.add("a");
        list.add("b");
        System.out.println(list);
    }
}
