package com.zjw.delegation;

import com.zjw.delegation.printer.PrinterInterface;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 委派类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrintTask {

    private PrinterInterface printer;

    public void executePrint(String message) {
        printer.print(message);
    }
}
