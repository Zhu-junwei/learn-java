package com.zjw.extensions.delegation;

import com.zjw.extensions.delegation.printer.impl.ConsolePrinter;
import com.zjw.extensions.delegation.printer.impl.FilePrinter;
import com.zjw.extensions.delegation.printer.PrinterInterface;

/**
 * 委派（Delegation） 是一种设计模式，通常用于实现代码的解耦和复用。
 *
 * <p>简单来说，委派是指一个对象将自己的部分职责，即一些特定的任务，转交（委派）给其他对象来处理。
 * 这种模式允许对象组合实现功能，而不是通过继承。
 */
public class DelegationDemo {
    public static void main(String[] args) {
        PrinterInterface consolePrinter = new ConsolePrinter();
        PrinterInterface filePrinter = new FilePrinter("output.txt");

        PrintTask printTask = new PrintTask();
        // 委派给控制台打印器去执行
        printTask.setPrinter(consolePrinter);
        printTask.executePrint("Hello, printing to console!");

        // 委派给文件打印器去执行
        printTask.setPrinter(filePrinter);
        printTask.executePrint("Hello, printing to file!");
    }
}
