//类greedySnackMain
package com.zjw.GreedySnack;

import javax.swing.*;

/**
 * 贪吃蛇游戏
 * 2018-05-15
 *
 * @author Junwei Zhu
 */

public class GreedySnackMain extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    snackWin snackwin;
    static final int Width = 800, Height = 600, LocX = 200, LocY = 80;

    public GreedySnackMain() {
        super("GreedySncak_SL");
        snackwin = new snackWin();
        add(snackwin);
        this.setSize(Width, Height);
        this.setVisible(true);
        this.setLocation(LocX, LocY);
        //snackwin.requestFocus();
    }

    public static void main(String[] args) {
        new GreedySnackMain();
    }
}