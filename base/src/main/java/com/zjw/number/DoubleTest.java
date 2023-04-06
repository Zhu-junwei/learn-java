package com.zjw.number;

import org.junit.Test;

/**
 * @author zjw
 * @date 2023/04/04 12:58
 */
public class DoubleTest {

    @Test
    public void testEqual(){
        Double aDouble = new Double(100);
        Double bDouble = new Double(100.0);
        System.out.println(aDouble.equals(bDouble));//true
    }
}
