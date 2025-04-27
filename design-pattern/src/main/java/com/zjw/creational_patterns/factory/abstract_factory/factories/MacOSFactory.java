package com.zjw.creational_patterns.factory.abstract_factory.factories;

import com.zjw.creational_patterns.factory.abstract_factory.buttons.Button;
import com.zjw.creational_patterns.factory.abstract_factory.buttons.MacOSButton;
import com.zjw.creational_patterns.factory.abstract_factory.checkboxes.Checkbox;
import com.zjw.creational_patterns.factory.abstract_factory.checkboxes.MacOSCheckbox;

/**
 * 具体工厂 （ mac­OS）
 * <p>
 * Each concrete factory extends basic factory and responsible for creating
 * products of a single variety.
 */
public class MacOSFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}