package com.zjw.structural_patterns.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂
 */
public class ChessPieceFactory {
    private static final Map<String, ChessPiece> pieces = new HashMap<>();

    public static ChessPiece getChessPiece(String color) {
        if (!pieces.containsKey(color)) {
            pieces.put(color, new ConcreteChessPiece(color));
        }
        return pieces.get(color);
    }

    public static int getPieceCount() {
        return pieces.size();
    }
}