package com.zjw.generic;

import lombok.*;

/**
 * 定义泛型类
 * @author 朱俊伟
 * @date 2022/04/27 13:54
 */
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pair<T> {

    private T first;

    private T second;

}
