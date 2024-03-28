package com.zjw.regex;

/**
 * 正则表达式
 * @author 朱俊伟
 * <a href="https://blog.csdn.net/weixin_43860260/article/details/91417485">参考</a>
 */
public class RegexExample1 {
    public static void main(String[] args) {

        //. 匹配任意单个字符
        System.out.println("我*你".matches("我.你"));

        /*
          中括号[]：只有方括号里面指定的字符才参与匹配，也只能匹配单个字符。
          表达式：t[abcd]n 只可以匹配：tan，tbn，tcn，tdn。不可以匹配：thn，tabn，tn等。
         */
        System.out.println("我爱你".matches("我[爱恨L]你"));

        /*
           | 符号。相当与“或”，可以匹配指定的字符，但是也只能选择其中一项进行匹配。
          表达式：t(a|b|c|dd)n 只可以匹配：tan，tbn，tcn，tddn。不可以匹配taan，tn，tabcn等。
         */
        System.out.println("我爱你".matches("我[爱|恨|喜欢]你"));

        /*
          4.匹配次数的符号
           * 0次或者多次
           + 1次或者多次
           ? 0或1次
           {n} 恰好n次
           {n,m} 从n次到m次
         */
        System.out.println("我爱你".matches(".[爱]{1}."));

        /*
          ^符号：表示否，如果用在方括号内，^表示不想匹配的字符。
          表达式：[^x] 第一个字符不能是x 例子好像不对
         */
        System.out.println("我爱你".matches("[^我]"));

        /*
         \S符号：非空字符
         */
        System.out.println("adfag".matches("\\S"));
        System.out.println("ad fag".matches("\\s"));
        System.out.println("ad  fag".matches("\\s"));


    }
}
