package com.zjw.proxy;
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