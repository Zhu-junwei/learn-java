package com.zjw.extensions.delegation.printer.impl;

import com.zjw.extensions.delegation.printer.PrinterInterface;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 文件打印器
 */
public class FilePrinter implements PrinterInterface {
    private String filePath;

    public FilePrinter(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void print(String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(message);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
