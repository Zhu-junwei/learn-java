# 多例设计模式

> 多例设计模式（Multiton Pattern），有时也被称为对象池（Object Pool）模式，是一种创建型设计模式。与单例模式不同，多例模式允许创建并管理多个实例，每个实例都有一个唯一的标识符，可以通过标识符获取对应的实例。每个实例都是预先定义好的有限个数之一。

多例模式主要涉及以下几个要素：

- 私有构造方法： 多例类的构造方法通常是私有的，以防止直接实例化。

- 有限个数的实例： 多例模式管理一组有限个数的实例，每个实例都有一个唯一的标识符。

- 静态实例集合： 多例类通常会维护一个静态的实例集合，用于存储已创建的实例。

- 获取实例的方法： 提供一个方法，根据指定的标识符获取对应的实例。

下面是一个简单的Java示例，演示多例设计模式：

```java
import java.util.HashMap;
import java.util.Map;

/**
 * 多例设计模式
 */
public class Multiton {
    // 静态实例集合
    private static Map<String, Multiton> instances = new HashMap<>();

    // 私有构造方法
    private Multiton() {
        // 初始化操作
    }

    // 获取实例的方法
    public static Multiton getInstance(String key) {
        // 如果实例不存在，则创建并加入集合
        instances.putIfAbsent(key, new Multiton());
        // 返回实例
        return instances.get(key);
    }
}
```