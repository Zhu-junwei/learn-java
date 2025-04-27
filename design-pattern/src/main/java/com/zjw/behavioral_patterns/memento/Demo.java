package com.zjw.behavioral_patterns.memento;

/**
 * 测试类
 */
public class Demo {
    public static void main(String[] args) {
        // 创建游戏角色
        GameCharacter hero = new GameCharacter("勇者", 1, 100);
        hero.display();

        // 创建存档管理器
        SaveManager saveManager = new SaveManager();

        // 玩游戏并存档
        hero.play();
        saveManager.saveGame(hero.save());

        // 继续玩游戏
        hero.play();
        hero.takeDamage(30);
        hero.display();

        // 加载之前的存档
        System.out.println("\n加载存档...");
        hero.load(saveManager.loadGame());
        hero.display();
    }
}