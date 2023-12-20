# 工厂设计模式

工厂设计模式是一种创建型设计模式，它提供了一种将对象的实例化过程封装在一个单独的接口或类中的方式，以便在程序中更灵活地创建对象，而不是直接使用构造函数。工厂设计模式有多种变体，其中包括简`单工厂模式`、`工厂方法模式`和`抽象工厂模式`。

```java
// 简单工厂模式示例
public class SimpleFactory {
    public static Product createProduct(String type) {
        if ("A".equals(type)) {
            return new ConcreteProductA();
        } else if ("B".equals(type)) {
            return new ConcreteProductB();
        }
        // 可以添加其他产品类型的判断
        return null;
    }
}

interface Product {
    void doSomething();
}

class ConcreteProductA implements Product {
    @Override
    public void doSomething() {
        System.out.println("Product A is doing something.");
    }
}

class ConcreteProductB implements Product {
    @Override
    public void doSomething() {
        System.out.println("Product B is doing something.");
    }
}

// 客户端使用简单工厂模式
public class Client {
    public static void main(String[] args) {
        Product productA = SimpleFactory.createProduct("A");
        productA.doSomething();

        Product productB = SimpleFactory.createProduct("B");
        productB.doSomething();
    }
}
```