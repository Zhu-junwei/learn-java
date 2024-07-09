package com.zjw.exception;

/**
 * 自定义异常测试
 *
 * @author 朱俊伟
 * @date 2024/07/11
 */
public class InheritingExceptions {
    private void f() throws SimpleException {
        System.out.println("Throw SimpleException from f()");
        throw new SimpleException();
    }

    public static void main(String[] args) {
        var sed = new InheritingExceptions();
        try {
            sed.f();
        } catch (SimpleException e) {
            System.out.println("Caught it!");
        }
    }
}

/**
 * 自定义异常类
 *
 * @author 朱俊伟
 * @date 2024/07/11
 */
class SimpleException extends Exception {
    // 自己生成默认的构造方法
}


