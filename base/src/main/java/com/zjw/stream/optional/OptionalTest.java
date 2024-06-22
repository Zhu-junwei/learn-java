package com.zjw.stream.optional;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Optional 测试类
 * 介绍：Optional 是 Java 8 中引入的一个新类，用于处理可能为空的值。
 * 1. Optional 是一个容器类，它可以保存类型 T 的值，或者仅仅保存 null。
 */
public class OptionalTest {

    /**
     * of() 获取Optional
     */
    @Test
    @SuppressWarnings("all")
    public void ofTest() {
        Optional<String> hello = Optional.of("Hello");
        assertTrue(hello.isPresent());
        String string = hello.get();
        assertEquals("Hello", string);

        Optional<Object> empty = Optional.empty();
        assertFalse(empty.isPresent());
        // Object o = empty.get(); // java.util.NoSuchElementException: No value present
    }

    /**
     * ofNullable() 获取Optional
     */
    @Test
    @SuppressWarnings("all")
    public void ofNullableTest() {
        Object value = null;
        // 如果value 为 null，则返回 Optional.empty(), 否则返回 Optional.of(value)
        Optional<Object> optional = Optional.ofNullable(value);
        assertFalse(optional.isPresent());

        value = "hello";
        optional = Optional.ofNullable(value);
        assertTrue(optional.isPresent());
    }

    /**
     * orElse()方法 如果存在值，则返回该值，否则返回其他
     */
    @Test
    @SuppressWarnings("all")
    public void orElseTest() {
        Optional<String> optional = Optional.of("Quince");
        // 如果存在值，则返回该值，否则返回其他
        String result = optional.orElse("No match found");
        assertEquals("Quince", result);

        optional = Optional.empty();
        assertTrue(optional.isEmpty());
        result = optional.orElse("No match found");
        assertEquals("No match found", result);
    }

    /**
     * 测试 Optional 的 ifPresentOrElse 方法
     */
    @Test
    public void ifPresentOrElseTest() {
        Optional<String> startsWithQ = Optional.of("Quince");
        // 如果存在值，则使用该值执行给定的操作，否则执行给定的基于空的操作。
        startsWithQ.ifPresentOrElse(
                word -> assertEquals("Quince", word),
                () -> fail("Expected a word starting with Q but none was found")
        );
    }

    /**
     * filter()
     * 产生一个Optional,如果当前的Optional的值满足给定的谓词条件， 那么所产生的
     * Optional的值就是当前Optional的值； 否则， 产生一个空Optional。
     */
    @Test
    @SuppressWarnings("all")
    public void filterTest() {
        Optional<String> optional = Optional.of("OpenAI");
        // 过滤条件为字符串长度大于3
        Optional<String> filteredOptional = optional.filter(value -> value.length() > 3);
        // 输出: Filtered value: OpenAI
        assertEquals(filteredOptional.get(), "OpenAI");

        // 过滤条件为字符串长度大于10
        Optional<String> emptyOptional = optional.filter(value -> value.length() > 10);
        assertFalse(emptyOptional.isPresent());
    }

    /**
     * map()
     * 产生一个Optional,如果当前的Optional的值存在， 那么所产生的Optional的值是通
     * 过将给定的函数应用于当前的Optional的值而得到的； 否则产生一个空的Optional。
     */
    @Test
    @SuppressWarnings("all")
    public void mapTest() {
        Optional<String> optional = Optional.of("OpenAI");

        // 将值转换为大写
        Optional<String> mappedOptional = optional.map(String::toUpperCase);
        assertEquals(mappedOptional.get(), "OPENAI");

        // 空的 Optional
        Optional<String> emptyOptional = Optional.empty();
        Optional<String> result = emptyOptional.map(String::toUpperCase);
        assertFalse(result.isPresent());
    }

    /**
     * or()
     */
    @Test
    public void orTest() {
        Optional<String> emptyOptional = Optional.empty();
        Optional<String> helloOptional = Optional.of("Hello");
        // 如果当前Optional不为空， 则产生当前的Optional； 否则由supplier产生一个Optional
        Optional<String> result = emptyOptional.or(() -> helloOptional);
        assertEquals(result.get(), "Hello");
    }

    /**
     * flatMap()
     * 如果Optional存在， 产生将mapper应用于当前Optional值所产生的结果， 或者在当前
     * Optional为空时， 返回一个空Optional。
     */
    @Test
    public void flatMapTest() {
        // 计算一个数的倒数的平方根
        Optional<Double> result = inverse(2.0).flatMap(this::squareRoot);
        Double v = result.orElse(0.0D);
        System.out.println("v = " + v);
    }

    // 计算倒数
    public Optional<Double> inverse(Double x) {
        return x == 0 ? Optional.empty() : Optional.of(1 / x);
    }
    // 计算平方根
    public Optional<Double> squareRoot(Double x) {
        return x < 0 ? Optional.empty() : Optional.of(Math.sqrt(x));
    }


}
