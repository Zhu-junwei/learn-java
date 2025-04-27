package com.zjw.behavioral_patterns.memento;

/**
 * 游戏存档类
 */
public class GameSave {
    private final String name;
    private final int level;
    private final int health;

    public GameSave(String name, int level, int health) {
        this.name = name;
        this.level = level;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getHealth() {
        return health;
    }
}