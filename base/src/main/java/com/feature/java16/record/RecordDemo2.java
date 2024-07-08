package com.feature.java16.record;

/**
 * 记录继承接口
 *
 * @author 朱俊伟
 * @since 2024/07/06 17:25
 */
public class RecordDemo2 {
    public static void main(String[] args) {
        RedDwarf redDwarf = new RedDwarf(100.0);
        System.out.println(redDwarf.brightness());
        System.out.println(redDwarf);
    }
}

/**
 * 记录可以继承接口，定义红矮星记录
 * @param brightness
 */
record RedDwarf(double brightness) implements Star {

    // 因为记录定义了brightness字段，自动生成了brightness()方法，所以还需要手动添加一个density()方法
    @Override
    public double density() {
        return 100.0;
    }
}

interface Star {
    double brightness(); // 亮度

    double density(); // 密度
}
