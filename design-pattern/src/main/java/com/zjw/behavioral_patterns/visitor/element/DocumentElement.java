package com.zjw.behavioral_patterns.visitor.element;

import com.zjw.behavioral_patterns.visitor.visitor.DocumentVisitor;

/**
 * 定义文档元素接口
 */
public interface DocumentElement {
    void accept(DocumentVisitor visitor);
}