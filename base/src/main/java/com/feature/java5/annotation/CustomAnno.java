package com.feature.java5.annotation;

import java.lang.annotation.*;

/**
 * 自定义注解
 *
 * <p>{@code @Target(ElementType.TYPE)} 可以应用于类、接口（包括注解类型）或枚举声明。
 * <p>{@code @Retention(RetentionPolicy.RUNTIME)} 注解在运行时被保留，可以通过反射机制读取注解的信息。
 * <p>{@code @Documented} 指示将此注解包含在Javadoc中，没有特定的取值。
 * <p>{@code @Inherited} 指示子类可以继承父类中的注解，没有特定的取值。
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface CustomAnno {

    String name();

    int[] month();

}
