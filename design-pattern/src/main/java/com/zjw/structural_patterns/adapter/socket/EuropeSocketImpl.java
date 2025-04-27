package com.zjw.structural_patterns.adapter.socket;

// 欧式三叉实现类
public class EuropeSocketImpl implements EuropeSocket {

    @Override
    public String useEuropesocket() {
        String msg ="使用欧式三叉充电";
        return msg;
    }
}