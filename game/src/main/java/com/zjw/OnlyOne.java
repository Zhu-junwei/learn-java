package com.zjw;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * 一个数组中，只有一个数字是唯一的，其他数字均有重复，找出这个唯一的数字。
 * <p>其他类似的：
 * <p> 统计一篇文章中每个字符出现的次数。
 * <p>解决思路：
 * <p>  将每个字符作为key，字符出现的次数作为value存入map集合中。如果map中没有存入该字符，则新存入，并计数为1；如果存在该字符，则将
 * <p>  该字符的计数进行加1处理。
 *
 * @author 朱俊伟
 * @date 2020/12/08
 */
public class OnlyOne {
    public static void main(String[] args) {
        Integer[] nums = new Integer[]{1, 1, 3, 3, 4, 5, 5};
        System.out.println(singleNumber(nums));
        System.out.println(singleNumber2(nums));
    }

    /**
     * 使用map集合统计每个数字出现的次数，然后遍历map集合，找到唯一的数字。
     */
    public static Integer singleNumber(Integer[] nums) {
        Integer target = null;
        if (nums.length == 1) {
            return nums[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Integer integer : map.keySet()) {
            if (map.get(integer) == 1) {
                target = integer;
                break;
            }
        }
        return target;
    }

    /**
     * 使用stream流统计每个数字出现的次数，然后遍历map集合，找到唯一的数字。
     */
    public static Integer singleNumber2(Integer[] nums) {
        Integer target = null;
        if (nums.length == 1) {
            return nums[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        Stream.of(nums).forEach(num -> map.merge(num, 1, Integer::sum));
        for (Integer integer : map.keySet()) {
            if (map.get(integer) == 1) {
                target = integer;
                break;
            }
        }
        return target;
    }
}
