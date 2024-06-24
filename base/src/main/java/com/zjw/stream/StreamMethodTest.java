package com.zjw.stream;

import com.zjw.domain.Student;
import org.junit.jupiter.api.Test;

import java.text.Collator;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 测试Stream中的常见方法
 * filter limit skip distinct concat map sorted peek takeWhile dropWhile
 * <p>
 * mapToInt mapToLong mapToDouble
 * flatMap flatMapToInt flatMapToLong flatMapToDouble
 * mapMulti mapMultiToInt mapMultiToLong mapMultiToDouble
 * parallel unordered onClose sequential
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
     * takeWhile 谓词为真时获取元素，否则停止
     */
    @Test
    public void takeWhileTest() {
        List<Integer> list = List.of(1, 2, 3, 5, 4, 6, 7, 8, 9, 10);
        // 获取集合前面小于5的元素
        list.stream().takeWhile(item -> item < 5)
                .forEach(System.out::println);
    }

    /**
     * dropWhile 谓词为真时丢弃元素，为假时忽略谓词开始处理后续元素
     */
    @Test
    public void dropWhileTest() {
        List<Integer> list = List.of(1, 2, 3, 5, 4, 6, 7, 8, 9, 10);
        // 丢弃集合前面小于5的元素，直到只要遇到大于等于5的元素才处理，并忽略掉条件
        list.stream().dropWhile(item -> item < 5)
                .forEach(System.out::println);
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

        Stream.generate(Math::random)
                .limit(10)
                .peek(e -> System.out.println("生成：" + e))
                .sorted(Comparator.comparing(Double::doubleValue))
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
     * findFirst 找第一个姓"王"的人
     * findAny 找任意一个姓"王"的人
     * anyMatch 判断是否包含姓"王"的人
     * allMatch 判断是否所有姓"王"的人
     * noneMatch 判断没有姓"王"的人
     */
    @Test
    public void findFirstTest() {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌", "周芷若", "王芷若", "李芷若", "赵敏", "王强", "张三丰");
        // 找第一个姓"王"的人
        Optional<String> optional = list.stream()
                .filter(item -> item.startsWith("王"))
                .findFirst();
        System.out.println(optional.orElse("没找到"));
        // 找任意一个姓"王"的人
        Optional<String> findAny = list.stream()
                .filter(item -> item.startsWith("王"))
                .findAny();
        System.out.println("findAny:" + findAny.orElse("没找到"));
        // 判断是否包含姓"王"的人
        boolean anyMatch = list.stream()
                .anyMatch(item -> item.startsWith("王"));
        System.out.println("anyMatch:" + anyMatch);
        // 判断是否所有姓"王"的人
        boolean allMatch = list.stream()
                .allMatch(item -> item.startsWith("王"));
        System.out.println("allMatch:" + allMatch);
        // 判断没有姓"王"的人
        boolean noneMatch = list.stream()
                .noneMatch(item -> item.startsWith("王"));
        System.out.println("noneMatch:" + noneMatch);
    }

    /**
     * max min
     */
    @Test
    public void maxMinTest() {
        // 生成5个随机数
        List<Double> list = Stream.generate(Math::random)
                .peek(e -> System.out.println("生成：" + e))
                .limit(5).toList();
        // stream max获取最大值
        list.stream()
                .max(Comparator.comparing(Double::doubleValue))
                .ifPresent(System.out::println);
        // stream min获取最小值
        list.stream()
                .min(Comparator.comparing(Double::doubleValue))
                .ifPresent(System.out::println);
        // 其他方法获取最大最小
        System.out.println(Collections.max(list));
        System.out.println(Collections.min(list));
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
     * flatMap 将每个元素转换为一个流
     */
    @Test
    public void flatMapTest() {

        List<String> nameList = List.of("张无忌", "周芷若", "张强");
        List<Student> studentList = nameList.stream()
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
    @SuppressWarnings("all")
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
        long count = studentList.stream()
                .filter(student -> student.getName().startsWith("张"))
                .count();
        System.out.println(count);
        System.out.println(studentList.size());
    }

    /**
     * 并行流
     */
    @Test
    public void parallelTest() {
        List<Student> studentList = new ArrayList<>() {{
            add(Student.builder().age(18).name("张无忌").build());
            add(Student.builder().age(18).name("周芷若").build());
            add(Student.builder().age(18).name("张强").build());
        }};

        //count方法计数 .stream().parallel()
        long count = studentList.stream()
                .parallel() // 并行流
                .filter(student -> {
                    System.out.println("student = " + student + Thread.currentThread());
                    return student.getAge() > 10;
                }).count();

        // 方式二 调用parallelStream()
        long count2 = studentList.parallelStream() // 并行流
                .filter(student -> {
                    System.out.println("student = " + student + Thread.currentThread());
                    return student.getAge() > 10;
                }).count();

        System.out.println(count);
        System.out.println(count2);
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
        Object[] objects = studentList.stream()
                .peek(student -> student.setAge(student.getAge() + 1))
                .toArray();
        System.out.println(Arrays.toString(objects));
        Student[] students = studentList.stream().peek(student -> student.setAge(student.getAge() + 1))
                .toArray(Student[]::new);
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
        studentList.stream()
                // valueMapper 返回一个总是返回其输入参数的函数
                .collect(Collectors.toMap(
                        Student::getName,
                        Function.identity()
                )).forEach((k, v) -> System.out.println("key = " + k + " value = " + v));
    }

    /**
     * toMap
     */
    @Test
    public void toMapTest() {
        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
        locales.filter(loc -> !loc.getDisplayLanguage().isEmpty())
                // mergeFunction 函数，用于解决key重复时的处理方式
                .collect(
                        Collectors.toMap(
                                Locale::getDisplayLanguage,
                                loc -> loc.getDisplayLanguage(loc),
                                (existingValue, newValue) -> existingValue))
                .forEach((k, v) -> System.out.println(k + " = " + v));

        System.out.println("*************************");
        // 获取一个国家有哪些语言
        Map<String, Set<String>> countryLanguageMap = Stream.of(Locale.getAvailableLocales())
                .filter(loc -> !loc.getDisplayLanguage().isEmpty())
                .collect(
                        Collectors.toMap(
                                Locale::getDisplayCountry,
                                l -> new HashSet<>(Collections.singleton(l.getDisplayLanguage())),
                                (a, b) ->
                                {
                                    a.addAll(b);
                                    return a;
                                }
                        ));
        countryLanguageMap.forEach((k, v) -> System.out.println(k + " = " + v));
        // 获取一个语言有哪些国家
        Map<String, Set<String>> languageToCountries = Stream.of(Locale.getAvailableLocales())
                .filter(loc -> !loc.getDisplayCountry().isEmpty() && !loc.getDisplayLanguage().isEmpty())
                .collect(
                        Collectors.groupingBy(
                                Locale::getDisplayLanguage,
                                Collectors.mapping(Locale::getDisplayCountry, Collectors.toSet())
                        ));

        languageToCountries.forEach((k, v) -> System.out.println(k + " = " + v));
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

    /**
     * groupingBy练习，统计一个数组中每个元素出现的次数
     */
    @Test
    public void groupingBy2Test() {
        List<Integer> list = Arrays.asList(1, 2, 3, 1, 2, 1);
        Map<Integer, Long> countMap = list.stream()
                .collect(Collectors.groupingBy(
                        i -> i,
                        Collectors.counting()
                ));
        countMap.forEach((k, v) -> System.out.println(k + " : " + v));
    }

    /**
     * partitioningBy 结果划分为两部分
     */
    @Test
    public void partitioningByTest() {
        Locale[] availableLocales = Locale.getAvailableLocales();
        // 拆分使用汉语的和非汉语的
        Map<Boolean, List<Locale>> zhAndOtherLocaleMap = Stream.of(availableLocales)
                .collect(Collectors.partitioningBy(l -> l.getLanguage().equals("zh")));
        List<Locale> zhLocales = zhAndOtherLocaleMap.get(Boolean.TRUE);
        zhLocales.forEach(System.out::println);
        System.out.println("****************");
        List<Locale> otherLocales = zhAndOtherLocaleMap.get(Boolean.FALSE);
        otherLocales.forEach(System.out::println);
    }

    /**
     * reduce 将流中的元素结合起来，生成一个单一的值
     */
    @Test
    public void reduceTest() {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Integer result = integerList.stream()
                .reduce(Integer::sum)
                .orElse(0);
        System.out.println(result);

        Integer result2 = integerList.stream()
                .reduce(0, Integer::sum);
        System.out.println(result2);

    }

    /**
     * summaryStatistic 用于收集统计信息，如count、min、max、sum和average。
     */
    @Test
    public void summaryStatisticTest() {
        // 获取1-10之间的随机数
        Random random = new Random();
        IntSummaryStatistics summaryStatistics = Stream.generate(() -> random.nextInt(1, 10))
                .peek(item -> System.out.println("生成：" + item))
                .limit(10)
                // 获取总结统计
                .collect(Collectors.summarizingInt(Integer::intValue));

        long count = summaryStatistics.getCount();
        long sum = summaryStatistics.getSum();
        double average = summaryStatistics.getAverage();
        int max = summaryStatistics.getMax();
        int min = summaryStatistics.getMin();

        System.out.println("count = " + count);
        System.out.println("sum = " + sum);
        System.out.println("average = " + average);
        System.out.println("max = " + max);
        System.out.println("min = " + min);
        System.out.println(summaryStatistics);

    }

}
