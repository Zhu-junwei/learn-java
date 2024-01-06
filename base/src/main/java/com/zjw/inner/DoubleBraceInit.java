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
        ArrayList<String> friend = new ArrayList<>();
        friend.add("Harry");
        friend.add("Tony");
//        invite(friend);

        //外层括号建立了ArrayList的一个匿名子类。 内层括号则是一个对象构造块。
        invite(new ArrayList<String>(){
            {
                add("Harry");
                add("Tony");
            }
        });

    }

    public static void invite(List list){
        System.out.println(list);
    }
}
