package com.feature.java16;

/**
 * instanceof模式匹配
 * <p>
 * Pattern Matching for instanceof <a href="https://openjdk.org/jeps/394">EJP394</a>
 *
 * @author 朱俊伟
 * @since 2024/03/24 15:28
 */
@SuppressWarnings("all")
public class PatternMatching {
    public static void main(String[] args) {

        Object someNumberType = 2.1;
        // 传统做法
        instanceof_and_cast(someNumberType);
        // 新做法
        pattern_matching(someNumberType);
    }

    public static void pattern_matching(Object someNumberType) {
        if(someNumberType instanceof Integer i) {
            System.out.println("i = " + i);
        } else if (someNumberType instanceof Long l) {
            System.out.println("l = " + l);
        } else if (someNumberType instanceof Double d) {
            System.out.println("d = " + d);
        }
    }

    public static void instanceof_and_cast(Object someNumberType) {
        if(someNumberType instanceof Integer) {
            Integer i = (Integer) someNumberType;
            System.out.println("i = " + i);
        } else if (someNumberType instanceof Long) {
            Long l = (Long) someNumberType;
            System.out.println("l = " + l);
        } else if (someNumberType instanceof Double) {
            Double d = (Double) someNumberType;
            System.out.println("d = " + d);
        }
    }

}
