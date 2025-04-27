package com.zjw.behavioral_patterns.memento;

/**
 * 存档管理器
 */
public class SaveManager {
    private GameSave save;

    public void saveGame(GameSave save) {
        this.save = save;
        System.out.println("游戏已存档");
    }

    public GameSave loadGame() {
        return save;
    }
}