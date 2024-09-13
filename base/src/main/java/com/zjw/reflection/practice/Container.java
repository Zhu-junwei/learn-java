package com.zjw.reflection.practice;

import com.zjw.reflection.practice.anno.AutoWried;
import com.zjw.reflection.practice.anno.Bean;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 注册服务和获取实例
 *
 * @author 朱俊伟
 * @since 2024/09/04 17:29
 */
public class Container {
    private Map<Class<?>, Method> methodMap;
    private Config config;
    private Map<Class<?>, Object> serviceMap;

    /**
     * 初始化服务
     */
    public void init() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        this.methodMap = new HashMap<>();
        this.serviceMap = new HashMap<>();
        Class<Config> configClass = Config.class;
        this.config = configClass.getConstructor().newInstance();
        Method[] configClassDeclaredMethods = configClass.getDeclaredMethods();
        for (Method method : configClassDeclaredMethods) {
            if (method.getAnnotation(Bean.class) != null) {
                methodMap.put(method.getReturnType(), method);
            }
        }
    }

    /**
     * 根据服务class获取服务的实例对象
     */
    public Object getServiceInstanceByClass(Class<?> aClass) throws InvocationTargetException, IllegalAccessException {
        if (this.serviceMap.containsKey(aClass)) {
            return this.serviceMap.get(aClass);
        }
        if (this.methodMap.containsKey(aClass)) {
            Method method = this.methodMap.get(aClass);
            Object object = method.invoke(this.config);
            this.serviceMap.put(aClass, object);
            return object;
        }
        return null;
    }

    /**
     * 根据class对象获取其对应的实例对象，并通过构造方法为其注入依赖
     */
    public Object createInstance(Class<?> aClass) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Constructor<?>[] constructors = aClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            if (constructor.getAnnotation(AutoWried.class) != null) {
                // 获取构造函数的参数类型
                Class<?>[] parameterTypes = constructor.getParameterTypes();
                Object[] parameters = new Object[parameterTypes.length];
                for (int i = 0; i < parameterTypes.length; i++) {
                    // 获取每个参数的实例
                    parameters[i] = this.getServiceInstanceByClass(parameterTypes[i]);
                }
                return constructor.newInstance(parameters);
            }
        }
        // 如果没有使用注解，则使用默认的无参构造器
        return aClass.getConstructor().newInstance();
    }

}
