package com.zjw.reflection;

/**
 * 类的初始化时机，编译时常量
 *
 * @author 朱俊伟
 * @since 2024/09/04 00:44
 */
public class ClassInitialization {
    public static void main(String[] args) {
        // 不会初始化Initable
        System.out.println(Initable.STATIC_FINAL);
        // 会初始化Initable2
        System.out.println(Initable2.staticNonFinal);
        /*

        输出：
            47
            Initializing Initable2
            147
         */
    }
}

class Initable {
    /*
    如果一个 static final 字段的值是“编译时常量”，比如 Initable.staticFinal，那
    么这个值不需要初始化 Initable 类就能读取。
     */
    static final int STATIC_FINAL = 47;
    static {
        System.out.println("Initializing Initable");
    }
}

class Initable2 {
    /*
    如果 static 字段不是 final 的，那么访问它时，如果想要正常读取，总是需要先进行
    链接（为字段分配存储）和初始化（初始化该存储）
     */
    static int staticNonFinal = 147;
    static {
        System.out.println("Initializing Initable2");
    }
}
