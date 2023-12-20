package com.zjw.decorator.demo1;

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