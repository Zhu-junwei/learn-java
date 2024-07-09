package com.zjw.assertDemo;

/**
 * 测试设置动态断言，但是无法生效，为什么呢
 * @author 朱俊伟
 * @since 2024/07/15 15:13
 */
public class DynamicAssertDemo {
    public static void main(String[] args) {
        // 开启断言
        AssertionSetup.setup();
        new Loaded().go();
    }
}

class Loaded {
    public void go() {
        assert false : "Loaded.go()";
    }
}

class AssertionSetup {

    public static void setup() {
        /*
            SystemClassLoader:
                系统类加载器通常是用于加载应用程序类路径（如CLASSPATH环境变量中指定的路径）上的类。
                它加载的是用户自定义的类和第三方库。
            PlatformClassLoader:
                平台类加载器在Java 9中引入，负责加载平台类。平台类加载器位于引导类加载器（Bootstrap
                ClassLoader）和系统类加载器之间。它主要用于加载Java平台的模块（例如，java.sql，
                java.xml等模块），这些模块不属于核心JDK类，但又是平台的一部分。
         */
        ClassLoader.getSystemClassLoader().setDefaultAssertionStatus(true);
//        ClassLoader.getPlatformClassLoader().setDefaultAssertionStatus(true);
    }
}
