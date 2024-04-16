package com.zjw.debug;

/**
 * 断点调试技巧： <a href="https://www.bilibili.com/video/BV1ur4y1P7SV">参考<a />
 * @author 朱俊伟
 * @since 2024/04/16 22:55
 */
@SuppressWarnings("all")
public class BreakPointer {
    public static void main(String[] args) {
///        normalPointer();
///        detailPointer();
        methodPointer();
///        methodPointer2();
///        exceptionPointer();
//        filedPointer();
    }

    /**
     * 普通断点
     * 要停止的行前左键打一个点
     */
    public static void normalPointer() {
        System.out.println("normalPointer....");
    }

    /**
     * 详细断点
     * 在行前Shift + 左键打一个点，弹出断点可以配置的选项
     */
    public static void detailPointer() {
        System.out.println("detailPointer....");
    }


    /**
     * 方法断点
     * 在方法前打一个点，可以在方法进入第一行时停止，在方法返回时停止
     * 但是我的这个方法为什么没有在结束之前停止呢？
     */
    public static void methodPointer() {
        int a = 10;
        int b = 20;
        int c = a + b;
        System.out.println("methodPointer...." + c);
    }

    /**
     * 方法断点2
     * 在接口的方法前打一个断点，会在方法的实现类方法上停止。
     * 但是没有停止。。。
     */
    public static void methodPointer2() {
        MyInterface myInterface = new MyInterfaceImpl();
        System.out.println("methodPointer2....");
    }

    /**
     * 异常断点
     * 在断点调试界面点击`view breakpoints`，点击添加`Java Exception Breakpoint`，添加需要捕获的异常类型，即可捕获该异常类型。
     */
    public static void exceptionPointer() {
        String str = null;
        int length = str.length();
        System.out.println(length);
    }

    /**
     * 字段断点
     * 在变量前打一个点，可以监控变量的变化。
     */
    public static void filedPointer() {
        Person person = new Person("Tom", 20);
        person.setName("Jerry");
        System.out.println(person.toString());
    }

    @SuppressWarnings("lombok")
    public static class Person {
        private String name;
        private int age;


        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}





