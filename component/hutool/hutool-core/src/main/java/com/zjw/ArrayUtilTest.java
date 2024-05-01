package com.zjw;

import cn.hutool.core.util.ArrayUtil;
import org.junit.jupiter.api.Test;

/**
 * @author 朱俊伟
 * @since 2024/04/29 12:26
 */
public class ArrayUtilTest {

    /**
     * 测试打乱数组
     */
    @Test
    public void stuffTest() {
        int[] arr = {19, 5, 2, 7, 8};
        ArrayUtil.shuffle(arr);
        System.out.println(ArrayUtil.toString(arr));
    }
}
