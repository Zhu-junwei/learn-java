package com.feature.java5.enumDemo;

import lombok.Getter;

/**
 * 枚举类型
 *
 * @author 朱俊伟
 * @since 2022/01/06
 */
@Getter
public enum ColorEnum {

    GREEN("green","绿色"),
    RED("red","红色"),
    BLACK("black","黑色");

    private final String englishName;
    private final String chineseName;

    ColorEnum(String englishName,String chineseName){
        this.englishName = englishName;
        this.chineseName = chineseName;
    }

}
