package com.zjw.extensions.delegation.printer.impl;

import com.zjw.extensions.delegation.printer.PrinterInterface;

/**
 * 控制台打印器
 */
public class ConsolePrinter implements PrinterInterface {
    @Override
    public void print(String message) {
        System.out.println("Printing to console: " + message);
    }
}
