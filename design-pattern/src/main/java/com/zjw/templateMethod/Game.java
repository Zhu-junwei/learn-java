package com.zjw.templateMethod;

/**
 * Game抽象类，定义模板方法
 */
abstract class Game {
    // 模板方法
    public final void play() {
        initialize();
        startPlay();
        endPlay();
    }

    // 抽象方法，具体实现延迟到子类
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();
}
