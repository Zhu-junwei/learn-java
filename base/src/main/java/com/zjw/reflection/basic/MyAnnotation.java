package com.zjw.reflection.basic;

import java.lang.annotation.*;

/**
 * 自定义注解
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MyAnnotation {

}