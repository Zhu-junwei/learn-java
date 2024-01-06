package com.zjw.generic;

/**
 * @author 朱俊伟
 * @since 2022/04/21 14:55
 */
public class GenericTest {
    public static void main(String[] args) {
        String middle = ArrayAlg.getMiddle("John", "Q.", "a");
        System.out.println(middle);
        Integer middle1 = ArrayAlg.getMiddle(1, 45, 6, 2, 34);
        System.out.println(middle1);

    }
}
