package com.zjw.gson;

import java.lang.reflect.Type;
import java.util.Date;

/**
 * 自定义Date反序列化器
 */
class DateDeserializer implements com.google.gson.JsonDeserializer<Date> {
    @Override
    public Date deserialize(com.google.gson.JsonElement json, Type typeOfT, com.google.gson.JsonDeserializationContext context) {
        return new Date(json.getAsLong());
    }
}