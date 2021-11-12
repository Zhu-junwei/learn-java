package com.zjw.exception;

/**
 * @author 朱俊伟
 * @date 2021/11/12
 */
public class Dog extends Animal{

    @Override
    protected void onStart(String intent) {
        super.onStart(intent);
        System.out.println("onStart....");
    }
}

