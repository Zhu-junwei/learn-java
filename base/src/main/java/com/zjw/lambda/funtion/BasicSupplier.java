package com.zjw.lambda.funtion;

import java.lang.reflect.InvocationTargetException;
import java.util.function.Supplier;

/**
 * Supplier生成器：
 * 可以为任何具有无参构造器的类生成一个 Supplier
 *
 * @author 朱俊伟
 * @since 2024/09/29 22:41
 */
public class BasicSupplier<T> implements Supplier<T> {

    private Class<T> clazz;

    public BasicSupplier(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T get() {
        try {
            return clazz.getConstructor().newInstance();
        } catch (InstantiationException |
                 NoSuchMethodException |
                 InvocationTargetException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    // 基于类型标记生成默认的 Supplier：
    public static <T> Supplier<T> create(Class<T> type) {
        return new BasicSupplier<>(type);
    }

    public static void main(String[] args) {
        Supplier<String> s = BasicSupplier.create(String.class);
        System.out.println(s.get());
    }
}
