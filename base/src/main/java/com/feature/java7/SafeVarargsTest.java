package com.feature.java7;

/**
 * java 7引入了{@code @SafeVarargs} 注解。
 * {@code @SafeVarargs} 注解在Java中用于表示一个带有可变参数的方法是类型安全的。
 * 这个注解主要用于抑制编译器在处理泛型可变参数时发出的警告（<a href='https://www.cnblogs.com/zjw-blog/p/18284996'>堆污染</a>）。
 * <p>
 * {@code @SafeVarargs} 注解只能用于以下两种方法：
 * <ul>
 * <li>  静态方法
 * <li> final实例方法
 * <li> private实例方法 (java 9)
 * </ul>
 *
 * @author 朱俊伟
 * @date 2024/07/05
 */
public class SafeVarargsTest {

    /**
     * 静态方法
     */
    @SafeVarargs
    public static <T> void printElements(T... elements) {
        for (T element : elements) {
            System.out.println(element);
        }
    }

    /**
     * final实例方法
     */
    @SafeVarargs
    public final <T> void printElements2(T... elements) {
        for (T element : elements) {
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        printElements("Hello", "World", "!");
        printElements(1, 2, 3, 4, 5);

        SafeVarargsTest test = new SafeVarargsTest();
        test.printElements2("Hello", "World", "!");
    }
}
