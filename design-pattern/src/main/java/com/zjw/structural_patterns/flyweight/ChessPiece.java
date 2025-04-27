package com.zjw.structural_patterns.flyweight;

/**
 * 棋子接口
 */
interface ChessPiece {
    void place(int x, int y);  // 位置是外部状态
}