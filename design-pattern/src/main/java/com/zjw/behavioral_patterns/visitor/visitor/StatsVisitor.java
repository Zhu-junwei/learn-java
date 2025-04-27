package com.zjw.behavioral_patterns.visitor.visitor;

import com.zjw.behavioral_patterns.visitor.element.ImageElement;
import com.zjw.behavioral_patterns.visitor.element.TableElement;
import com.zjw.behavioral_patterns.visitor.element.TextElement;

/**
 * 统计元素信息访问者
 */
public class StatsVisitor implements DocumentVisitor {
    private int textCount = 0;
    private int imageCount = 0;
    private int tableCount = 0;
    
    @Override
    public void visit(TextElement text) {
        textCount++;
    }
    
    @Override
    public void visit(ImageElement image) {
        imageCount++;
    }
    
    @Override
    public void visit(TableElement table) {
        tableCount++;
    }
    
    public void printStats() {
        System.out.println("文档统计:");
        System.out.println("文本元素: " + textCount);
        System.out.println("图片元素: " + imageCount);
        System.out.println("表格元素: " + tableCount);
    }
}