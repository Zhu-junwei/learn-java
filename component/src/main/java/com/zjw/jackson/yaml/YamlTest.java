package com.zjw.jackson.yaml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.zjw.domain.Student;
import lombok.SneakyThrows;
import org.junit.Test;

import java.util.Date;

/**
 * 测试yaml的使用
 * 依赖导入 jackson-dataformat-yaml
 * @author 朱俊伟
 * @date 2023/10/25 11:15
 */
public class YamlTest {

    /**
     * 测试将对象转为yaml格式数据
     */
    @Test
    @SneakyThrows
    public void testObject2Yaml(){
        Student student = Student.builder()
                .age(18)
                .name("朱俊伟")
                .createTime(new Date())
                .build();
        YAMLMapper yamlMapper = new YAMLMapper();
        String s = yamlMapper.writeValueAsString(student);
        System.out.println(s);

        //去掉文档开始符号“---”
        YAMLFactory yamlFactory = new YAMLFactory().disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER);
        ObjectMapper objectMapper = new ObjectMapper(yamlFactory);
        String s1 = objectMapper.writeValueAsString(student);
        System.out.println(s1);
    }
}
