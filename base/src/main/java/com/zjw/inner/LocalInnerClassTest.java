package com.zjw.inner;

import lombok.AllArgsConstructor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * 局部内部类 在一个方法中声明内部类
 * @author 朱俊伟
 * @date 2022/04/02 1:09
 */
public class LocalInnerClassTest {
    public static void main(String[] args) {
        TalkingClock2 clock2 = new TalkingClock2(1000, true);
        clock2.start();
        // keep program running until user selects "Ok"
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}

@AllArgsConstructor
class TalkingClock2{
    private int interval;
    private boolean beep;

    /**
     *  局部内部类不能用public或private访问说明符进行声明。它的作用域被限定再声明这个局部类的块中。
     *  局部类有一个优势，即对外部世界可以完全地隐藏起来。即使TalkingClock类中的其他代码不能访问它。
     * 除了start方法外，没有任何方法知道TimerPrinter类的存在
     */
    public void start(){
        //局部内部类
        class TimerPrinter implements ActionListener{
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
}