# 单例设计模式

> 一个类只有一个实例，根据创建的时机又分为懒汉式和饿汉式，它们的区别主要体现在实例的创建时机和线程安全性上。

## 饿汉式（Eager Initialization）：

- 特点： 在类加载时就创建实例，因此也被称为饿汉式单例。无论是否需要使用该实例，都会在类加载时创建，因此具有线程安全性。
- 优点： 简单明了，线程安全。
- 缺点： 如果该实例很大，而在程序运行过程中没有被用到，会造成资源浪费。

```java
public class EagerSingleton {
    private static final EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {
        // 私有构造方法
    }

    public static EagerSingleton getInstance() {
        return instance;
    }
}

```

## 懒汉式（Lazy Initialization）：

- 特点： 在需要使用实例时才进行创建，因此被称为懒汉式单例。懒汉式在多线程环境下需要考虑线程安全性，可以通过添加同步锁或使用双重检查锁定等方式实现。
- 优点： 延迟加载，避免了资源浪费。
- 缺点： 需要考虑线程安全性，可能会引入性能开销。

```java
public class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {
        // 私有构造方法
    }

    // 懒汉式，添加同步锁保证线程安全
    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
```

## 双重检查锁定（Double-Checked Locking）：

- 特点： 在懒汉式的基础上引入双重检查，以提高效率。在实例不存在时加锁，然后再次检查实例是否存在，避免每次获取实例都加锁的性能开销。
- 优点： 延迟加载，提高了效率。
- 缺点： 在早期版本的Java中，由于指令重排的问题可能导致线程不安全，需要使用volatile关键字修饰实例变量。

```java
public class DoubleCheckedSingleton {
    private static volatile DoubleCheckedSingleton instance;

    private DoubleCheckedSingleton() {
        // 私有构造方法
    }

    public static DoubleCheckedSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckedSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckedSingleton();
                }
            }
        }
        return instance;
    }
}
```


