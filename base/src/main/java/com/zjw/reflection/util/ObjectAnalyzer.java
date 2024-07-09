package com.zjw.reflection.util;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/**
 * 利用反射获取对象的属性信息 Java核心技术卷Ⅰ（第十版） page 200
 *
 * @author 朱俊伟
 * @since 2022/03/29 23:17
 */
public class ObjectAnalyzer {

    // 记录已访问过的对象，防止循环引用
    private final ArrayList<Object> visited = new ArrayList<>();

    /**
     * 将对象转换为字符串表示形式，包括对象的类名、字段名和字段值。
     * 支持处理数组和递归处理对象引用。
     *
     * @param obj 要转换为字符串的对象
     * @return 对象的字符串表示形式
     */
    public String toString(Object obj) {
        if (obj == null) return "null"; // 对象为null时返回"null"
        if (visited.contains(obj)) return "..."; // 避免循环引用
        visited.add(obj); // 记录已访问的对象
        Class<?> cl = obj.getClass();

        // 如果对象是字符串，直接返回字符串本身
        if (cl == String.class) return (String) obj;

        // 如果对象是数组，处理数组元素
        if (cl.isArray()) {
            String r = cl.getComponentType() + "[]{";
            for (int i = 0; i < Array.getLength(obj); i++) {
                if (i > 0) r += ",";
                Object val = Array.get(obj, i);
                if (cl.getComponentType().isPrimitive()) r += val;
                else r += toString(val); // 递归处理数组中的非基本类型元素
            }
            return r + "}";
        }

        // 处理非数组对象
        String r = cl.getName();
        do {
            r += "[";
            Field[] fields = cl.getDeclaredFields();
            AccessibleObject.setAccessible(fields, true); // 设置字段可访问
            for (Field f : fields) {
                if (!Modifier.isStatic(f.getModifiers())) { // 忽略静态字段
                    if (!r.endsWith("[")) r += ",";
                    r += f.getName() + "=";
                    try {
                        Class<?> t = f.getType();
                        Object val = f.get(obj);
                        if (t.isPrimitive()) r += val; // 处理基本类型字段
                        else r += toString(val); // 递归处理非基本类型字段
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            r += "]";
            cl = cl.getSuperclass(); // 处理父类字段
        } while (cl != Object.class && cl != null);

        return r;
    }
}