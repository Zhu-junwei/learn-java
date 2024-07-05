package com.zjw.type.baseType;

/**
 * 移位操作
 * @author 朱俊伟
 * @since 2024/03/30 16:10
 */
public class ShiftOperation {
    public static void main(String[] args) {
        int a = 0B00101100_01010011_01101000_11010110;
        System.out.println("***********左移****************");
        System.out.println("a的原始十进制:\t" + a);
        System.out.println("a的原始二进制:\t" + getBinaryString(a));
        System.out.println("a的左移1位二进制:\t" + getBinaryString(a << 1));
        System.out.println("a的左移1位十进制:\t" + getInt(getBinaryString(a << 1)));
        System.out.println("a的左移2位二进制:\t" + getBinaryString(a << 2));
        System.out.println("a的左移2位十进制:\t" + getInt(getBinaryString(a << 2)));

        System.out.println("***********右移****************");
        int b = 0B10101100_01010011_01101000_11010110;
        System.out.println("b的原始十进制:\t" + b);
        System.out.println("b的原始二进制:\t" + getBinaryString(b));
        System.out.println("b的右移1位二进制:\t" + getBinaryString(b >> 1));
        System.out.println("b的右移1位十进制:\t" + getInt(getBinaryString(b >> 1)));
        System.out.println("b的右移2位二进制:\t" + getBinaryString(b >> 2));
        System.out.println("b的右移2位十进制:\t" + getInt(getBinaryString(b >> 2)));

        System.out.println("***********无符号右移****************");
        System.out.println("b的原始十进制:\t" + b);
        System.out.println("b的原始二进制:\t\t\t" + getBinaryString(b));
        System.out.println("b的无符号右移1位二进制:\t" + getBinaryString(b >>> 1));
        System.out.println("b的无符号右移2位二进制:\t" + getBinaryString(b >>> 2));
        System.out.println("b的无符号右移3位二进制:\t" + getBinaryString(b >>> 3));
        System.out.println("b的无符号右移4位二进制:\t" + getBinaryString(b >>> 4));
        System.out.println("b的无符号右移5位二进制:\t" + getBinaryString(b >>> 5));
        System.out.println("b的无符号右移6位二进制:\t" + getBinaryString(b >>> 6));
        System.out.println("b的无符号右移30位二进制:\t" + getBinaryString(b >>> 30));
        System.out.println("b的无符号右移31位二进制:\t" + getBinaryString(b >>> 31));
        System.out.println("b的无符号右移32位二进制:\t" + getBinaryString(b >>> 32)); //无符号右移32位和不移动是一样的

    }

    static String getBinaryString(int a) {
        String binaryString = Integer.toBinaryString(a);//转成二进制
        String zeroString = "";//补缺少的0
        for (int i = 0; i < 32 - binaryString.length(); i++) {
            zeroString += "0";
        }
        binaryString = zeroString + binaryString; //补上0的二进制
        String regex = "(.{8})";
        binaryString = binaryString.replaceAll(regex, "$1_");
        binaryString = binaryString.substring(0, binaryString.length() - 1);
        return binaryString;
    }

    static int getInt(String a) {
        a = a.replace("_", "");
        char first = a.charAt(0);
        a = a.substring(1);
        int value = Integer.parseInt(a, 2);
        return first == '0' ? value : -value;
    }
}
