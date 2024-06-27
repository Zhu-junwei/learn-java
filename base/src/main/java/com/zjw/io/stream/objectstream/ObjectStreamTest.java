package com.zjw.io.stream.objectstream;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.ToString;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.nio.file.Path;

/**
 * 对象序列化，类需要实现Serializable接口
 *
 */
public class ObjectStreamTest {

    @TempDir
    static Path tempDir;

    @Test
    @SneakyThrows
    public void testObjectStream() {
        // 创建一个对象
        Person person = new Person("Alice", 30, "这个字段不会被序列化");
        File serializeFile = tempDir.resolve("person.serialize").toFile();

        // 将对象序列化到文件
        System.out.println("对象序列化前：" + person);
        try (FileOutputStream fileOutputStream =new FileOutputStream(serializeFile);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(person);
        }

        // 反序列化对象
        try (FileInputStream fileInputStream = new FileInputStream(serializeFile);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            Person deserializedPerson = (Person) objectInputStream.readObject();
            // Person(name=Alice, age=30, secret=null)
            System.out.println("反序列化后的对象：" + deserializedPerson);
        }
    }
}

/**
 * 需要注意的是序列化的对象必须实现Serializable接口，否则会抛出NotSerializableException异常。
 * 但是没有提供setter和getter方法，这些属性也会被序列化。
 * 如果不想被序列化，可以使用transient关键字修饰。
 */
@AllArgsConstructor
@ToString
class Person implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private transient String secret;
}
