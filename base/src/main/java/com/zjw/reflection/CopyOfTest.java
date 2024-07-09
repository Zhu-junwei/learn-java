package com.zjw.reflection;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 利用反射进行数组扩容 Java核心技术卷Ⅰ（第十版） page 204
 *
 * @author 朱俊伟
 * @since 2022/03/30 0:27
 */
public class CopyOfTest {
    public static void main(String[] args) {
        int[] a = {1,2,3};
        a = (int[])goodCopyOf(a,10);
        System.out.println(Arrays.toString(a));

        String[] b = {"a","b","c"};
        b = (String[])goodCopyOf(b,10);
        System.out.println(Arrays.toString(b));

        String[] c = {"a","b","d"};
        c = Arrays.copyOf(c, 10);

        System.out.println(Arrays.toString(c));

        b = (String[])badCopyOf(b,10);
        System.out.println(Arrays.toString(b));
    }

    /**
     * 无法再转为原来的数组类型，会报ClassCastException
     */
    public static Object[] badCopyOf(Object[] a, int newLength){
        Object[] newArray = new  Object[newLength];
        System.arraycopy(a,0,newArray,0,Math.min(a.length,newLength));
        return newArray;
    }

    /**
     * goodCopyOf方法 实际上是Arrays类的copyOf(T[] original, int newLength) 方法
     */
    public static Object goodCopyOf(Object a, int newLength){
        Class<?> cl = a.getClass();
        if (!cl.isArray()) return null;
        Class<?> componentType = cl.getComponentType();
        int length = Array.getLength(a);
        Object newArray = Array.newInstance(componentType, newLength);
        /*
         * src – 源数组
         * srcPos – 开始拷贝的位置
         * dest – 目标数组
         * destPos – 目标数组开始拷贝的位置
         * length – 需要拷贝的长度
         */
        System.arraycopy(a,0,newArray,0,Math.min(length,newLength));
        return newArray;
    }
}
