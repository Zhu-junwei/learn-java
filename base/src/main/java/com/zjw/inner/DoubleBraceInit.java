package com.zjw.inner;

import java.util.ArrayList;
import java.util.List;

/**
 * 双括号初始化
 * @author 朱俊伟
 * @since 2022/04/02 2:04
 */
public class DoubleBraceInit {
    public static void main(String[] args) {
        //外层括号建立了ArrayList的一个匿名子类。 内层括号则是一个对象构造块。
        ArrayList<String> friend = new ArrayList<>() {{
            add("Harry");
            add("Tony");
        }};
        invite(friend);
    }

    public static <T> void invite(List<T> list){
        System.out.println(list);
    }
}
