package com.zjw.lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * 综合实例
 */
public class Lambda06
{
    public static void main(String[] args) {

        List<Dog> list = new ArrayList<>();
        list.add(new Dog("aa",1));
        list.add(new Dog("aa",5));
        list.add(new Dog("aa",3));
        list.add(new Dog("aa",4));
        list.add(new Dog("aa",2));

        //lambda 排序
        list.sort((dog1,dog2)->dog2.getAge()-dog1.getAge());
        System.out.println(list);

        //lambda 遍历
        list.forEach(System.out::println);

        //删除年龄大于3的
        list.removeIf(dog -> dog.getAge()>3);
        list.forEach(System.out::println);

    }
}