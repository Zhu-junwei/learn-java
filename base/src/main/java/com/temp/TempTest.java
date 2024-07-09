package com.temp;

import java.util.Random;

/**
 * @author 朱俊伟
 * @since 2024/03/20 22:11
 */
public class TempTest {

    public static void main(String[] args){
        new Random(7)
                .ints(2,100)
                .distinct()
                .limit(10)
                .sorted()
                .forEach(System.out::println);
    }
}