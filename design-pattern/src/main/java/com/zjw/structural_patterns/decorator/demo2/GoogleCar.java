package com.zjw.structural_patterns.decorator.demo2;

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