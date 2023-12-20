package com.zjw.decorator.demo1;

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