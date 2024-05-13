package com.feature.java17.sealed;

/**
 * sealed 关键字用于限制类或接口的继承性，
 * 确保只有指定的类可以实现或扩展这些密封的类型。<a href="https://openjdk.org/jeps/356">EJP406</a>
 *
 * @author 朱俊伟
 * @since 2024/05/13 08:53
 */
// 修饰的Shape形状类只能被Circle和Rectangle类继承
// 并且子类需要使用final修饰
public sealed class Shape permits Circle, Rectangle {
}

// 圆形
final class Circle extends Shape {}

// 矩形
final class Rectangle extends Shape { }