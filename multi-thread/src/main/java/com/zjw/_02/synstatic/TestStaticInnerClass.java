package com.zjw._02.synstatic;

import lombok.Data;

/**
 * 静态内部类
 * @author 朱俊伟
 * @since 2023/03/02 0:05
 */
public class TestStaticInnerClass {
    public static void main(String[] args) {
        PublicClass publicClass = new PublicClass();
        publicClass.setUsername("张三");
        publicClass.setPassword("123456");
        System.out.println(publicClass);

        PublicClass.InnerClass innerClass= new PublicClass.InnerClass();
        innerClass.setAge("18");
        innerClass.setAddress("上海");
        System.out.println(innerClass);

    }
}

@Data
class PublicClass {

    private String username;
    private String password;

    @Data
    static class InnerClass {
        private String age;
        private String address;
    }

}
