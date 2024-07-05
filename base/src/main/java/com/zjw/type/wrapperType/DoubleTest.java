package com.zjw.type.wrapperType;

import org.junit.jupiter.api.Test;

/**
 * Double包装类
 *
 * @author zjw
 * @since 2023/04/04 12:58
 */
public class DoubleTest {

    @SuppressWarnings("all")
    @Test
    public void testEqual() {
        Double aDouble = 100D;
        Double bDouble = 100.0;
        System.out.println(aDouble.equals(bDouble));//true
    }
}
