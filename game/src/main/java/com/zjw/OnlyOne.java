package com.zjw;

import java.util.HashMap;
import java.util.Map;

/**
 * 一个数组中，只有一个数字是唯一的，其他数字均有重复，找出这个唯一的数字。
 * <p>其他类似的：
 * <p> 统计一篇文章中每个字符出现的次数。
 * <p>解决思路：
 * <p>  将每个字符作为key，字符出现的次数作为value存入map集合中。如果map中没有存入该字符，则新存入，并计数为1；如果存在该字符，则将
 * <p>  该字符的计数进行加1处理。
 * @author 朱俊伟
 * @date 2020/12/08
 */
public class OnlyOne {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,3,3,4,5,5};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums){
        //只有一个元素
        if (nums.length == 1){
            return nums[0];
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for (Integer integer : map.keySet()) {
            if (map.get(integer) == 1){
                return integer;
            }
        }
        return 0;
    }
}
