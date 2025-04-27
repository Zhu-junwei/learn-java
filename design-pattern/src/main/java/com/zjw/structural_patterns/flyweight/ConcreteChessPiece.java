package com.zjw.structural_patterns.flyweight;

/**
 * 具体享元 - 黑白棋子
 */
public class ConcreteChessPiece implements ChessPiece {
    /**
     * 棋子颜色
     */
    private final String color;  // 内部状态（共享）

    /**
     * 棋子纹理
     */
    private final String texture; // 内部状态（共享）

    public ConcreteChessPiece(String color) {
        this.color = color;
        this.texture = "木质纹理"; // 所有棋子共享相同的纹理
        System.out.println("创建" + color + "棋子，纹理：" + texture);
    }

    @Override
    public void place(int x, int y) {
        System.out.println(color + "棋子放置在(" + x + "," + y + ")");
    }
}