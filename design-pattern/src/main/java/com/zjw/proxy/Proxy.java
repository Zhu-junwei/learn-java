package com.zjw.proxy;
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