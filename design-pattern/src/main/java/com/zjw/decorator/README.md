# 装饰者模式

## 简介

**装饰者模式的主要功能就是对一个类的功能进行扩充！**

对于需要对某个类扩充，但是该类是final类，不能被继承，这是时候可以用装饰者模式来实现。

要实现装饰者模式,注意一下几点内容:

- 1.装饰者类要实现真实类同样的接口

- 2.装饰者类内有一个真实对象的引用(可以通过装饰者类的构造器传入)

- 3.装饰类对象在主类中接受请求,将请求发送给真实的对象(相当于已经将引用传递到了装饰类的真实对象)

- 4.装饰者可以在传入真实对象后,增加一些附加功能(因为装饰对象和真实对象都有同样的方法,装饰对象可以添加一定操作在调用真实对象的方法,或者先调用真实对象的方法,再添加自己的方法)

- 5.不用继承

## 做馒头实例

1、如果有一个做馒头的接口IBread，定义了做馒头的标准。

2、做正常馒头需要实现这个接口，实现里面的方法。

3、我们有个要做“甜蜜素”的甜馒头需求，就需要对做正常馒头的类的功能加强。

IBread接口

> 做馒头的接口，包括准备材料,和面,蒸馒头,加工馒头(即调用前面三个步骤)

```java
/**
 * 定于做馒头的接口
 */
public interface IBread {
    //准备材料
    void prepare();
    //和面
    void kneadFlour();
    //蒸馒头
    void steamed();
    //加工馒头(即调用前面三个步骤)
    void process();
}
```

NormalBread类，做正常馒头
```java
/**
 * 正常做馒头
 */
public class NormalBread implements IBread {

    // 准备材料
    @Override
    public void prepare() {
        System.out.println("准备面粉,水以及发酵粉...");
    }
    // 和面
    @Override
    public void kneadFlour() {
        System.out.println("和面...");
    }

    // 蒸馒头
    @Override
    public void steamed() {
        System.out.println("蒸馒头...香喷喷的馒头出炉了");
    }

    // 加工馒头(即调用前面三个步骤)
    @Override
    public void process() {
        prepare();
        kneadFlour();
        steamed();
    }
}
```

AbstractBread抽象类
> 定义制作馒头的抽象类，不做具体实现，只是调用`IBread`接口的方法

```java
/**
 *  定义制作馒头的抽象类
 */
public abstract class AbstractBread implements IBread {

    private final IBread bread;

    public AbstractBread(IBread bread) {
        super();
        this.bread = bread;
    }

    @Override
    public void prepare() {
        this.bread.prepare();
    }
    @Override
    public void kneadFlour() {
        this.bread.kneadFlour();
    }
    @Override
    public void steamed() {
        this.bread.steamed();
    }

    @Override
    public void process() {
        prepare();
        kneadFlour();
        steamed();
    }
}
```

SweetDecorator类
> 增强的普通馒头的甜馒头类

```java
public class SweetDecorator extends AbstractBread {
 
    public SweetDecorator(IBread bread) {
        super(bread);
    }
 
    public void paint(){
        System.out.println("添加甜蜜素...");
    }
    
    @Override
    public void kneadFlour() {
        //添加甜蜜素后和面
        this.paint();
        super.kneadFlour();
    }
    
}
```

TestDemo测试类

> 通过创建装饰类（SweetDecorator），传入未增强的对象（NormalBread）来实现对象的功能（方法）增强。

```java
public class TestDemo {
	public static void main(String[] args) {
		
		//生产正常的馒头
		System.out.println("【开始】生产正常的馒头");
		NormalBread normalBread = new NormalBread();
		normalBread.process();
		System.out.println("【结束】生产正常的馒头\n\n");
 
		//生产含有甜蜜素的"甜馒头"
		System.out.println("【开始】生产甜馒头");
		IBread sweetDBread = new SweetDecorator(normalBread);
		sweetDBread.process();
		System.out.println("【结束】生产甜馒头");
	}
}
```

打印结果
```
【开始】生产正常的馒头
准备面粉,水以及发酵粉...
和面...
蒸馒头...香喷喷的馒头出炉了
【结束】生产正常的馒头
 
 
【开始】生产甜馒头
准备面粉,水以及发酵粉...
添加甜蜜素...
和面...
蒸馒头...香喷喷的馒头出炉了
【结束】生产甜馒头
```

## 生产汽车实例

现在有一个生产汽车的接口，定义了汽车的标准（启动、运行、停止）。

Google汽车对这个接口进行了实现，并定义成了final类（不让别人动我的东西）。

然后需求来了，我们需要对这个Google汽车的功能进行增强，但是发现Google这个final类，不能被继承，这个时候就需要用到装饰者模式。

我们需要定义一个装饰类，这个类实现了Google汽车实现的接口，在这个装饰类中定义了一个Google汽车类的对象，在装饰类实例化的时候传入一个Google汽车类。有这个汽车类在实现的接口中调用方法，在需要增强的方法中再修改。

ICar接口
> 生产汽车的接口
```java
/**
 * 生产汽车的接口
 */
public interface ICar {
    void start();
    void run();
    void stop();
}
```

GoogleCar实现的类
```java
//相当于mysql驱动包,谷歌汽车开发人员实现类
public final class GoogleCar implements ICar{
 
	@Override
	public void start() {
		
		System.out.println("控制谷歌的汽车启动");
		//调用谷歌汽车提供的C语言函数
	}
 
	@Override
	public void run() {
		System.out.println("控制谷歌的汽车运行");
		
	}
 
	@Override
	public void stop() {
		System.out.println("控制谷歌的汽车停止");
	}
 
}
```

增强汽车MyCar类
```java
public class MyCar implements ICar{
 
	
	ICar car;
	
	public MyCar(ICar car) {
		this.car=car;
	}
	
	@Override
	public void start() {
		System.out.println("检查天气是否良好");
		System.out.println("检查路况是否拥堵");
		car.start();
	}
 
	@Override
	public void run() {
		car.run();		
	}
 
	@Override
	public void stop() {
		car.stop();		
	}
 
}
```
测试类
```java
public class TestCar {
	public static void main(String[] args) {
		 ICar car=new MyCar(new GoogleCar());
		 car.start();
		 car.run();
		 car.stop();
	}
}
```

运行结果
```
检查天气是否良好
检查路况是否拥堵
控制谷歌的汽车启动
控制谷歌的汽车运行
控制谷歌的汽车停止
```

# 常见使用

- Java 中的 InputStream 和 OutputStream 就是一个常见的装饰者模式的例子，通过不同的装饰者（如BufferedInputStream、DataInputStream）来增强基本的输入输出流功能。

- Spring 框架中，AOP（Aspect-Oriented Programming）的实现机制就可以看作是一种装饰者模式，通过动态代理和切面（Aspect）来在不修改原有代码的基础上增加功能。

在这些例子中，都能看到装饰者模式的核心思想，即通过组合而非继承的方式，对对象的功能进行动态扩展。

`BufferedOutputStream` 是 `OutputStream` 的装饰者，通过在原始输出流上添加缓冲功能来提高性能。
```java
// 创建原始的 OutputStream
OutputStream fileOutputStream = new FileOutputStream("example.txt");

// 使用装饰者 BufferedOutputStream 对原始流进行装饰
OutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

// 使用 BufferedOutputStream 写入数据
String message = "Hello, Decorator Pattern!";
bufferedOutputStream.write(message.getBytes());

// 关闭流
bufferedOutputStream.close();
```

链接：
https://www.cnblogs.com/zjw-blog/p/17792001.html