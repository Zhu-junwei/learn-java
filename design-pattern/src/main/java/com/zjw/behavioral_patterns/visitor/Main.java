package com.zjw.behavioral_patterns.visitor;

import com.zjw.behavioral_patterns.visitor.element.ImageElement;
import com.zjw.behavioral_patterns.visitor.element.TableElement;
import com.zjw.behavioral_patterns.visitor.element.TextElement;
import com.zjw.behavioral_patterns.visitor.visitor.HtmlExportVisitor;
import com.zjw.behavioral_patterns.visitor.visitor.StatsVisitor;

public class Main {
    public static void main(String[] args) {
        Document document = new Document();
        
        // 添加文档元素
        document.addElement(new TextElement("欢迎访问我们的网站"));
        document.addElement(new ImageElement("logo.png", 100, 50));
        document.addElement(new TableElement(3, 4));
        document.addElement(new TextElement("联系我们: info@example.com"));
        
        // 导出为HTML
        System.out.println("导出为HTML:");
        document.accept(new HtmlExportVisitor());
        
        System.out.println("----------");
        
        // 统计文档元素
        StatsVisitor statsVisitor = new StatsVisitor();
        document.accept(statsVisitor);
        statsVisitor.printStats();
    }
}