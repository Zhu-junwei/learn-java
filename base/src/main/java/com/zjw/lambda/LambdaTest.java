package com.zjw.lambda;

import javax.swing.*;
import java.util.Arrays;
import java.util.Date;

/**
 * lambda表达式 比较器和监听器
 * @author 朱俊伟
 * @since 2022/03/31 18:37
 */
public class LambdaTest {
    public static void main(String[] args) {
        String[] planets = new String[] {"Mercury", "Venus", "Earth", "Mars",
                    "Jupiter", "Saturn", "Uranus", "Neptune"};
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted in dictionary order:");
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted by length:");
        // 比较器
        Arrays.sort(planets, (first, second) -> first.length() - second.length());
        System.out.println(Arrays.toString(planets));

        // 监听器
        Timer t = new Timer(1000,event -> System.out.println("The time is " + new Date()));
        t.start();

        // keep program running until user selects "OK"
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}
