package com.zjw.number;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * 测试BigDecimal的使用
 * @author 朱俊伟
 * @date 2021/12/23
 */
public class BigDecimalTest {

    public static void main(String[] args) {

    }

    /**
     * 取余数
     */
    @Test
    public void remainder(){
        BigDecimal bd = new BigDecimal(100);
        BigDecimal remainder = bd.remainder(new BigDecimal(9));
        // 相当于 100%9 = 1
        System.out.println(remainder);
    }

    public static BigDecimal getMin(BigDecimal first, BigDecimal second){
        return first.min(second);
    }

}
