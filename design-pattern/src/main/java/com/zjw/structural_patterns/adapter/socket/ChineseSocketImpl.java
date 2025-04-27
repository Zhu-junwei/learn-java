package com.zjw.structural_patterns.adapter.socket;

// 中国插头的实现类
public class ChineseSocketImpl implements ChineseSocket {

    @Override
    public String useChineseSocket() {
        String msg="使用中国双叉充电";
        return msg;
    }
}