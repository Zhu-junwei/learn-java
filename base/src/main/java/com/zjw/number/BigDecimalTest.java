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

    /**
     * 将其他类型数据转为BigDecimal类型数据
     */
    @Test
    public void parseBigDecimal(){
        /*
        禁止使用构造方法 BigDecimal(double)的方式把 double 值转化为 BigDecimal 对象。
        说明： BigDecimal(double)存在精度损失风险，在精确计算或值比较的场景中可能会导致业务逻辑异常。
        如： BigDecimal g = new BigDecimal(0.1F); 实际的存储值为： 0.10000000149
        正例： 优先推荐入参为 String 的构造方法，或使用 BigDecimal 的 valueOf 方法，此方法内部其实执行了
            Double 的 toString，而 Double 的 toString 按 double 的实际能表达的精度对尾数进行了截断。
         */
        BigDecimal g = new BigDecimal(0.1F);
        System.out.println(g);//0.100000001490116119384765625
        BigDecimal recommend1 = new BigDecimal("0.1");
        BigDecimal recommend2 = BigDecimal.valueOf(0.1);
        System.out.println(recommend1);//0.1
        System.out.println(recommend2);//0.1
        recommend1.toPlainString();
    }

    public static BigDecimal getMin(BigDecimal first, BigDecimal second){
        return first.min(second);
    }

}
