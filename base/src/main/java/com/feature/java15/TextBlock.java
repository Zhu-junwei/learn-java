package com.feature.java15;

import org.junit.jupiter.api.Test;

/**
 * 文本块
 *
 * @author 朱俊伟
 * @since 2024/03/24 15:03
 */
public class TextBlock {

    @Test
    public void stringTemplateTest() {
        String simpleJSONMessage = """
                {
                        "firstName": "Billy",
                        "lastName": "Korando",
                        "jobTitle": "Java Developer Advocate",
                        "twitterHandle": "@BillyKorando"
                }
                """;
        System.out.println(simpleJSONMessage);

        String simpleJSONMessage2 = """
                {
                        "firstName": "$firstName$",
                        "lastName": "Korando",
                        "jobTitle": "Java Developer Advocate",
                        "twitterHandle": "@BillyKorando"
                }
                """.replace("$firstName$", "Billy");
        System.out.println(simpleJSONMessage2);
    }
}
