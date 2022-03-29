package com.zjw.reflection;

import java.util.ArrayList;

/**
 * 利用反射获取对象的属性信息 测试
 * @author 朱俊伟
 * @date 2022/03/30 0:06
 */
public class ObjectAnalyzerTest {
    public static void main(String[] args) {
        ArrayList<Integer> squares = new ArrayList<>();
        for (int i = 1; i <= 5; i++){
            squares.add(i * i);
        }
        System.out.println(squares);
        System.out.println(new ObjectAnalyzer().toString(squares));
    }
}
