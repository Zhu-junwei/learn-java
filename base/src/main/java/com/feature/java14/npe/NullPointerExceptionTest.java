package com.feature.java14.npe;

/**
 * 空指针异常信息更全 <a href="https://openjdk.org/jeps/358">EJP358</a>
 * @author 朱俊伟
 * @since 2024/03/24 16:44
 */
public class NullPointerExceptionTest {
    public static void main(String[] args) {
        String str = null;
        // Cannot invoke "String.length()" because "str" is null
        System.out.println(str.length());
    }
}
