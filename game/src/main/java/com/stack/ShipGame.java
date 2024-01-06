package com.stack;

import java.util.Scanner;

/**
 * 输入船只的坐标
 * @author 朱俊伟
 * @since 2023/10/10 22:32
 */
public class ShipGame {
    public static void main(String[] args) {
        //用户输入坐标
        char [][] strike = player1ships();

        for (char[] chars : strike) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }

    }

    public static char[][] player1ships() {
        System.out.println("PLAYER 1, ENTER YOUR SHIPS' COORDINATES.");
        Scanner input = new Scanner(System.in);
        char[][] player1 = new char[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                player1[i][j] = '-';
            }
        }
        for (int i = 1; i <= 5; ) {
            System.out.println("Enter location for ship " + i);
            int a = input.nextInt();
            int b = input.nextInt();
            if ((a >= 0 && a < 5) && (b >= 0 && b < 5) && (player1[a][b] == '-')) {
                player1[a][b] = '@';
                i++;
            } else if ((a >= 0 && a < 5) && (a >= 0 && b < 5) && (player1[a][b] == '@'))
                System.out.println("You can't place two or more ships on the same location");
            else if ((a < 0 || a >= 5) || (b < 0 || b >= 5))
                System.out.println("You can't place ships outside the " + 5 + " by " + 5 + " grid");
        }
        return player1;
    }
}
