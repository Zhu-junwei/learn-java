package com.zjw.fastjson;

import com.alibaba.fastjson2.JSONPath;
import com.sun.xml.internal.stream.Entity;

import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

/**
 * @author zjw
 * @date 2022/11/09 10:24
 */
public class FastJsonTest {

    /**
     * 获取json中具体节点中的值
     * @throws Exception
     */
    @Test
    public void compile() {
        String json = "{ \"student\":{\"name\":\"zjw\",\"age\":18}}";
        JSONPath compile = JSONPath.compile("$student.name");
        System.out.println(compile);
        Object eval = compile.eval(json);
        System.out.println(eval);
    }
}
