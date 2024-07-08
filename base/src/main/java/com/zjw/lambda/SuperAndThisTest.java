package com.zjw.lambda;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * lambda表达式 方法引用
 * 方法引用中使用this super
 * @author 朱俊伟
 * @since 2022/03/31 18:37
 */
public class SuperAndThisTest {
    public static void main(String[] args) {

        TimedGreeter greeter = new TimedGreeter();
        greeter.greet();

    }

}

class Greeter{
    public void greet(ActionEvent actionEvent){
        System.out.println("Hello, world!");
    }
}

class TimedGreeter extends Greeter{
    public void greet(){
        //调用父类的greet方法
//        Timer timer = new Timer(1000, super::greet);
        Timer timer1 = new Timer(1000, this::childGreet);
        timer1.start();
        Timer timer2 = new Timer(3000, super::greet);
        timer2.start();
        // keep program running until user selects "OK"
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }

    private void childGreet(ActionEvent actionEvent) {
        System.out.println("TimedGreeter Hello, world!");
    }
}