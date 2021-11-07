package com.zjw.lambda;

/**
 * 如果函数式接口的实现恰好可以通过调用一个类的构造方法实现，那么就可以使用构造方法引用；
 * 语法： 类名::new
 */
public class Lambda05
{
    public static void main(String[] args) {

        DogService dogService = Dog::new;
        Dog dog = dogService.getDog();
        System.out.println(dog);

        DogService2 dogService2 = Dog::new;
        Dog dog2 = dogService2.getDog("狗狗", 2);
        System.out.println(dog2);


    }

    interface DogService{
        Dog getDog();
    }

    interface DogService2{
        Dog getDog(String name , int age );
    }

}