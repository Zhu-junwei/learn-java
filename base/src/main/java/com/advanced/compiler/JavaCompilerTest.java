package com.advanced.compiler;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

/**
 * @author 朱俊伟
 * @since 2024/06/29 23:23
 */
public class JavaCompilerTest {
    public static void main(String[] args) {
        // 获取java编译器
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        System.out.println(compiler);
        System.out.println(compiler.name());
        System.out.println(compiler.getClass());
        compiler.getSourceVersions().forEach(System.out::println);
        compiler.run(null, null, null, "-sourcepath", "src", "HelloWorld.java");
    }
}

// 放在项目得根路径下
/*
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World from string!");
    }
}
 */