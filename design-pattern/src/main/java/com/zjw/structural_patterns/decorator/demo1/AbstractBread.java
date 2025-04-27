package com.zjw.structural_patterns.decorator.demo1;

/**
 *  定义制作馒头的抽象类
 */
public abstract class AbstractBread implements IBread {
 
    private final IBread bread;
    
    public AbstractBread(IBread bread) {
        super();
        this.bread = bread;
    }

    @Override
    public void prepare() {
        this.bread.prepare();
    }
    @Override
    public void kneadFlour() {
        this.bread.kneadFlour();
    }
    @Override
    public void steamed() {
        this.bread.steamed();
    }
 
    @Override
    public void process() {
        prepare();
        kneadFlour();
        steamed();
    }
}