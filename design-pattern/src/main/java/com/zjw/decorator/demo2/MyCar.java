package com.zjw.decorator.demo2;

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