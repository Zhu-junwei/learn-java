package com.feature.java9;

/**
 * java 9 改进了{@code @SafeVarargs} 注解，可以在private实例方法中使用<a href="https://openjdk.org/jeps/213">EJP213</a>
 *
 * @author 朱俊伟
 * @date 2024/07/05
 */
public class SafeVarargsTest {

    /**
     * private实例方法
     */
    @SafeVarargs
    private <T> void printElements(T... elements) {
        for (T element : elements) {
            System.out.println(element);
        }
    }

    public static void main(String[] args) {

        SafeVarargsTest test = new SafeVarargsTest();
        test.printElements("a", "b", "c");
    }
}
