package com.zjw.creational_patterns.factory.factory_method.factory;

import com.zjw.creational_patterns.factory.factory_method.buttons.Button;
import com.zjw.creational_patterns.factory.factory_method.buttons.HtmlButton;

/**
 * 具体创建者
 * <p>
 * HTML Dialog will produce HTML buttons.
 */
public class HtmlDialog extends Dialog {

    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}