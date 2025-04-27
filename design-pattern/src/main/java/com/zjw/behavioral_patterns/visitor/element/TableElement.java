package com.zjw.behavioral_patterns.visitor.element;

import com.zjw.behavioral_patterns.visitor.visitor.DocumentVisitor;

/**
 * 表元素
 */
public class TableElement implements DocumentElement {
    private int rows;
    private int columns;
    
    public TableElement(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }
    
    public int getRows() {
        return rows;
    }
    
    public int getColumns() {
        return columns;
    }
    
    @Override
    public void accept(DocumentVisitor visitor) {
        visitor.visit(this);
    }
}