package com.zjw.structural_patterns.flyweight;

import java.util.ArrayList;
import java.util.List;

/**
 * 棋盘
 */
public class ChessBoard {
    final List<ChessPiece> pieces = new ArrayList<>();
    private final List<String> positions = new ArrayList<>();

    public void placePiece(String color, int x, int y) {
        ChessPiece piece = ChessPieceFactory.getChessPiece(color);
        pieces.add(piece);
        positions.add(x + "," + y);
        piece.place(x, y);
    }

    public void showAllPieces() {
        System.out.println("\n当前棋盘状态：");
        for (int i = 0; i < pieces.size(); i++) {
            String[] pos = positions.get(i).split(",");
            pieces.get(i).place(Integer.parseInt(pos[0]), Integer.parseInt(pos[1]));
        }
    }
}