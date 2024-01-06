package com.zjw.inner;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 静态内部类 通过遍历一遍数组获取最大值和最小值
 * @author 朱俊伟
 * @since 2022/04/02 2:24
 */
public class StaticInnerClassTest {
    public static void main(String[] args) {
        double[] d = new double[20];
        for (int i = 0; i < d.length; i++) {
            d[i] = 100 * Math.random();
        }
        ArrayAlg.Pair pair = ArrayAlg.minmax(d);
        System.out.println("min = " + pair.getFirst());
        System.out.println("max = " + pair.getSecond());
    }
}

class ArrayAlg{

    public static Pair minmax(double[] values){
        double min = Double.POSITIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;
        for (double v : values) {
            if (min > v) min = v;
            if (max < v) max = v;
        }
        return new Pair(min,max);
    }

    /**
     * 与常规内部类不同，静态内部类可以有静态域和方法。
     */
    @Getter
    @AllArgsConstructor
    public static class Pair{
        private double first;
        private double second;
    }
}