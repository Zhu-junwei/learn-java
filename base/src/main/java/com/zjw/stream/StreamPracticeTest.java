package com.zjw.stream;

import com.zjw.domain.Student;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 最佳实践
 * @author 朱俊伟
 * @since 2023/08/13 23:39
 */
public class StreamPracticeTest {

    /**
     * 从一些整数中找出偶数
     */
    @Test
    public void findEvenTest() {
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] evenArray = Arrays.stream(ints).filter(i ->i % 2 == 0).toArray();
        System.out.println(Arrays.toString(evenArray));
    }

    /**
     * 练习filter toMap
     */
    @Test
    public void parseMapTest() {
        List<String> list = Arrays.asList("zhangsan,23","lisi,24","wangwu,25");
        Map<String, String> stringMap = list.stream()
                .filter(info -> Integer.parseInt(info.split(",")[1]) > 24)
                .collect(Collectors.toMap(
                        info -> info.split(",")[0],
                        info -> info.split(",")[1]
                ));
        System.out.println(stringMap);
    }

    /**
     * 练习filter concat
     *  男同学list 只要名字为三个字的前两个人
     *  女通过list 只要姓杨的第一个人
     *  合并为一个list
     */
    @Test
    public void parseListTest() {
        List<Student> boyList = new ArrayList<>();
        boyList.add(Student.builder().name("张三").age(18).build());
        boyList.add(Student.builder().name("张小三").age(18).build());
        boyList.add(Student.builder().name("王小四").age(18).build());
        List<Student> girlList = new ArrayList<>();
        girlList.add(Student.builder().name("杨幂").age(18).build());
        girlList.add(Student.builder().name("小红").age(18).build());

        Stream<Student> boyStream = boyList.stream()
                .filter(student -> student.getName().length() == 3)
                .limit(2);
        Stream<Student> girlStream = girlList.stream()
                .filter(student -> student.getName().startsWith("杨"))
                .limit(1);
        List<Student> resultList = Stream.concat(boyStream, girlStream)
                .toList();
        System.out.println(resultList);
    }

    /**
     * 修改
     */
    @Test
    public void modifyListTest() {
        List<Student> boyList = new ArrayList<>();
        boyList.add(Student.builder().name("张三").age(18).build());
        boyList.add(Student.builder().name("张小三").age(18).build());
        boyList.add(Student.builder().name("王小四").age(18).build());
        boyList.stream()
                .forEach(student -> {
                   if(student.getName().equals("张三")){
                       student.setAge(1);
                   }
                });
        System.out.println(boyList);
    }


}
