package com.zjw.behavioral_patterns.memento;

/**
 * 游戏角色类
 */
public class GameCharacter {
    private String name;
    private int level;
    private int health;

    public GameCharacter(String name, int level, int health) {
        this.name = name;
        this.level = level;
        this.health = health;
    }

    // 玩游戏升级
    public void play() {
        this.level++;
        this.health += 10;
        System.out.println(name + " 升级了! 当前等级: " + level + ", 生命值: " + health);
    }

    // 受伤
    public void takeDamage(int damage) {
        this.health -= damage;
        System.out.println(name + " 受到 " + damage + " 点伤害! 剩余生命: " + health);
    }

    // 创建存档
    public GameSave save() {
        return new GameSave(name, level, health);
    }

    // 读取存档
    public void load(GameSave save) {
        this.name = save.getName();
        this.level = save.getLevel();
        this.health = save.getHealth();
        System.out.println("已加载存档: " + name + " 等级" + level + " 生命" + health);
    }

    public void display() {
        System.out.println(name + " - 等级:" + level + " 生命:" + health);
    }
}