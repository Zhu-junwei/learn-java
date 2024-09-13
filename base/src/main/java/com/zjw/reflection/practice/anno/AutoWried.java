package com.zjw.reflection.practice.anno;

import java.lang.annotation.*;

/**
 * 自定义注解
 */
@Target(ElementType.CONSTRUCTOR)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface AutoWried {

}