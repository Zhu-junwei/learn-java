package com.zjw.proxy;
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