package com.zjw.creational_patterns.factory.factory_method.buttons;

/**
 * 通用产品接口
 * <p>
 * Common interface for all buttons.
 */
public interface Button {
    void render();
    void onClick();
}