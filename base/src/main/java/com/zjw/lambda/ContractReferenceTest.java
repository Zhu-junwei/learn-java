package com.zjw.lambda;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.Collator;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * lambda表达式 构造器引用
 *
 * @author 朱俊伟
 * @since 2022/03/31 21:03
 */
public class ContractReferenceTest {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("张文芳", "李慧敏", "周勇", "王晓风", "刘航", "马天鹏");
        //调用Person(String)构造器
        List<Person> personList = names.stream().map(Person::new).toList();
        System.out.println(personList);

        //创建Object数组
        Object[] people = names.toArray();
        System.out.println(Arrays.toString(people));

        //创建Person数组
        Person[] peopleArr = names.stream().map(Person::new).toArray(Person[]::new);
        System.out.println(Arrays.toString(peopleArr));

         /*
         (p1, p2) -> Collator.getInstance(Locale.CHINA).compare(o1.getName(), o2.getName()) 排序规则，根据汉字的拼音来排序（升序）
         */
        Stream<Person> stream = names.stream().map(Person::new);
        personList = stream.collect(Collectors.toList());
        System.out.println(personList);
        personList.sort((p1, p2) -> Collator.getInstance(Locale.CHINA).compare(p1.getName(), p2.getName()));
        System.out.println(personList);

    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Person {
    private String name;
}


