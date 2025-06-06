package com.zjw.creational_patterns.factory.factory_method;

import com.zjw.creational_patterns.factory.factory_method.factory.Dialog;
import com.zjw.creational_patterns.factory.factory_method.factory.HtmlDialog;
import com.zjw.creational_patterns.factory.factory_method.factory.WindowsDialog;

/**
 * 客户端代码
 * <p>
 * Demo class. Everything comes together here.
 */
public class Demo {
    private static Dialog dialog;

    public static void main(String[] args) {
        configure();
        runBusinessLogic();
    }

    /**
     * The concrete factory is usually chosen depending on configuration or
     * environment options.
     */
    static void configure() {
        if (System.getProperty("os.name").startsWith("Windows")) {
            dialog = new WindowsDialog();
        } else {
            dialog = new HtmlDialog();
        }
    }

    /**
     * All of the client code should work with factories and products through
     * abstract interfaces. This way it does not care which factory it works
     * with and what kind of product it returns.
     */
    static void runBusinessLogic() {
        dialog.renderWindow();
    }
}