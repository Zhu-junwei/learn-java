package com.zjw.reflection.practice;

import com.zjw.reflection.practice.anno.Bean;

/**
 * 定义所有的服务
 *
 * @author 朱俊伟
 * @since 2024/09/04 17:24
 */
public class Config {

    @Bean
    public Customer customer() {
        return new Customer("zjw", "zjw@gmail.com");
    }

    @Bean
    public Address address() {
        return new Address("贝克街", "221B");
    }

    public Message message() {
        return new Message("Hello World!");
    }
}
