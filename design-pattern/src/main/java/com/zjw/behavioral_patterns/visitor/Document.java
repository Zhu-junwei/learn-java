package com.zjw.behavioral_patterns.visitor;

import com.zjw.behavioral_patterns.visitor.element.DocumentElement;
import com.zjw.behavioral_patterns.visitor.visitor.DocumentVisitor;

import java.util.ArrayList;
import java.util.List;

public class Document {
    private List<DocumentElement> elements = new ArrayList<>();
    
    public void addElement(DocumentElement element) {
        elements.add(element);
    }
    
    public void accept(DocumentVisitor visitor) {
        for (DocumentElement element : elements) {
            element.accept(visitor);
        }
    }
}