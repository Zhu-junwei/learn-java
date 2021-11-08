package com.zjw.Object;

/**
 * @author 朱俊伟
 * @date 2021/09/17
 */
public class TestObject {
    public static void main(String[] args) {
        Object[] obs = new Object[2];
        obs[0] = false;
        if (1==1 && (boolean) obs[0]) {
            System.out.println("success");
        } else {
            System.out.println("error");
        }
    }
}
