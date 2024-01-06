package com.zjw.enumDemo;

/**
 * @author 朱俊伟
 * @since 2022/01/06
 */
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

    public String getEnglishName() {
        return englishName;
    }

    public String getChineseName() {
        return chineseName;
    }
}
