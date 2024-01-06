package com.zjw.inner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * 由外部方法访问变量
 * @author 朱俊伟
 * @since 2022/04/02 1:37
 */
public class InnerClassAccessTest {
    public static void main(String[] args) {
        TalkingClock3 clock3 = new TalkingClock3();
//        clock3.start(1000, true);
//        clock3.start2(1000, true);
        clock3.start3(1000, true);
        // keep program running until user selects "Ok"
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}

class TalkingClock3{

    public void start(int interval, boolean beep){
        //局部内部类
        class TimerPrinter implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("At the tone, the time is " + new Date());
                if (beep) Toolkit.getDefaultToolkit().beep();
            }
        }

        //创建内部类对象
        ActionListener listener = new TimerPrinter();
        Timer timer = new Timer(interval, listener);
        timer.start();
    }

    //使用匿名内部类
    public void start2(int interval, boolean beep){
        //创建内部类对象
        ActionListener listener = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("At the tone, the time is " + new Date());
                if (beep) Toolkit.getDefaultToolkit().beep();
            }
        };
        Timer timer = new Timer(interval, listener);
        timer.start();
    }

    //使用lambda表达式
    public void start3(int interval, boolean beep){
        Timer timer = new Timer(interval, event -> {
            System.out.println("At the tone, the time is " + new Date());
            if (beep) Toolkit.getDefaultToolkit().beep();
        });
        timer.start();
    }
}