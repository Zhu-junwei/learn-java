package com.zjw.generic;

import java.time.LocalDate;

/**
 * 泛型类和泛型方法使用
 * @author 朱俊伟
 * @since 2022/04/27 14:23
 */
public class PairTest {
    public static void main(String[] args) {

        String middle = ArrayAlg.getMiddle("John", "Q.", "a");
        System.out.println(middle);
        Integer middle1 = ArrayAlg.getMiddle(1, 45, 6, 2, 34);
        System.out.println(middle1);

        String[] words = {"Mary", "had", "a", "little", "lamb"};
        Pair<String> stringPair = ArrayAlg.minmax(words);
        System.out.println("min = " + stringPair.getFirst());
        System.out.println("max = " + stringPair.getSecond());

        Integer[] ints = {34, 123, 8, 93, -1};
        Pair<Integer> integerPair = ArrayAlg.minmax(ints);
        System.out.println("min = " + integerPair.getFirst());
        System.out.println("max = " + integerPair.getSecond());

        LocalDate[] birthdays = {
                LocalDate.of(1906, 12, 9),
                LocalDate.of(1815, 12, 10),
                LocalDate.of(1903, 12, 3),
                LocalDate.of(1910, 6, 22),
        };
        Pair<LocalDate> mm = ArrayAlg.minmax(birthdays);
        System.out.println("min = " + mm.getFirst());
        System.out.println("max = " + mm.getSecond());


        System.out.println(stringPair.getClass());//class com.zjw.generic.Pair
        System.out.println(integerPair.getClass());//class com.zjw.generic.Pair
        System.out.println(stringPair.getClass() == integerPair.getClass());//true

        /**
         * 不能创建参数化类型的数组(不能创建泛型数组)
         */
//        Pair<String>[] table = new Pair<String>[10];//Error


    }
}
