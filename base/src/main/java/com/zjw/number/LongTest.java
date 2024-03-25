package com.zjw.number;


import org.junit.jupiter.api.Test;

/**
 * @author zjw
 * @since 2023/07/03 10:54
 */
public class LongTest {

    /**
     * 在循环中避免使用Long包装类型，否则会创建大量的对象，影响性能
     */
    @Test
    public void sum() {
        long sum = 0L;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

    /**
     * 测试Long相等
     */
    @Test
    public void testEquals() {
        Long a = 1000L;
        Long b = 1000L;
        System.out.println(a == b);//false
        System.out.println(a.equals(b));//true

        System.out.println("**********");
        Long c1 = 100L;
        Long c2 = 100L;
        System.out.println(c1 == c2);//true
        System.out.println(c1.equals(c2));//true

        System.out.println("127**********");
        Long d1 = 127L;
        Long d2 = 127L;
        System.out.println(d1 == d2);//true
        System.out.println(d1.equals(d2));//true

        System.out.println("128**********");
        Long e1 = 128L;
        Long e2 = 128L;
        System.out.println(e1 == e2);//false
        System.out.println(e1.equals(e2));//true

    }
}
