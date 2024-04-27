package com.zjw.lambda;


import java.util.Arrays;
import java.util.List;

/**
 * lambda表达式 构造器引用
 * Java核心技术卷Ⅰ（第十版） page 237 还不是太理解，学完卷Ⅱ第一章再看吧
 * @author 朱俊伟
 * @since 2022/03/31 21:03
 */
public class ContractReferenceTest {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("a","b","c");
        //调用Person(String)构造器
        List<Person> personList = names.stream().map(Person::new).toList();
        System.out.println(personList);

        //创建Object数组
        Object[] people = names.stream().toArray();
        System.out.println(Arrays.toString(people));

        //创建Person数组
        Person[] peopleArr = names.stream().map(Person::new).toArray(Person[]::new);
        System.out.println(Arrays.toString(peopleArr));

    }
}

