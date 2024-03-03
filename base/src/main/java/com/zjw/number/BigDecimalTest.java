package com.zjw.number;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 测试BigDecimal的使用
 *
 * @author 朱俊伟
 * @since 2021/12/23
 */
public class BigDecimalTest {

    /**
     * 取余数
     */
    @Test
    public void remainder() {
        BigDecimal bd = new BigDecimal(100);
        BigDecimal remainder = bd.remainder(new BigDecimal(9));
        // 相当于 100%9 = 1
        System.out.println(remainder);
    }

    /**
     * 将其他类型数据转为BigDecimal类型数据
     */
    @Test
    public void parseBigDecimal() {
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

    public static BigDecimal getMin(BigDecimal first, BigDecimal second) {
        return first.min(second);
    }

    /**
     * 测试除法
     */
    @Test
    public void testBigDecimalDivide() {

        /*
            1. BigDecimal divide(BigDecimal divisor)
            不推荐使用，没有舍入模式导致异常，java.lang.ArithmeticException: Non-terminating decimal expansion; no exact representable decimal result.
         */
        try {
            System.out.println("1. BigDecimal divide(BigDecimal divisor)");
            new BigDecimal("5").divide(new BigDecimal("3"));
        } catch (Exception e) {
            System.out.println(e);
        }

        /*
            2. BigDecimal divide(BigDecimal divisor, RoundingMode roundingMode)
                结果只保留整数部分
         */
        System.out.println("2. BigDecimal divide(BigDecimal divisor, RoundingMode roundingMode)");
        BigDecimal result1 = new BigDecimal("5").divide(new BigDecimal("3"), RoundingMode.HALF_UP);
        System.out.println("5/3 = " + result1); // 2
        System.out.println("6/3 = " + new BigDecimal("6").divide(new BigDecimal("3"), RoundingMode.HALF_UP));// 2

        /*
            3. BigDecimal divide(BigDecimal divisor, int scale, RoundingMode roundingMode)
                scale设置保留的精度
         */
        System.out.println("3. BigDecimal divide(BigDecimal divisor, int scale, RoundingMode roundingMode)");
        System.out.println("5/3 = " + new BigDecimal("5").divide(new BigDecimal("3"), 2, RoundingMode.HALF_UP)); // 1.67
        System.out.println("10/3 = " + new BigDecimal("10").divide(new BigDecimal("3"), 2, RoundingMode.HALF_UP));// 3.33
        System.out.println("6/3 = " + new BigDecimal("6").divide(new BigDecimal("3"), 2, RoundingMode.HALF_UP));// 2.00
    }

    /**
     * 测试舍入模式
     * <p>
     * 参见{@link RoundingMode}说明
     * <p>
     * {@link RoundingMode#UP}  从零舍入的舍入模式。
     * <p>
     * {@link RoundingMode#DOWN} 向零舍入的舍入模式。
     * <p>
     * {@link RoundingMode#CEILING} 向正无穷大舍入的舍入模式。
     * <p>
     * {@link RoundingMode#FLOOR} 向负无穷大舍入的舍入模式。
     * <p>
     * {@link RoundingMode#HALF_UP} 【常用】舍入模式向“最近的邻居”舍入，除非两个邻居是等距的，在这种情况下舍入。
     * <p>
     * {@link RoundingMode#HALF_DOWN} 舍入模式向“最近的邻居”舍入，除非两个邻居是等距的，在这种情况下向下舍入。
     * <p>
     * {@link RoundingMode#HALF_EVEN} 舍入模式向“最近的邻居”舍入，除非两个邻居都是等距的，在这种情况下，向偶数邻居舍入。
     * <p>
     * {@link RoundingMode#UNNECESSARY} 舍入模式断言所请求的操作具有准确的结果，因此不需要舍入。
     */
    @Test
    public void testRoundingMode() {
        /*
            5/3 = 1.6……
            6/3 = 2
            10/3 = 3.333
         */
        // 1.67
        System.out.println("5/3 = " + new BigDecimal("5").divide(new BigDecimal("3"), 2, RoundingMode.HALF_UP));
        // 2.00
        System.out.println("6/3 = " + new BigDecimal("6").divide(new BigDecimal("3"), 2, RoundingMode.HALF_UP));
        // 3.33
        System.out.println("10/3 = " + new BigDecimal("10").divide(new BigDecimal("3"), 2, RoundingMode.HALF_UP));
    }

    /**
     * 测试BigDecimal比较大小
     */
    @Test
    public void testCompareTo() {
        BigDecimal bigDecimal80 = new BigDecimal(80);
        BigDecimal bigDecimal100_0 = new BigDecimal(100.0);
        BigDecimal bigDecimal100 = new BigDecimal(100);
        BigDecimal bigDecimal101 = new BigDecimal(101);

        System.out.println(bigDecimal100_0.compareTo(bigDecimal100));//0
        System.out.println(bigDecimal100.compareTo(bigDecimal80));//1
        System.out.println(bigDecimal100.compareTo(bigDecimal101));//-1
        System.out.println(new BigDecimal("-1").compareTo(new BigDecimal("0")));//-1

    }

    /**
     * 测试取反
     */
    @Test
    public void testNegate() {
        BigDecimal bigDecimal80 = new BigDecimal(80);
        System.out.println(bigDecimal80.negate());//-80
    }

    /**
     * 测试乘法
     */
    @Test
    public void testMultiply() {
        BigDecimal bg1 = new BigDecimal("3.2");
        BigDecimal bg2 = new BigDecimal("1.2");
        BigDecimal bg3 = new BigDecimal("-1");
        System.out.println(bg1.multiply(bg2).multiply(bg3));
    }

    /**
     * 测试转为double
     */
    @Test
    public void testToDouble() {
        BigDecimal decimal = new BigDecimal("123.456789");
        Double result = decimal.setScale(2, RoundingMode.HALF_UP).doubleValue();
        System.out.println(result);
        BigDecimal decimal2 = new BigDecimal("123.456789").setScale(2, RoundingMode.HALF_UP);
        System.out.println(decimal2);
    }


}
