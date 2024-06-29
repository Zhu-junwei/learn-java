package com.feature.java5.annotation;

import java.util.Arrays;

/**
 * 测试通过反射机制获取注解的值
 *
 * @author 朱俊伟
 * @since 2024/01/13 14:41
 */
public class CustomAnnoTest {
    public static void main(String[] args) {
        Class<UserInfo> userInfoClass = UserInfo.class;
        CustomAnno myAnno = userInfoClass.getAnnotation(CustomAnno.class);

        // 获取注解的值
        String name = myAnno.name();
        System.out.println(name);
        int[] month = myAnno.month();
        System.out.println(Arrays.toString(month));
    }
}

/**
 * @author 朱俊伟
 * @date 2024/06/30
 */
@CustomAnno(name = "小明",month = {1,3,7,9})
class UserInfo{

}