package com.zjw;

/**
 * 凯撒密码
 * @author 朱俊伟
 * @since 2023/05/19 23:15
 */
public class CaesarCipher {

    public static void main(String[] args) {
        //需要转换的字符串
        String str = "R uxen hxd.";
        for (int i=0;i<26;i++){
            System.out.println(i+" "+caesarSwitch(str,i));
        }
    }

    /**
     *  凯撒转换
     * @param str 需要转换的字符串
     * @param step 偏移量
     * @return  转换后的字符串
     */
    public static String caesarSwitch(String str, int step){
        //字符串转数组
        char[] chars = str.toCharArray();
        //计算右移的步数
        step = step%26;
        if(step<0){
            step = step + 26;
        }
        //开始变换
        for (int i=0;i<chars.length;i++){
            char c = chars[i];
            //小写
            if (c>='a'&&c<='z'){
                c = (char) (c + step);
                if (c>'z')
                    c -= 26;
            }
            //大写
            if (c>='A'&&c<='Z'){
                c = (char) (c + step);
                if (c>'Z')
                    c -= 26;
            }
            //把转换后的字符再给原来数组
            chars[i] = c;
        }
        return String.copyValueOf(chars);
    }

}