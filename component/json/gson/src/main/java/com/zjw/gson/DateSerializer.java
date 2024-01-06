package com.zjw.gson;

import java.lang.reflect.Type;
import java.util.Date;

/**
 * 自定义Date序列化器
 */
class DateSerializer implements com.google.gson.JsonSerializer<Date> {
    @Override
    public com.google.gson.JsonElement serialize(Date date, Type type, com.google.gson.JsonSerializationContext context) {
        return context.serialize(date.getTime());
    }
}