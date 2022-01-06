package com.zjw.enumDemo;

/**
 * @author 朱俊伟
 * @date 2022/01/06
 */
public enum ColorEnum {
    GREEN("green","绿色"),
    RED("red","红色"),
    BLACK("black","黑色");

    private String key;
    private String value;

    ColorEnum(String key,String value){
        this.key = key;
        this.value = value;
    }

}
