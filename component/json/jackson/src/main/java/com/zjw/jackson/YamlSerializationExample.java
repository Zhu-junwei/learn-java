package com.zjw.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * YAML 序列化示例
 */
public class YamlSerializationExample {
    public static void main(String[] args) throws IOException {
        Student student = Student.builder()
                .age(18)
                .name("朱俊伟")
                .createTime(new Date())
                .build();

        // 使用 Jackson 库将 Java 对象转为 YAML 格式
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory().disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER));

        // 注册自定义的日期序列化器
        SimpleModule module = new SimpleModule();
        module.addSerializer(Date.class, new CustomDateSerializer());
        objectMapper.registerModule(module);

        String yamlString = objectMapper.writeValueAsString(student);
        System.out.println(yamlString);
    }

    // 自定义日期序列化器
    static class CustomDateSerializer extends JsonSerializer<Date> {
//        private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        @Override
        public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeString(dateFormat.format(date));
        }
    }
}