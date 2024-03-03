package com.zjw.loop;

/**
 * while循环
 * 九九乘法表、倒三角、平行四边形、空心三角
 * 2017-12-24
 * @author Junwei Zhu
 *
 */
public class WhileDemo {
	public static void main(String[] args) {

		/*
			九九乘法表
		 */
		for(int i = 1 ;i<= 9;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(j+"×"+i+"="+i*j+"\t");
			}
			System.out.println();
		}
		System.out.println("_________________________________________________");

		/*
			倒三角
		 */
		for(int i=1;i<=9;i++) {
			for(int j=9-i+1;j>=1;j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("_________________________________________________");

		/*
			平行四边形
		 */
		for(int i=1;i<=5;i++) {
			for(int z=1;z<=i-1;z++) {
				System.out.print(" ");
			}
			for(int j=1;j<=10;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("_________________________________________________");

		for(int i=5;i>=1;i--) {
			for(int j=i;j>=2;j--) {
				System.out.print(" ");
			}
			for(int z=1;z<=10;z++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("_____________________________________________");


		/*
			打印空心三角形
		 */
		int n = 9;
		for(int i=1;i<=n;i++) {
			for(int j=i;j<n;j++) {
				System.out.print(" ");
			}
			for(int m=1;m<=2*i-1;m++) {
				if(m==1||m==2*i-1||i==n&&m%2==1) {
					System.out.print("*");
				}
				else
					System.out.print(" ");
			}
			System.out.println();
		}
//		for(int i=1;i<=n;i++) {
//			for(int j=1;j<=n-1;j++) {
//				System.out.print(" ");
//			}
//			System.out.println("*");
//		}
	}
}


