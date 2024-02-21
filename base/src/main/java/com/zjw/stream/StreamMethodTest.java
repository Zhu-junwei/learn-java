package com.zjw.stream;

import com.zjw.domain.Student;
import org.junit.jupiter.api.Test;

import java.text.Collator;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 测试Stream中的常见方法
 *  filter limit skip distinct concat map sorted peek takeWhile dropWhile
 * <p>
 *  mapToInt mapToLong mapToDouble
 *  flatMap flatMapToInt flatMapToLong flatMapToDouble
 *  mapMulti mapMultiToInt mapMultiToLong mapMultiToDouble
 *  parallel unordered onClose sequential
 *
 * @author 朱俊伟
 * @since 2023/07/23 23:20
 */
public class StreamMethodTest {

    /**
     * filter方法过滤需要的数据
     */
    @Test
    public void filterTest() {
        /*
         * 创建集合添加元素，完成以下需求:
         * 	1.把所有以“张”开头的元素存储到新集合中
         * 	2.把“张”开头的，长度为3的元素再存储到新集合中
         * 	3.遍历打印最终结果
         */
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌", "周芷若", "赵敏", "张强", "张三丰");
        //1.把所有以“张”开头的元素存储到新集合中
        List<String> list2 = new ArrayList<>();
        for (String str : list) {
            if (str.startsWith("张"))
                list2.add(str);
        }
        System.out.println(list2);
        //2.把“张”开头的，长度为3的元素再存储到新集合中
        List<String> list3 = new ArrayList<>();
        for (String str : list2) {
            if (str.length() == 3)
                list3.add(str);
        }
        System.out.println(list3);

        System.out.println("*******使用stream操作*********");
//        list.stream().filter(str -> str.startsWith("张")).forEach(str -> System.out.println(str));
        List<String> list22 = list.stream().filter(str -> str.startsWith("张")).toList();
        System.out.println(list22);
        List<String> list33 = list22.stream().filter(item -> item.length() == 3).toList();
        System.out.println(list33);
    }

    /**
     * limit获取前几个元素
     */
    @Test
    public void limitTest() {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌", "周芷若", "赵敏", "张强", "张三丰", "张翠山", "张良", "王二麻子", "谢广坤");
        System.out.println(list);
        //获取前三个元素
        List<String> limitList = list.stream()
                .limit(3)
                .toList();
        System.out.println(limitList);
    }

    /**
     * skip跳过前几个元素
     */
    @Test
    public void skipTest() {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌", "周芷若", "赵敏", "张强", "张三丰", "张翠山", "张良", "王二麻子", "谢广坤");
        System.out.println(list);
        //获取前四个元素
        List<String> skipList = list.stream()
                .skip(4)
                .toList();
        System.out.println(skipList);
    }

    /**
     * distinct去重
     */
    @Test
    public void distinctTest() {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌", "周芷若", "周芷若", "周芷若", "赵敏", "张强", "张三丰");
        //去除重复元素，如果存放的是对象，需要重写equals hashcode
        List<String> distinctList = list.stream().distinct().toList();
        System.out.println(distinctList);
    }

    /**
     * sorted排序
     */
    @Test
    public void sortedTest() {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌", "周芷若", "周芷若", "李芷若", "赵敏", "王强", "张三丰");
        //sorted排序
        list.stream()
                .distinct()
                // 按照拼音排序
                .sorted((n1, n2) -> Collator.getInstance(Locale.CHINA).compare(n1, n2))
                .forEach(System.out::println);
    }

    /**
     * peek查看管道中流过的元素
     */
    @Test
    public void peekTest() {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌", "周芷若", "周芷若", "李芷若", "赵敏", "王强", "张三丰");
        //sorted排序
        List<String> sortedList = list.stream()
                // 查看管道中流过的元素
                .peek(System.out::println)
                .distinct()
                .sorted((n1, n2) -> Collator.getInstance(Locale.CHINA).compare(n1, n2))
                .toList();
        System.out.println(sortedList);
    }

    /**
     * concat合并流
     */
    @Test
    public void concatTest() {
        List<String> list1 = new ArrayList<>();
        Collections.addAll(list1, "张无忌", "周芷若");
        List<String> list2 = new ArrayList<>();
        Collections.addAll(list2, "赵敏", "张强", "张三丰");
        //合并两个流
        List<String> concatList = Stream.concat(list1.stream(), list2.stream()).toList();
        System.out.println(concatList);
    }

    /**
     * stream map方法
     */
    @Test
    public void mapTest() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(Student.builder().age(18).name("张无忌").build());
        studentList.add(Student.builder().age(18).name("周芷若").build());
        studentList.add(Student.builder().age(18).name("张强").build());
        //获取所有同学的名字
        List<String> nameList = studentList.stream().map(Student::getName).toList();
        System.out.println(nameList);
        //获取age+1的所有同学年龄
        List<Integer> ageAddList = studentList.stream()
                .map(student -> student.getAge() + 1)
                .toList();
        System.out.println(ageAddList);
    }

    /**
     * flatMap 拆分为一对多
     */
    @Test
    public void flatMapTest() {

        String[] names = {"张无忌", "周芷若", "张强"};
        List<Student> studentList = Stream.of(names)
                .map(name -> Student.builder()
                        .age(18)
                        .name(name)
                        .build())
                .toList();
        //将名字拆分为姓和名
        studentList.stream()
                .flatMap(student -> Stream.of(student.getName().substring(0, 1), student.getName().substring(1)))
                .forEach(System.out::println);
    }

    /**
     * stream forEach方法遍历
     */
    @Test
    public void forEachTest() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(Student.builder().age(18).name("张无忌").build());
        studentList.add(Student.builder().age(18).name("周芷若").build());
        studentList.add(Student.builder().age(18).name("张强").build());
        //forEach会改变集合中的内容
        studentList.stream().forEach(student -> {
            student.setAge(student.getAge() + 1);
            System.out.println(student);
        });
        //发现集合中对象的值被改变了
        System.out.println(studentList);
    }

    /**
     * stream count方法计数
     */
    @Test
    public void countTest() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(Student.builder().age(18).name("张无忌").build());
        studentList.add(Student.builder().age(18).name("周芷若").build());
        studentList.add(Student.builder().age(18).name("张强").build());
        //count方法计数
        long count = studentList.stream().count();
        System.out.println(count);
        System.out.println(studentList.size());
    }

    /**
     * 并发流
     */
    @Test
    public void parallelTest() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(Student.builder().age(18).name("张无忌").build());
        studentList.add(Student.builder().age(18).name("周芷若").build());
        studentList.add(Student.builder().age(18).name("张强").build());
        //count方法计数
        long count = studentList.stream()
                .parallel() // 并发流
                .filter(student -> {
                    System.out.println("student = " + student + Thread.currentThread());
                    return student.getAge() > 10;
                }).count();
        System.out.println(count);
        System.out.println(studentList.size());
    }

    /**
     * stream toArray 转为数组
     */
    @Test
    public void toArrayTest() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(Student.builder().age(18).name("张无忌").build());
        studentList.add(Student.builder().age(18).name("周芷若").build());
        studentList.add(Student.builder().age(18).name("张强").build());
        Object[] objects = studentList.stream().toArray();
        System.out.println(Arrays.toString(objects));
        Student[] students = studentList.stream().toArray(Student[]::new);
        System.out.println(Arrays.toString(students));
    }

    /**
     * collect转为集合
     */
    @Test
    public void collectTest() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(Student.builder().age(17).name("张无忌").build());
        studentList.add(Student.builder().age(18).name("周芷若").build());
        studentList.add(Student.builder().age(19).name("张强").build());
        //年龄>=18岁的转成list
        List<Student> collectList = studentList.stream()
                .filter(student -> student.getAge() >= 18)
                .collect(Collectors.toList());
        System.out.println(collectList);
        //年龄>=18岁的转成set
        Set<Student> collectSet = studentList.stream()
                .filter(student -> student.getAge() >= 18)
                .collect(Collectors.toSet());
        System.out.println(collectSet);
        //list转为name为key student为值的map 注意：key不能重复（实际中可以使用id）
        Map<String, Student> collectMap = studentList.stream()
                .collect(Collectors.toMap(
                        Student::getName,
                        student -> student
                ));
        System.out.println(collectMap);
    }

    /**
     * groupingBy练习
     */
    @Test
    public void groupingByTest() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(Student.builder().age(17).name("张无忌").build());
        studentList.add(Student.builder().age(18).name("周芷若").build());
        studentList.add(Student.builder().age(19).name("张强").build());
        studentList.add(Student.builder().age(19).name("王强").build());
        //将集合转为以age作为key的Map
        Map<Integer, List<Student>> ageMap = studentList.stream()
                .collect(Collectors.groupingBy(
                        Student::getAge
                ));
        System.out.println(ageMap);
    }

}
