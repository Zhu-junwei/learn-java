# 代理设计模式

> 有时候对象要完成某项任务（功能）需要很多步骤，而这些步骤全部交给对象自己完成显然是不现实的，就像我们人要吃饭，你总不能要求我们每个人都去种地、打面、做饭一样，我们只需要完成其中的吃饭这一核心操作就可以了，而其他的辅助操作就交给代理Proxy去实现。

我们就拿吃饭这件事完成简单的代理设计模式。

# 代码实现

## 接口定义要完成的核心功能

```java
package proxy;
/**
 * 核心操作
 * 2018-05-19
 */
public interface People {
	public void eat();
}
```
## 完成核心功能的类

```java
package proxy;
/**
 * 完成核心操作的对象
 * 2018-05-19
 */
public class Student implements People {
 
	@Override
	public void eat() {
		System.out.println("***学生在吃饭***");
	}
 
}
```

## 代理类设计
```java
package proxy;
/**
 * 完成辅助操作，并将核心操作交由真实对象完成
 * 2018-05-19
 */
public class Proxy implements People{
 
	private People people ;
	
	//接收一个完成核心操作的对象
	public Proxy(People people) {
		this.people = people;
	}
 
	@Override
	public void eat() {
		this.prepare();//辅助
		this.people.eat();//核心操作由真实对象完成
		this.clean();//辅助
	}
	
	public void prepare() {
		System.out.println("农民伯伯种粮食，餐厅做饭等吃饭前的准备工作。");
	}
	public void clean() {
		System.out.println("餐厅工作人员打扫卫生等收尾工作。");
	}
	
}
```

## 测试代码
```java
package proxy;
/**
 * 测试
 * 2018-05-19
 *
 */
public class TestDemo {
	public static void main(String[] args) {
		//传入完成核心操作的对象
		People people = new Proxy(new Student());
		people.eat();
	}
}
```
结果：

```
农民伯伯种粮食，餐厅做饭等吃饭前的准备工作。
***学生在吃饭***
餐厅工作人员打扫卫生等收尾工作。
```
