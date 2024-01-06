package com.zjw.collection.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 比较ArrayList和LinkedList的插入速度对比
 * 来源 https://mp.weixin.qq.com/s/KuJcWOlcCS2YfyKcBMePnw
 * @author 朱俊伟
 * @since 2021/12/22
 */
public class YesArrayLinkedBattle {

    private static final int COUNT = 100000;

    static List<Integer> fillList(List<Integer> list) {
        for (int i = 0; i < COUNT; i++) {
            list.add(i); //将list填满，假装我们在数据库里得到这么多数据
        }
        return list;
    }

    static void randomAdd(List<Integer> list, String listType) {
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            list.add(ThreadLocalRandom.current().nextInt(0,COUNT), i);
        }
        long t2 = System.currentTimeMillis();
        System.out.println(listType +"随机位置插入" + COUNT + "次耗时：" + (t2-t1));
    }

    public static void main(String[] args) {

        randomAdd(fillList(new ArrayList<>(COUNT)), "数组");

        randomAdd(fillList(new LinkedList<>()), "链表");

    }
}
