package com.zjw.lambda;

import java.text.Collator;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * lambda表达式 中文按照排序拼音排序
 * @author 朱俊伟
 * @since 2022/04/01 0:15
 */
public class SortChinaTest {
    public static void main(String[] args) {

        /*
         (p1, p2) -> Collator.getInstance(Locale.CHINA).compare(o1.getName(), o2.getName()) 排序规则，根据汉字的拼音来排序（升序）
         */
        List<String> names = Arrays.asList("张文芳", "李慧敏", "周勇", "王晓风", "刘航", "马天鹏");
        Stream<Person> stream = names.stream().map(Person::new);
        List<Person> personList = stream.collect(Collectors.toList());
        System.out.println(personList);
        personList.sort((p1, p2) -> Collator.getInstance(Locale.CHINA).compare(p1.getName(), p2.getName()));
        System.out.println(personList);
    }

}


