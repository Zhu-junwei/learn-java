package com.zjw.behavioral_patterns.templateMethod;

/**
 * 客户端代码使用模板方法
 */
public class TemplatePatternDemo {
    public static void main(String[] args) {
        Game game = new Cricket();
        game.play(); // 输出 Cricket 游戏流程

        System.out.println();

        game = new Football();
        game.play(); // 输出 Football 游戏流程
    }
}
