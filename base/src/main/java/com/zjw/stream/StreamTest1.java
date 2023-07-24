package com.zjw.stream;

import com.zjw.classDemo.Person;
import com.zjw.domain.Student;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 测试获取Stream流
 *
 * @author 朱俊伟
 * @date 2023/07/24 0:02
 */
public class StreamTest1 {

    /**
     * 测试数组获取Stream流
     */
    @Test
    public void testArrayStream() {
        System.out.println("int数组获取Stream");
        int[] ints = new int[]{1, 2, 3, 4, 5};
        IntStream intStream = Arrays.stream(ints);
        intStream.forEach(a -> System.out.println(a));


        System.out.println("String数组获取Stream");
        String[] strings = {"a", "b", "c", "d"};
        Stream<String> stringStream = Arrays.stream(strings);
        stringStream.forEach(System.out::println);
    }

    /**
     * 测试Set获取Stream
     */
    @Test
    public void testSetStream(){
        Set<String> stringSet = new HashSet<>();
        stringSet.add("a");
        stringSet.add("b");
        stringSet.add("c");
        Stream<String> setStream = stringSet.stream();
        setStream.forEach(System.out::println);
    }

    /**
     * 测试List获取Stream
     */
    @Test
    public void testListStream(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        Stream<String> listStream = list.stream();
        listStream.forEach(System.out::println);
    }

    /**
     * 测试Map获取Stream
     */
    @Test
    public void testMapStream(){
        Map<String,String> map = new HashMap<>();
        map.put("1", "a");
        map.put("2", "a");
        map.put("3", "a");
        Stream<String> keySetStream = map.keySet().stream();
        keySetStream.forEach(System.out::println);
        Stream<Map.Entry<String, String>> entryStream = map.entrySet().stream();
        entryStream.forEach(System.out::println);
    }

    @Test
    public void testListStream2(){
        List<Student> list = new ArrayList<>();
        list.add(Student.builder().name("a").build());
        list.add(Student.builder().name("b").build());
        list.add(Student.builder().name("c").build());
        List<String> nameList = list.stream().map(Student::getName).collect(Collectors.toList());
        System.out.println(nameList);
    }


}
