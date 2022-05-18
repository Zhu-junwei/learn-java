package com.zjw.uuid;

import java.util.UUID;

/**
 * UUID
 * 参考： https://www.cnblogs.com/java-class/p/4727698.html
 *        https://www.jianshu.com/p/da6dae36c290
 *  UUID 含义是通用唯一识别码 (Universally Unique Identifier)，这是一个软件建构的标准。
 *  UUID是由128位的二进制数据组成，通常使用32位的十六进制数据表示，并使用连字符连接。其表示格式为8-4-4-4-12。
 * @author 朱俊伟
 * @date 2022/05/18 9:13
 */
public class UUIDTest {
    public static void main(String[] args) {
        //随机生成UUID字符串
        String uuid = UUID.randomUUID().toString();
        System.out.println(uuid);
        //通过UUID字符串获取UUID对象
        UUID uuid1 = UUID.fromString("14829a06-ad09-4c67-b5c9-6d5d8191a001");
        System.out.println(uuid1);
        //对于给定的字符串，总能生成相同的UUID
        UUID uuid3 = UUID.nameUUIDFromBytes("Hello".getBytes());
        UUID uuid4 = UUID.nameUUIDFromBytes("Hello".getBytes());
        System.out.println(uuid3);
        System.out.println(uuid4);
    }
}
