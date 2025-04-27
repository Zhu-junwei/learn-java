package com.zjw.structural_patterns.adapter;

import com.zjw.structural_patterns.adapter.socket.ChineseSocket;

/**
 * 适配器的使用者
 */
public class Computer {
    public String useChineseSocket(ChineseSocket chineseSocket) {
        if(chineseSocket == null) {
            throw new NullPointerException("sd card null");
        }
        return chineseSocket.useChineseSocket();
    }
}