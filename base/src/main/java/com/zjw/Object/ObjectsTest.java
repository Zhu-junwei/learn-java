package com.zjw.Object;

import org.junit.jupiter.api.Test;

import java.util.Objects;

/**
 * Objects类的使用
 *
 * @author 朱俊伟
 * @since 2022/05/24 12:30
 */
public class ObjectsTest {

    /**
     * Objects.equals(Object a, Object b)方法的使用
     *  - 两个参数都为null返回true
     *  - 其中一个为null返回false
     *  - 否则使用equals方法进行判断（两个对象的内存地址）
     */
    @SuppressWarnings("all")
    @Test
    public  void testEquals(){
        String str1 = "hello";
        String str2 = "hello";
        System.out.println(Objects.equals(str1, str2));//true
        System.out.println(Objects.equals(null,null));//true
        System.out.println(Objects.equals(null,str2));//false
        System.out.println(Objects.equals(str1,null));//false

    }

    /**
     * requireNonNullElse 如果第一个参数为 non-null ，则返回第一个参数，否则返回非第二个null 参数。
     */
    @Test
    public void requireNonNullElseTest() {
        String str = Objects.requireNonNullElse(null, "unknown");
        System.out.println(str);
    }

    /**
     * requireNonNull，如果不是 null，返回对象引用，如果是 null，则抛出 NullPointerException
     */
    @Test
    public void requireNonNullTest() {
        Object o = null;
//        Objects.requireNonNull(o);
        Objects.requireNonNull(o, "参数不能为null"); //在抛出 NullPointerException 时使用的详细消息
    }
}
