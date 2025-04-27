package com.zjw.structural_patterns.adapter;

import com.zjw.structural_patterns.adapter.adapter.ChineseAdapterEurope;
import com.zjw.structural_patterns.adapter.socket.ChineseSocket;
import com.zjw.structural_patterns.adapter.socket.ChineseSocketImpl;
import com.zjw.structural_patterns.adapter.socket.EuropeSocket;
import com.zjw.structural_patterns.adapter.socket.EuropeSocketImpl;

/**
 * 测试适配器模式
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println("-----在中国-------");
        Computer computer = new Computer();
        ChineseSocket chineseSocket = new ChineseSocketImpl();
        System.out.println(computer.useChineseSocket(chineseSocket));

        System.out.println("\n-----在欧洲-------");
        //这里做了更改
        EuropeSocket europeSocket=new EuropeSocketImpl();
        System.out.println(computer.useChineseSocket(getChineseAdapter(europeSocket)));
        /*
        结果：
        -----在中国-------
        使用中国双叉充电

        -----在欧洲-------
        使用转换器转换完成
        使用欧式三叉充电
         */
    }

    /**
     * 获取是适配器
     */
    private static ChineseSocket getChineseAdapter(EuropeSocket europeSocket) {
        return new ChineseAdapterEurope(europeSocket);
    }
}