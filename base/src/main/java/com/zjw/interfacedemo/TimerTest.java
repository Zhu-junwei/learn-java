package com.zjw.interfacedemo;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * java 接口回调 定时器实现 Java核心技术卷Ⅰ（第十版） page 223
 * @author 朱俊伟
 * @date 2022/03/31 0:29
 */
public class TimerTest {
    public static void main(String[] args) {
        boolean beep = false;
        ActionListener listener = new TimePrinter(beep);
        Timer t = new Timer(1000, listener);
        t.start();
//        JOptionPane.showMessageDialog(null,"Quit program?");
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
}

class TimePrinter implements ActionListener{

    boolean beep = false;

    public TimePrinter(boolean beep) {
        this.beep = beep;
    }

    /**
     * 每十秒打印一次时间 响铃一次
     * @param e a
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.printf("%tT \n",new Date());
        //getDefaultToolkit获取默认的工具箱，工具箱包含有关GUI环境的信息
        //beep 发出一声响铃
        if (beep){
            Toolkit.getDefaultToolkit().beep();
        }
    }
}
