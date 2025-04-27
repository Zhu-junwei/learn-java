package com.zjw.creational_patterns.factory.abstract_factory.factories;

import com.zjw.creational_patterns.factory.abstract_factory.buttons.Button;
import com.zjw.creational_patterns.factory.abstract_factory.checkboxes.Checkbox;

/**
 * 抽象工厂
 * <p>
 * Abstract factory knows about all (abstract) product types.
 */
public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}