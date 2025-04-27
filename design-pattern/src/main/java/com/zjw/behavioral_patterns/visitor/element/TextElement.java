package com.zjw.behavioral_patterns.visitor.element;

import com.zjw.behavioral_patterns.visitor.visitor.DocumentVisitor;

/**
 * 文本元素
 */
public class TextElement implements DocumentElement {
    private String content;
    
    public TextElement(String content) {
        this.content = content;
    }
    
    public String getContent() {
        return content;
    }
    
    @Override
    public void accept(DocumentVisitor visitor) {
        visitor.visit(this);
    }
}