package com.zjw.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson2.JSONPath;
import com.zjw.domain.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * fastjson测试
 * @author zjw
 * @date 2022/11/09 10:24
 */
public class FastJsonTest {

    /**
     * 获取json中具体节点中的值
     */
    @Test
    public void compile() {
        String json = "{ \"student\":{\"name\":\"zjw\",\"age\":18}}";
        JSONPath compile = JSONPath.compile("$student.name");
        System.out.println(compile);
        Object eval = compile.eval(json);
        System.out.println(eval);
    }

    /**
     * 序列化：
     *  对象创建json字符串
     */
    @Test
    public void serialize() {
        Student student = Student.builder()
                .age(18)
                .name("朱俊伟")
                .createTime(new Date())
                .build();
        String jsonString = JSON.toJSONString(student);
        System.out.println(jsonString);
    }

    /**
     * 反序列化
     * json字符串转对象
     */
    @Test
    public void deserialize() {
        String jsonString = "{\"age\":18,\"createTime\":\"2022-11-16 15:45:28\",\"name\":\"朱俊伟\"}";
        Student student = JSON.parseObject(jsonString, Student.class);
        System.out.println(student);
    }

    /**
     * 设置json的样式 参考<a href="https://www.cnblogs.com/xd03122049/p/6079695.html">参考</a>
     * SerializerFeature.PrettyFormat :格式化输出
     * SerializerFeature.WriteMapNullValue :是否输出值为null的字段,默认为false
     * SerializerFeature.WriteNullStringAsEmpty :将为null的字段值显示为""
     *
     */
    @Test
    public void serializerFeature() {
        Student student = Student.builder()
                .age(18)
                .name("朱俊伟")
                .createTime(new Date())
                .build();
        String jsonString = JSON.toJSONString(student, SerializerFeature.PrettyFormat);
        System.out.println(jsonString);
    }

    /**
     * json数组 JSONArray
     */
    @Test
    public void testJsonArray(){
        Student student = Student.builder()
                .age(18)
                .name("test")
                .createTime(new Date())
                .build();
        List<Student> studentList = new ArrayList<>();
        studentList.add(student);
        JSONArray jsonArray = new JSONArray(studentList);
        System.out.println(jsonArray);
    }


}
