package com.zjw.behavioral_patterns.visitor.visitor;

import com.zjw.behavioral_patterns.visitor.element.ImageElement;
import com.zjw.behavioral_patterns.visitor.element.TableElement;
import com.zjw.behavioral_patterns.visitor.element.TextElement;

/**
 * 导出为HTML访问者
 */
public class HtmlExportVisitor implements DocumentVisitor {
    @Override
    public void visit(TextElement text) {
        System.out.println("<p>" + text.getContent() + "</p>");
    }
    
    @Override
    public void visit(ImageElement image) {
        System.out.printf("<img src=\"%s\" width=\"%d\" height=\"%d\"/>\n", 
                         image.getFileName(), image.getWidth(), image.getHeight());
    }
    
    @Override
    public void visit(TableElement table) {
        System.out.printf("<table rows=\"%d\" columns=\"%d\"></table>\n", 
                         table.getRows(), table.getColumns());
    }
}