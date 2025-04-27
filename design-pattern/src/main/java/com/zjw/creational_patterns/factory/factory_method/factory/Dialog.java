package com.zjw.creational_patterns.factory.factory_method.factory;

import com.zjw.creational_patterns.factory.factory_method.buttons.Button;

/**
 * 基础创建者
 * <p>
 * Base factory class. Note that "factory" is merely a role for the class. It
 * should have some core business logic which needs different products to be
 * created.
 */
public abstract class Dialog {

    public void renderWindow() {
        // ... other code ...
        Button okButton = createButton();
        okButton.render();
    }

    /**
     * 工厂方法
     * <p>
     * Subclasses will override this method in order to create specific button
     * objects.
     */
    public abstract Button createButton();
}