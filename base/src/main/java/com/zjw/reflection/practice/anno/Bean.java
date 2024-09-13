package com.zjw.reflection.practice.anno;

import java.lang.annotation.*;

/**
 * 自定义注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Bean {

}