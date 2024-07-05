package com.zjw.inner;

import lombok.AllArgsConstructor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;

/**
 * 使用内部类访问对象状态
 * @author 朱俊伟
 * @since 2022/04/02 0:00
 */
public class InnerClassTest {
    public static void main(String[] args) {
        TalkingClock clock = new TalkingClock(1000, true);
        clock.start();

        // keep program running until user selects "Ok"
        JOptionPane.showMessageDialog(null, "确认退出吗?", "退出", JOptionPane.WARNING_MESSAGE);
        System.exit(0);
    }
}

@AllArgsConstructor
class TalkingClock{
    /**
     * 间隔
     */
    private int interval;

    /**
     * 哔哔声
     */
    private boolean beep;

    public void start(){
        //创建内部类对象 可以直接new 也可以使用this.new
//        ActionListener listener = new TimerPrinter();
        ActionListener listener = this.new TimerPrinter();
        Timer timer = new Timer(interval, listener);
        timer.start();
    }

    //内部类
    public class TimerPrinter implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(info +" "+ LocalTime.now());
            //内部类访问外部类属性 beep 也可以使用TalkingClock.this.beep
//            if (beep) Toolkit.getDefaultToolkit().beep();
            if (TalkingClock.this.beep) Toolkit.getDefaultToolkit().beep();
        }

        //静态域只能声明为final
        public static final String info = "hello";

        //内部类不能有static方法 编译报错
//        public static void hello(){}
    }
}
