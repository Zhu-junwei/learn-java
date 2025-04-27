package com.zjw.extensions.delegation;

import com.zjw.extensions.delegation.printer.PrinterInterface;

/**
 * 委派类
 */
public class PrintTask {

    private PrinterInterface printer;

    public void setPrinter(PrinterInterface printer) {
        this.printer = printer;
    }

    // 负责打印任务
    public void executePrint(String message) {
        printer.print(message);
    }
}
