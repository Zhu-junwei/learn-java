package com.zjw.behavioral_patterns.visitor.visitor;

import com.zjw.behavioral_patterns.visitor.element.ImageElement;
import com.zjw.behavioral_patterns.visitor.element.TableElement;
import com.zjw.behavioral_patterns.visitor.element.TextElement;

/**
 * 定义文档访问者接口
 */
public interface DocumentVisitor {
    void visit(TextElement text);
    void visit(ImageElement image);
    void visit(TableElement table);
}