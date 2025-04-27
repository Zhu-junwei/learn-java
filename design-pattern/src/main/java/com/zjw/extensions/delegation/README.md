# 委派设计模式


## 委派 (Delegation)

> 委派（Delegation）是一种设计模式，通常用于实现代码的解耦和复用，本质上不属于传统的GoF 23种设计模式，但它是一种重要的设计原则。委派是指一个对象将自己的部分职责，即一些特定的任务，转交（委派）给其他对象来处理。这种模式允许对象组合实现功能，而不是通过继承。

委派模式的关键特征：
- 封装行为：委派对象持有对另一对象的引用，这个被引用的对象提供了特定的服务或行为。
- 解耦：通过委派，一个类不需要实现所有功能，而是可以利用其他对象的功能。这有助于减少类之间的依赖关系。
- 复用：委派可以在多个不同的类中重用同一个对象，实现代码的复用。

举个例子：
> 假设有一个打印任务类 PrintTask，它可以把打印的细节（例如打印到控制台或文件）委派给另一个类 Printer。PrintTask 只需要告诉 Printer 需要打印什么，而不必关心打印是如何实现的。

负责打印的任务类，负责把打印的细节委派给具体的`PrinterInterface`的打印接口。
```java
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrintTask {

    private PrinterInterface printer;

    public void executePrint(String message) {
        printer.print(message);
    }
}
```

打印接口，定义打印要执行的方法
```java
/**
 * 打印接口
 */
public interface PrinterInterface {
    void print(String message);
}
```

打印接口实现，打印到控制台
```java
/**
 * 控制台打印器
 */
public class ConsolePrinter implements PrinterInterface {
    @Override
    public void print(String message) {
        System.out.println("Printing to console: " + message);
    }
}
```

打印接口实现，打印到文件

```java
/**
 * 文件打印器
 */
public class FilePrinter implements PrinterInterface {
    private String filePath;

    public FilePrinter(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void print(String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(message);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

客户端调用，决定由哪个接口去打印
```java
public class DelegationDemo {
    public static void main(String[] args) {
        PrinterInterface consolePrinter = new ConsolePrinter();
        PrinterInterface filePrinter = new FilePrinter("output.txt");

        PrintTask printTask = new PrintTask();
        // 委派给控制台打印器去执行
        printTask.setPrinter(consolePrinter);
        printTask.executePrint("Hello, printing to console!");

        // 委派给文件打印器去执行
        printTask.setPrinter(filePrinter);
        printTask.executePrint("Hello, printing to file!");
    }
}
```


委派和继承的对比：
- 继承：是一种“是一个”（is-a）关系，子类继承父类的属性和方法。
- 委派：则更多体现为“有一个”（has-a）关系，委派类通过持有另一个类的实例来利用其功能。

**委派模式在许多现代编程语言和框架中都有广泛应用，它有助于创建松耦合、易于维护和扩展的代码结构。**

链接：
https://www.cnblogs.com/zjw-blog/p/17915298.html