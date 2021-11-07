package com.zjw;

import com.sun.org.apache.xerces.internal.xs.StringList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 朱俊伟
 * @date 2021/02/24
 */
public class TestList {

    public static List<String> functionList = new ArrayList<>();

    static {
        String s = "1,2,2";
        String[] ss = s.split(",");
        functionList = Arrays.asList(ss);

    }
    public static void main(String[] args) {

        System.out.println(functionList);
        System.out.println(functionList.contains("2"));

    }
}
