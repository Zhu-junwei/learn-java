package com.temp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author 朱俊伟
 * @since 2024/03/20 22:11
 */
public class TempTest {

    public static void main(String[] args){
        RandomList<String> randomList = new RandomList<>();
        randomList.addAll(Arrays.asList("a b c d e f g h i".split(" ")));
        IntStream.range(0, randomList.size()).forEach(i -> System.out.println(randomList.select()));
    }
}

class RandomList<T> extends ArrayList<T> {
    private Random random = new Random();

    public T select() {
        return get(random.nextInt(size()));
    }
}