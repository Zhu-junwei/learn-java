package com.zjw.baseType;
/**
 * 数据类型：整形、浮点型、字符型、布尔型
 * @since 2017-12-26
 * @author Junwei Zhu
 *
 */
public class TypeTest {
	public static void main(String[] args) {
		 byte bt = 12 ; 	//1字节
		 short sh = 42 ;	//2字节
		 int in = 64 ;		//4字节
		 long lo = 456L ;	//8字节
		 
		 System.out.println("byte型\t bt="+bt);
		 System.out.println("short型 \t sh="+sh);
		 System.out.println("int型\t in="+in);
		 System.out.println("lo型\t lo="+lo);
		 
		 int i1 = 012;	//八进制
		 int i2 = 0xA;	//十六进制
		 
		 //Java7开始可以使用二进制
		 int i3 = 0b1010;//二进制
		 int i4 = 0b1010_1010;
		 
		 System.out.println(i1);
		 System.out.println(i2);
		 System.out.println(i3);
		 System.out.println(i4);
		 
		 //浮点数采用二进制表示，不能精确表小数
		 System.out.println(2.0-1.1);
		 
		 //字符型
		 char ch = 'A';
		 System.out.println(ch);
		 System.out.println((int)ch);
		 
		 boolean bool = true ;
		 System.out.println(bool);
		 
	}
}
