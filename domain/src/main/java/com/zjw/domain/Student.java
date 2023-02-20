package com.zjw.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class Student {

    private String name;

    private Integer age;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

}
