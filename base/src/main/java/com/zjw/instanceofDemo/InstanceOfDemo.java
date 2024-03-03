package com.zjw.instanceofDemo;

class Person {
}

class Student extends Person {
}

/**
 * 研究生
 */
class Postgraduate extends Student {
}

public class InstanceOfDemo {
    public static void main(String[] args) {
        instanceofTest(new Person());
    }

    public static void instanceofTest(Person p) {
        /*
			p是类Person的实例
			p是类Object的实例
         */
        if (p instanceof Postgraduate) System.out.println("p是类Postgraduate的实例");
        if (p instanceof Person) System.out.println("p是类Person的实例");
        if (p instanceof Student) System.out.println("p是类Student的实例");
        if (p instanceof Object) System.out.println("p是类Object的实例");

    }
}
