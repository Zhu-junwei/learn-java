package com.zjw.generic;

/**
 * 定义泛型方法
 * @author 朱俊伟
 * @since 2022/04/21 14:56
 */
public class ArrayAlg {

    /** 泛型方法
     */
    @SafeVarargs
    public static <T> T getMiddle(T... a){
        return a[a.length / 2];
    }

    /**
     * 找出数组中的最大值和最小值
     * @param a 数组
     * @return Pair，包含最大值和最小值
     */
    public static <T extends Comparable> Pair<T> minmax(T[] a){
        if (a == null || a.length == 0) return null;
        T min = a[0];
        T max = a[0];
        for (T s : a) {
            if (min.compareTo(s) > 0) min = s;
            if (max.compareTo(s) < 0) max = s;
        }
        return new Pair<>(min,max);
    }
    
}
