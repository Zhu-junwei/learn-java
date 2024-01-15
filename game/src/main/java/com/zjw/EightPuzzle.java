package com.zjw;

import java.util.*;

/**
 * 八方块移动
 *
 * <p>八方块移动问题，也被称为“八数码”或“8-puzzle”，是一个经典的智力游戏。
 * 在这个游戏中，有一个3x3的方格盘，其中8个格子各有一个编号（通常是1到8），而剩下一个格子是空的。
 * 玩家的目标是通过滑动方块来重新排列它们，使得它们按顺序排列，通常是从左到右、从上到下地排列成1到8的顺序，同时留下右下角的空格。
 *
 * @author 朱俊伟
 * @since 2024/01/15 15:41
 */
public class EightPuzzle {

    // 8-puzzle是3x3的
    private static final int SIZE = 3;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    static class Node implements Comparable<Node> {
        int[][] puzzle;
        int x, y; // 空格的位置
        int cost; // 到达这个状态的成本
        int manhattanDistance; // 曼哈顿距离
        Node parent; // 用于回溯路径

        public Node(int[][] puzzle, int x, int y, int newX, int newY, int cost, Node parent) {
            this.puzzle = new int[SIZE][SIZE];
            for (int i = 0; i < SIZE; i++) {
                this.puzzle[i] = Arrays.copyOf(puzzle[i], SIZE);
            }

            // 交换空格
            this.puzzle[x][y] = this.puzzle[newX][newY];
            this.puzzle[newX][newY] = 0;

            this.x = newX;
            this.y = newY;
            this.cost = cost;
            this.manhattanDistance = calculateManhattanDistance();
            this.parent = parent;
        }

        private int calculateManhattanDistance() {
            int distance = 0;
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    int value = puzzle[i][j];
                    if (value != 0) {
                        int targetX = (value - 1) / SIZE;
                        int targetY = (value - 1) % SIZE;
                        distance += Math.abs(i - targetX) + Math.abs(j - targetY);
                    }
                }
            }
            return distance;
        }

        public boolean isGoal(int[][] goal) {
            for (int i = 0; i < SIZE; i++) {
                if (!Arrays.equals(this.puzzle[i], goal[i])) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public int compareTo(Node other) {
            return (this.cost + this.manhattanDistance) - (other.cost + other.manhattanDistance);
        }
    }

    public static List<Node> solve(int[][] start, int[][] goal) {
        PriorityQueue<Node> openList = new PriorityQueue<>();
        Map<String, Integer> costSoFar = new HashMap<>();
        String startKey = Arrays.deepToString(start);
        openList.add(new Node(start, findZero(start)[0], findZero(start)[1], findZero(start)[0], findZero(start)[1], 0, null));
        costSoFar.put(startKey, 0);

        while (!openList.isEmpty()) {
            Node current = openList.poll();

            if (current.isGoal(goal)) {
                return buildPath(current);
            }

            for (int i = 0; i < 4; i++) {
                int newX = current.x + dx[i];
                int newY = current.y + dy[i];

                if (isValid(newX, newY)) {
                    Node next = new Node(current.puzzle, current.x, current.y, newX, newY, current.cost + 1, current);
                    String nextKey = Arrays.deepToString(next.puzzle);

                    if (!costSoFar.containsKey(nextKey) || next.cost < costSoFar.get(nextKey)) {
                        openList.add(next);
                        costSoFar.put(nextKey, next.cost);
                    }
                }
            }
        }

        return null; // 未找到解决方案
    }

    private static int[] findZero(int[][] puzzle) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (puzzle[i][j] == 0) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < SIZE && y >= 0 && y < SIZE;
    }

    private static List<Node> buildPath(Node node) {
        List<Node> path = new ArrayList<>();
        while (node != null) {
            path.add(node);
            node = node.parent;
        }
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        int[][] start = {{1, 2, 3}, {4, 0, 5}, {7, 8, 6}};
        int[][] goal = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};

        List<Node> solution = solve(start, goal);
        if (solution != null) {
            for (Node node : solution) {
                for (int[] row : node.puzzle) {
                    System.out.println(Arrays.toString(row));
                }
                System.out.println();
            }
        } else {
            System.out.println("No solution found");
        }
    }

}
