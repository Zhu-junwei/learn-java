package com.feature.java15;

/**
 * 文本块
 *
 * @author 朱俊伟
 * @since 2024/03/24 15:03
 */
public class TextBlock {
    public static void main(String[] args) {
        String simpleJSONMessage = """
                {
                        "firstName": "Billy",
                        "lastName": "Korando",
                        "jobTitle": "Java Developer Advocate",
                        "twitterHandle": "@BillyKorando"
                }
                """;
        System.out.println(simpleJSONMessage);
    }
}
