package com.zjw.structural_patterns.adapter.adapter;

import com.zjw.structural_patterns.adapter.socket.ChineseSocket;
import com.zjw.structural_patterns.adapter.socket.EuropeSocket;

/**
 * 适配器（Adapter）类
 */
public class ChineseAdapterEurope implements ChineseSocket {

    private final EuropeSocket europeSocket;

    public ChineseAdapterEurope(EuropeSocket europeSocket) {
        this.europeSocket = europeSocket;
    }

    @Override
    public String useChineseSocket() {
        System.out.println("使用转换器转换完成");
        return europeSocket.useEuropesocket();
    }
}