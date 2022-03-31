package com.zjw.lambda;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * lambda表达式 方法引用
 * 方法引用中使用this super
 * @author 朱俊伟
 * @date 2022/03/31 18:37
 */
public class LambdaTest3 {
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
        Timer timer = new Timer(1000, super::greet);
        timer.start();
        // keep program running until user selects "OK"
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}