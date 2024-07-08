package com.zjw.lambda.funtion;

import java.util.function.Function;

/**
 * 高阶函数：一个能接受函数作为参数或能把函数当返回值的函数
 * 
 * @author 朱俊伟
 * @date 2024/07/08
 */
public class ProduceFunction {

    // 把函数作为返回值
    static FuncSS produce() {
        return String::toLowerCase;
    }

    // 接受函数作为参数
    static String modifyString(String s, FuncSS function) {
        return function.apply(s);
    }

    public static void main(String[] args) {
        // 使用 produce 方法获取一个函数
        FuncSS f = produce();
        System.out.println(f.apply("YELLING"));

        // 直接使用 produce 返回的函数
        String result = modifyString("YELLING", f);
        System.out.println(result);

        // 使用一个新的函数作为参数
        FuncSS upperCaseFunction = String::toUpperCase;
        String upperCaseResult = modifyString("whispering", upperCaseFunction);
        System.out.println(upperCaseResult);
    }
}

// 自定义函数接口，继承自 Function<String, String>
interface FuncSS extends Function<String, String> {
}