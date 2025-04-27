package com.zjw.structural_patterns.flyweight;

/**
 * 享元模式
 */
public class Demo {
    public static void main(String[] args) {
        ChessBoard board = new ChessBoard();

        // 模拟下棋过程
        board.placePiece("黑", 3, 4);
        board.placePiece("白", 4, 5);
        board.placePiece("黑", 5, 6);
        board.placePiece("白", 6, 7);
        board.placePiece("黑", 3, 3);
        board.placePiece("白", 4, 4);

        board.showAllPieces();

        // 只会创建黑白两种棋子对象
        System.out.println("\n实际创建的棋子对象数量：" + ChessPieceFactory.getPieceCount());
        System.out.println("棋盘上的棋子总数：" + board.pieces.size());
    }
}