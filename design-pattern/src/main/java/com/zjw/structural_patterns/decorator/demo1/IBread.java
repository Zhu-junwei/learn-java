package com.zjw.structural_patterns.decorator.demo1;

/**
 * 定于做馒头的接口
 */
public interface IBread {

	/**
	 * 准备材料
	 */
	void prepare();

	/**
	 * 和面
	 */
	void kneadFlour();

	/**
	 * 蒸馒头
	 */
	void steamed();

	/**
	 * 加工馒头(即调用前面三个步骤)
	 */
	void process();
}