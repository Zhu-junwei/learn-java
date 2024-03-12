package com.zjw.collection.list;


import com.zjw.domain.Student;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 测试 ArrayList
 *
 * @author 朱俊伟
 * @since 2022/08/15
 */
public class ArrayListTest {

    /**
     * 测试添加元素add()
     */
    @Test
    public void testAdd() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list);
    }

    /**
     * 测试Collections.addAll方法向list中添加元素
     */
    @Test
    public void testAddAll() {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "a", "b", "c");
        System.out.println(list);
    }

    /**
     * 添加元素到指定位置
     */
    @Test
    public void testAddIndex() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println("添加前:" + list);
        list.add(1, "d");//其位置元素先后移
        System.out.println("添加后:" + list);
    }

    /**
     * 添加元素到头部 jdk21后支持
     */
    @Test
    public void testAddFirst() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println("添加前:" + list);
        list.addFirst("d");//其位置元素先后移
        System.out.println("添加后:" + list);
    }

    /**
     * 添加元素到尾部 jdk21后支持
     */
    @Test
    public void testAddLast() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println("添加前:" + list);
        list.addLast("d");
        System.out.println("添加后:" + list);
    }

    /**
     * 测试set()方法,将此列表中指定位置的元素替换为指定元素
     */
    @Test
    public void testSet() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println("添加前:" + list);
        String oldVal = list.set(0, "A");//索引0位置元素被替换
        System.out.println("被替换的元素:" + oldVal);//返回被替换的元素
        System.out.println("添加后:" + list);
    }

    /**
     * 测试删除单个首次出现的元素
     */
    @Test
    public void testRemove() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println("删除前:" + list);
        list.remove("a");//只会删除第一个出现的元素
        System.out.println("删除后:" + list);
    }

    /**
     * 测试删除所有指定的元素
     */
    @Test
    public void testRemoveAll() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println("删除前:" + list);
        list.removeAll(Arrays.asList("a", "b"));//删除除所有指定的元素
        System.out.println("删除后:" + list);
    }

    /**
     * 删除指定位置的元素
     */
    @Test
    public void testRemoveIndex() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println("删除前:" + list);
        list.remove(1);//删除指定位置上的元素
        System.out.println("删除后:" + list);
    }

    /**
     * 测试get() 返回列表中指定位置的元素
     */
    @Test
    public void testGet() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list.get(0));
    }

    /**
     * 判断集合是否为空
     */
    @Test
    public void testEmpty() {
        List<String> list = new ArrayList<>();
        System.out.println(list.isEmpty());
        list.add("a");
        System.out.println(list.isEmpty());
    }

    /**
     * 清空集合
     */
    @Test
    public void testClear() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println("清空前:" + list);
        list.clear();//添加前: [a, b, c]
        System.out.println("清空后:" + list);
        System.out.println("清空后:" + list.size());
    }

    /**
     * 获取集合的大小
     */
    @Test
    public void testSize() {
        List<String> list = new ArrayList<>();
        System.out.println(list.size());
        list.add("a");
        System.out.println(list.size());
    }

    /**
     * 判断是否包含某个元素
     */
    @Test
    public void testContains() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list.contains("a"));
        System.out.println(list.contains("d"));
    }

    /**
     * containsAll方法 集合中是否包含另外一个集合中所有元素，包含返回true,有不包含的返回false
     */
    @Test
    public void containsAll() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        //另外一个集合
        List<String> containsList = new ArrayList<>();
        containsList.add("a");
        containsList.add("b");
        boolean contains = list.containsAll(containsList);
        System.out.println(contains);
    }

    /**
     * 判断元素在集合中首次出现的位置
     */
    @Test
    public void testIndexOf() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        //返回指定元素在此列表中第一次出现的索引，如果此列表不包含该元素，则返回-1
        System.out.println(list.indexOf("a"));//0
        System.out.println(list.indexOf("d"));//-1
    }

    /**
     * 判断元素在集合中最后出现的位置
     */
    @Test
    public void testLastIndexOf() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("a");
        list.add("b");
        list.add("c");
        //返回指定元素在此列表中最后出现的索引，如果此列表不包含该元素，则返回-1
        System.out.println(list.lastIndexOf("a"));//1
        System.out.println(list.lastIndexOf("d"));//-1
    }

    /**
     * 测试subList，返回指定范围内的集合
     */
    @Test
    public void testSubList() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        System.out.println(list);
        List<String> subList = list.subList(1, 3);//返回指定范围内的集合
        System.out.println(subList);
    }

    /**
     * 数组转List集合
     */
    @Test
    public void testArrayToList() {

        String[] strings = {"a", "b", "c"};

        List<String> list1 = new ArrayList<>(Arrays.asList(strings)); //modifiable List
        list1.add("e"); // ok

        List<String> list2 = Arrays.stream(strings).collect(Collectors.toList()); //modifiable List
        list2.add("e"); // ok

        List<String> list3 = Arrays.stream(strings).toList(); //unmodifiable List
        list3.add("e"); // UnsupportedOperationException

        List<String> list4 = Arrays.asList(strings); //unmodifiable List
        list4.add("e"); // UnsupportedOperationException
    }

    /**
     * 测试数组转List集合
     */
    @Test
    public void testArrayToList2() {
        String[] strings = {"a", "b", "c"};
        List<String> list = transferArrayToList(strings);//这是可变的list
        System.out.println(list);
        String[] remove = {"a", "b"};
        List<String> removeList = Arrays.asList(remove); //这是不可变的list
        list.removeAll(removeList);
        System.out.println(list);
    }

    /**
     * 数组转List集合
     *
     * @param array 数组
     * @param <E>   泛型
     * @return List集合
     */
    public static <E> List<E> transferArrayToList(E[] array) {
        List<E> transferList = new ArrayList<>();
        Arrays.stream(array).forEach(arr -> transferList.add(arr));
        return transferList;
    }


    /**
     * listIterator使用 从前往后遍历集合
     */
    @Test
    public void next() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        ListIterator<String> iterator = list.listIterator();
        while (iterator.hasNext()) {
            int index = iterator.nextIndex();
            String next = iterator.next();
            System.out.println(index + "-->" + next);
        }
    }

    /**
     * listIterator使用 从后往前遍历集合
     */
    @Test
    public void previous() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        ListIterator<String> iterator = list.listIterator(list.size());
        while (iterator.hasPrevious()) {
            int index = iterator.previousIndex();
            String previous = iterator.previous();
            System.out.println(index + "-->" + previous);
        }
    }

    /**
     * 使用迭代器Iterator遍历集合,<b>在遍历的过程中可以对集合修改</b>
     */
    @Test
    public void testIteratorRemove() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        String remove = "c";
        System.out.println(list);
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if (remove.equals(next)) {
                iterator.remove();
            }
        }
        System.out.println(list);
    }

    /**
     * 使用迭代器Iterator遍历集合,<b>在遍历的过程中可以对集合修改</b>,简单写法
     */
    @Test
    public void testIteratorRemove2() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        String remove = "c";
        System.out.println(list);
        list.removeIf(remove::equals);
        System.out.println(list);

        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        ints.add(3);
        ints.add(4);
        ints.removeIf(i -> i % 2 == 0);//删除偶数
        System.out.println(ints);
    }

    @Test
    public void testIteratorRemove3() {
        List<Student> boyList = new ArrayList<>();
        boyList.add(Student.builder().name("张三").age(18).build());
        boyList.add(Student.builder().name("张小三").age(18).build());
        boyList.add(Student.builder().name("王小四").age(18).build());
        boyList.removeIf(student -> student.getName().equals("张三"));
        System.out.println(boyList);
    }

    /**
     * 使用foreach遍历集合
     * <b>不能在遍历的时候不能删除元素</b>
     */
    @Test
    public void testForEach() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        for (String s : list) {
            System.out.println(s);
            if ("b".equals(s)) {
                list.remove(s);//ConcurrentModificationException
            }
        }
    }

    /**
     * 测试函数式编程
     */
    @Test
    public void testForEach2() {
        List<Student> list = new ArrayList<>();
        list.add(Student.builder().age(1).build());
        list.add(Student.builder().age(2).build());
        list.add(Student.builder().age(3).build());
        list.forEach(student -> student.setAge(student.getAge() + 1));
        list.forEach(System.out::println);
    }

    /**
     * 使用stream打印集合，其他stream使用建stream包
     */
    @Test
    public void testStream() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.stream().forEach(System.out::println);
    }

    /**
     * 打乱数组
     */
    @Test
    public void testShuffle() {
        int size = 30;
        Integer[] nums = new Integer[size];
        // 生成数组 nums = { 1, 2, 3, ..., n }
        for (int i = 0; i < size; i++) {
            nums[i] = i + 1;
        }
        System.out.println("nums sorted before = " + Arrays.toString(nums));
        // 随机打乱数组元素
        List<Integer> integerList = Arrays.asList(nums);
        Collections.shuffle(integerList);
        // 数组 nums 与 list 数组的顺序一致!
        System.out.println("nums sorted after = " + Arrays.toString(nums));
        System.out.println("integerList = " + integerList);
    }

    /**
     * list去重 利用LinkedHashSet和HashSet只能存放不重复的特性去重
     * <p>
     * LinkedHashSet 去重方法：
     * <p>
     * 顺序保持: 使用 LinkedHashSet 可以保持元素的插入顺序，即去重后的列表中元素的顺序与原始列表中的顺序相同。
     * <p>
     * 无需再排序: 由于保持了插入顺序，因此不需要额外的排序步骤。
     * <p>
     * 内存占用: 会占用更多的内存，因为它需要维护元素的插入顺序。
     * <p>
     * 性能: 在添加元素时，由于要维护顺序，可能会比较 HashSet 稍慢一些。
     *
     * <p>
     * HashSet 去重方法：
     * <p>
     * 无序: HashSet 不保证元素的顺序，因此去重后的列表中的元素顺序可能与原始列表不同。
     * <p>
     * 内存占用: 通常比 LinkedHashSet 更节省内存，因为它不需要维护元素的插入顺序。
     * <p>
     * 性能: 在添加元素时，由于不需要维护顺序，HashSet 可能会稍快一些。
     */
    @Test
    public void removeDuplicates() {
        List<String> list = Arrays.asList(new String[]{"z", "b", "e", "a", "a"});
        //去重
        List<String> list2 = new ArrayList<>(new LinkedHashSet<>(list));
        System.out.println(list); //[a, b, a]
        System.out.println(list2);//[a, b]
    }

    /**
     * 使用stream去重
     */
    @Test
    public void streamDistinct() {
        List<String> list = Arrays.asList(new String[]{"z", "b", "e", "a", "a"});
        List<String> distinctList = list.stream().distinct().toList();
        System.out.println("distinctList = " + distinctList);
    }

}
