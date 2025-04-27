package com.zjw.creational_patterns.factory.factory_method.factory;

import com.zjw.creational_patterns.factory.factory_method.buttons.Button;
import com.zjw.creational_patterns.factory.factory_method.buttons.WindowsButton;

/**
 * 另一个具体创建者
 * <p>
 * Windows Dialog will produce Windows buttons.
 */
public class WindowsDialog extends Dialog {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}