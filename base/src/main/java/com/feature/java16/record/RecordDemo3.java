package com.feature.java16.record;

/**
 * 记录可以写在类的内部和方法中。
 * <p>
 * 嵌套和局部的 record 隐含都是静态的。
 * @author 朱俊伟
 * @since 2024/07/06 17:47
 */
public class RecordDemo3 {

    // 在类的内部定义记录（嵌套）
    record Nested(String s) {}
    void method() {
        // 在方法中定义记录（局部）
        record Local(String s) {}
        // 在方法内部定义的局部 record 也可以直接在该方法内使用，而不需要依赖外部类的实例
        Local local = new Local("world");
        System.out.println(local);
    }

    public static void main(String[] args) {
        // 由于 record 隐含是静态的，Nested 可以直接通过 RecordDemo3.Nested 来访问，而不需要 RecordDemo3 的实例。
        RecordDemo3.Nested nested =  new RecordDemo3.Nested("hello");
        System.out.println(nested);
        new RecordDemo3().method();
    }
}
