package com.zjw.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 如果函数式接口的实现恰好可以通过调用一个类的构造方法实现，那么就可以使用构造方法引用；
 * 语法： 类名::new
 */
public class MethodReferenceTest {
    public static void main(String[] args) {

        DogService dogService = Dog::new;
        Dog dog = dogService.getDog();
        System.out.println(dog);

        DogService2 dogService2 = Dog::new;
        Dog dog2 = dogService2.getDog("狗狗", 2);
        System.out.println(dog2);

        List<Dog> list = new ArrayList<>();
        list.add(new Dog("aa", 1));
        list.add(new Dog("aa", 5));
        list.add(new Dog("aa", 3));
        list.add(new Dog("aa", 4));
        list.add(new Dog("aa", 2));

        //lambda 排序
        list.sort(Comparator.comparingInt(Dog::getAge));
        System.out.println(list);

        //lambda 遍历
        list.forEach(System.out::println);

        //删除年龄大于3的
        list.removeIf(d -> d.getAge() > 3);
        list.forEach(System.out::println);

    }

    interface DogService {
        Dog getDog();
    }

    interface DogService2 {
        Dog getDog(String name, int age);
    }

}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Dog {
    private String name;
    private int age ;
}