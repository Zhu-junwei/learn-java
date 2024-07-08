package com.feature.java16.record;

/**
 * 记录紧凑构造器（ compact constructor）
 * @author 朱俊伟
 * @since 2024/07/06 18:10
 */
public class RecordDemo4 {
    public static void main(String[] args) {
        Point p = new Point(1, 2);
        System.out.println(p);
        Point p2 = new Point(-1, 2); // IllegalArgumentException: negative
        System.out.println(p2);
    }
}

record Point(int x, int y) {

    // 验证参数的方法
    void assertPositive(int val) {
        if(val < 0)
            throw new IllegalArgumentException("negative");
    }

    /*
        紧凑：没有参数列表
        紧凑构造器，紧凑构造器中的代码运行在所有字段初始化之后。
        通常用于验证参数，也可以修改字段的初始化值
     */
    Point { //
        assertPositive(x);
        assertPositive(y);
    }
}