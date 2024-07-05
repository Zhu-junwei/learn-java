package com.zjw.type.baseType;

import org.junit.jupiter.api.Test;

/**
 * 基本数据类型
 *
 * @author 朱俊伟
 * @since 2022/02/07 20:58
 */
public class BaseTypeTest {

    /**
     * 数据类型 整形、浮点型、字符型、布尔型
     */
    @Test
    public void baseTest() {
        byte bt = 12;       // 1 字节
        short sh = 42;      // 2 字节
        int in = 64;        // 4 字节
        long lo = 456L;     // 8 字节

        System.out.println("byte型\t bt=" + bt);
        System.out.println("short型 \t sh=" + sh);
        System.out.println("int型\t in=" + in);
        System.out.println("lo型\t lo=" + lo);

        int i1 = 012;    //八进制
        int i2 = 0xA;    //十六进制

        //Java7开始可以使用二进制
        int i3 = 0b1010;//二进制
        int i4 = 0b1010_1010;

        System.out.println(i1);
        System.out.println(i2);
        System.out.println(i3);
        System.out.println(i4);

        //浮点数采用二进制表示，不能精确表小数
        System.out.println(2.0 - 1.1);

        //字符型
        char ch = 'A';
        System.out.println(ch);
        System.out.println((int) ch);

        boolean bool = true;
        System.out.println(bool);
    }

    /**
     * UniCode编码表 <a href="https://blog.csdn.net/tgvincent/article/details/93884725">...</a>
     */
    @Test
    public void testChar() {
        char c1 = 'A';
        System.out.println(c1);
        //۞ 使用UniCode编码表示字符
        char c2 = '\u06de';
        System.out.println(c2);

        // 表示一个超出 '\uffff' 范围的Unicode字符 (例如，笑脸表情符号)
        int codePoint = 0x1F600; // 笑脸表情符号 😀
        char[] charArray = Character.toChars(codePoint);
        // 合并打印完整字符
        System.out.println(new String(charArray));
    }

    /**
     * printAllChar
     */
    @Test
    public void printAllCharTest() {
        int count = 0;
        for (char c = Character.MIN_VALUE; c <= Character.MAX_VALUE - 1; c++) {
            System.out.print(c + " "); // 打印字符
            count++;
            // 每行打印50个字符后换行
            if (count % 50 == 0) System.out.println(); // 换行
        }
    }

    @Test
    public void printAllEmojis() {
        // Unicode范围：表情符号
        int[][] emojiRanges = {
                {0x1F600, 0x1F64F}, // 表情符号
                {0x1F900, 0x1F9FF}, // 补充象形符号及图形符号
                {0x1F680, 0x1F6FF}, // 交通和地图符号
                {0x1F300, 0x1F5FF}, // 杂项符号及图形符号
                {0x2700, 0x27BF},   // 装饰符号
                {0x1F800, 0x1F8FF}, // 补充箭头-C
                {0x2B00, 0x2BFF},   // 各种符号和箭头
                {0x1FA00, 0x1FA6F}  // 象棋符号
        };

        int count = 0; // 计数器，用于控制每行打印的字符数
        for (int[] range : emojiRanges) {
            for (int codePoint = range[0]; codePoint <= range[1]; codePoint++) {
                // 将代码点转换为字符数组
                char[] chars = Character.toChars(codePoint);
                System.out.print(new String(chars) + " ");
                count++;
                // 每行打印50个字符后换行
                if (count % 50 == 0) {
                    System.out.println();
                }
            }
        }
    }

    /**
     * 测试double相加精度损失
     */
    @Test
    public void testDoubleAdd() {
        System.out.println(1.23 + 1.45);
    }
}
