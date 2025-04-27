package com.zjw.creational_patterns.factory.abstract_factory.factories;

import com.zjw.creational_patterns.factory.abstract_factory.buttons.Button;
import com.zjw.creational_patterns.factory.abstract_factory.buttons.WindowsButton;
import com.zjw.creational_patterns.factory.abstract_factory.checkboxes.Checkbox;
import com.zjw.creational_patterns.factory.abstract_factory.checkboxes.WindowsCheckbox;

/**
 * 具体工厂 （Windows）
 * <p>
 * Each concrete factory extends basic factory and responsible for creating
 * products of a single variety.
 */
public class WindowsFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}