package com.zjw.behavioral_patterns.visitor.element;

import com.zjw.behavioral_patterns.visitor.visitor.DocumentVisitor;

/**
 * 图片元素
 */
public class ImageElement implements DocumentElement {
    private String fileName;
    private int width;
    private int height;
    
    public ImageElement(String fileName, int width, int height) {
        this.fileName = fileName;
        this.width = width;
        this.height = height;
    }
    
    public String getFileName() {
        return fileName;
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    
    @Override
    public void accept(DocumentVisitor visitor) {
        visitor.visit(this);
    }
}