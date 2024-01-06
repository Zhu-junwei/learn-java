package com.zjw.domain;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class Student {

    private String name;

    private Integer age;

    private Date createTime;

}
