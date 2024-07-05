package com.zjw.type.wrapperType;


import org.junit.jupiter.api.Test;

/**
 * Long包装类
 *
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
     * testCache测试Long包装类中的缓存
     * 和Integer包装类中的缓存一样，缓存的范围是-128~127
     */
    @Test
    @SuppressWarnings("all")
    public void testCache() {

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
