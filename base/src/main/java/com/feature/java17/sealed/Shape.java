package com.feature.java17.sealed;

/**
 * sealed 关键字用于限制类或接口的继承性（密闭类、接口），
 * 确保只有指定的类可以实现或扩展这些密封的类型。<a href="https://openjdk.org/jeps/356">EJP406</a>
 *
 * @author 朱俊伟
 * @since 2024/05/13 08:53
 */
// sealed修饰的Shape形状类只能被Circle和Rectangle类继承
// 并且子类需要使用final修饰，或者子类使用sealed，non-sealed修饰
public sealed class Shape permits Circle, Rectangle, Rectangle2 {
}

// 圆形
final class Circle extends Shape {}

// 矩形
sealed class Rectangle extends Shape permits Square { }
// 正方形
final class Square extends Rectangle { }

// 矩形（定义为非密闭类，这样可以不限制子类继承）
non-sealed class Rectangle2 extends Shape{ }
// 六边形
class Hexagon extends Rectangle2 { }
// 八边形
class Octagon extends Rectangle2 { }