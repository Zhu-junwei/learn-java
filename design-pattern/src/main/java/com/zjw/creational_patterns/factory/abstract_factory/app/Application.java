package com.zjw.creational_patterns.factory.abstract_factory.app;

import com.zjw.creational_patterns.factory.abstract_factory.buttons.Button;
import com.zjw.creational_patterns.factory.abstract_factory.checkboxes.Checkbox;
import com.zjw.creational_patterns.factory.abstract_factory.factories.GUIFactory;

/**
 * 客户端代码
 * <p>
 * Factory users don't care which concrete factory they use since they work with
 * factories and products through abstract interfaces.
 */
public class Application {
    private Button button;
    private Checkbox checkbox;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void paint() {
        button.paint();
        checkbox.paint();
    }
}