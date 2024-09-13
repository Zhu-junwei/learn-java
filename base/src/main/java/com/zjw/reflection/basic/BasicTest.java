package com.zjw.reflection.basic;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 反射基本练习
 *
 * @author 朱俊伟
 * @since 2024/09/04 10:49
 */
public class BasicTest {

    /**
     * 获取Class对象方法一：类名.class
     */
    @Test
    @SuppressWarnings("all")
    public void getClassTest() {
        // 使用这种方式获取的class不会触发类的初始化，static{}代码块不会被执行
        Class<User> userClass = User.class;
        Class<User> aClass = User.class;
        System.out.println(userClass.getName());
        // 虚拟机中每个类对应的Class都是唯一的
        System.out.println(userClass == aClass); // true

        // 获取父类
        Class<? super User> superclass = userClass.getSuperclass();
        System.out.println(superclass.getName());

    }

    /**
     * 获取Class对象方法二：对象.getClass()
     */
    @Test
    @SuppressWarnings("unused")
    public void getClass2Test() {
        User user = new User("zjw", 18);
        // 泛型参数是在编译时确定的，而getClass返回的可能是 User 及其任何子类的 Class 对象
        // 所以可以使用Class<?>或Class<? extends User>来接收，不能使用Class<User>来接收
        Class<?> aClass = user.getClass();
        Class<? extends User> aClass2 = user.getClass();
        // 这里不能使用Class<User>来接收，
        // Class<User> userClass = user.getClass();
    }

    /**
     * 获取Class对象方法三：Class.forName()
     */
    @Test
    @SneakyThrows
    @SuppressWarnings("unused")
    public void getClass3Test() {
        // 同对象.getClass()一样，在编译时无法确定具体的泛型类型，并且默认会进行类的初始化
        Class<?> aClass = Class.forName("com.zjw.reflection.basic.User");
        // 和上面的获取class的作用一样
        Class<?> aClass2 = Class.forName("com.zjw.reflection.basic.User", true, BasicTest.class.getClassLoader());

        // 可以用通过第二个参数initialize来控制是否对类进行初始化，不让static{}代码块执行
        Class<?> aClass3 = Class.forName("com.zjw.reflection.basic.User", false, BasicTest.class.getClassLoader());
    }

    /**
     * getDeclaredFields 获取该类的所有定义的字段，但不包括继承父类的字段
     */
    @Test
    @SneakyThrows
    public void getDeclaredFieldsTest() {
        Class<?> aClass = Class.forName("com.zjw.reflection.basic.User");
        // 可以获取该类的所有定义的字段，但不包括继承父类的字段
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field field : declaredFields) {
            // 字段的修饰符和名字
            // field.getModifiers() 整数对应的修饰符
            // field.getType() 字段的声明类型，如果字段是泛型类型可以使用getGenericType()
            // field.getName() 字段的名字
            System.out.println(Modifier.toString(field.getModifiers()) + " " + field.getGenericType() + " " + field.getName());
        }
    }

    /**
     * getFields 返回该类及其所有超类和超接口的public字段。
     */
    @Test
    @SneakyThrows
    public void getFieldTest() {
        Class<?> aClass = Class.forName("com.zjw.reflection.basic.User");
        // 返回该类及其所有超类和超接口的public字段。
        Field[] declaredFields = aClass.getFields();
        for (Field field : declaredFields) {
            System.out.println(Modifier.toString(field.getModifiers()) + " " + field.getGenericType() + " " + field.getName());
        }
    }

    /*
        同样的getDeclaredMethods()，getDeclaredConstructors()，getDeclaredAnnotations()都是获取当前类所定义的方法，构造器，元素上注解
        而getMethods()，getConstructors()，getAnnotations()是获取当前类及其所有超类和超接口公共的方法，构造器，元素上及继承的注解
     */

    /**
     * getDeclaredField 获取指定名字的字段
     */
    @Test
    @SneakyThrows
    public void getSpecifiedFieldTest() {
        Class<?> aClass = Class.forName("com.zjw.reflection.basic.User");
        // 获取指定名字的字段，字段上对应的注解
        Field field = aClass.getDeclaredField("name"); // 如果字段不存在报错NoSuchFieldException
        // 修饰符 类型 名字
        System.out.println(Modifier.toString(field.getModifiers()) + " " + field.getGenericType() + " " + field.getName());
        // 字段上的注解
        Annotation[] declaredAnnotations = field.getDeclaredAnnotations();
        for (Annotation annotation : declaredAnnotations) {
            System.out.println(annotation);
        }

        // 非静态字段不能直接获取值，需要传入实例的对象
        System.out.println(field.get(null));
    }

    /**
     * 获取静态字段值
     */
    @Test
    @SneakyThrows
    public void getStaticFieldValueTest() {
        Class<?> aClass = Class.forName("com.zjw.reflection.basic.User");
        // 获取public静态字段
        Field publicStaticField = aClass.getDeclaredField("publicStaticField");
        // 不需要对象，这里传入null
        System.out.println(publicStaticField.get(null));

        // 获取private静态字段
        Field privateStaticField = aClass.getDeclaredField("privateStaticField");
        privateStaticField.setAccessible(true);
        // 不需要对象，这里传入null
        System.out.println(privateStaticField.get(null)); // 私有字段不能直接获取值，需要设置为可访问，否则会报错IllegalAccessException
        // 修改字段的值
        privateStaticField.set(null, 100);
        System.out.println(privateStaticField.get(null)); // 私有字段不能直接获取值，需要设置为可访问，否则会报错IllegalAccessException
    }

    /**
     * getDeclaredMethod 获取定义的方法
     */
    @Test
    @SneakyThrows
    public void getDeclaredMethodTest() {
        Class<?> aClass = Class.forName("com.zjw.reflection.basic.User");
        // 获取所有定义的方法
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            // 方法的修饰符，返回类型，方法名
            System.out.print(Modifier.toString(method.getModifiers()) + " " + method.getGenericReturnType() + " " + method.getName() + "(");
            // 方法的形参（类型）
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                if (i>0) System.out.print(", ");
                System.out.print(parameterTypes[i].getTypeName());
            }
            System.out.println(")");
        }
    }

    /**
     * 调用静态方法
     */
    @Test
    @SneakyThrows
    public void invokeStaticMethodTest() {
        Class<?> aClass = Class.forName("com.zjw.reflection.basic.User");
        // 调用public静态方法
        Method myPublicStaticMethod = aClass.getDeclaredMethod("myPublicStaticMethod");
        myPublicStaticMethod.invoke(null);

        // 调用private静态方法，需要先修改方法为可访问，否则会抛出IllegalAccessException
        Method myPrivateStaticMethod = aClass.getDeclaredMethod("myPrivateStaticMethod");
        myPrivateStaticMethod.setAccessible(true);
        myPrivateStaticMethod.invoke(null);

        // 调用带参数的private静态方法，在获取方法时需要指定参数的类型，在调用方法时需要传入参数
        Method myPrivateStaticMethod2 = aClass.getDeclaredMethod(
                "myPrivateStaticMethod",
                String.class);
        myPrivateStaticMethod2.setAccessible(true);
        myPrivateStaticMethod2.invoke(null, "hello");
    }

    /**
     * newInstance创建对象
     */
    @Test
    @SneakyThrows
    @SuppressWarnings("unused")
    public void newInstanceTest() {
        Class<?> aClass = Class.forName("com.zjw.reflection.basic.User");
        // 获取构造方法，如果不传参代表获取的是无参构造
        Constructor<?> constructor = aClass.getDeclaredConstructor(String.class, int.class);
        // 通过newInstance方法创建对象并传入参数
        Object object = constructor.newInstance("zjw", 18);
        if (object instanceof User user){
            System.out.println(user.name);
        }

        // 如果Class是通过类.class来获取的，可以通过class.cast来进行创建对象后类型的转换
        Class<User> userClass = User.class;
        Object userObject = userClass.getDeclaredConstructor().newInstance();
        User user1 = userClass.cast(userObject);
        // 在创建对象时直接使用指定类型接收
        User user2 = userClass.getDeclaredConstructor().newInstance();
    }

    /**
     * 获取instance示例的字段，调用方法
     */
    @Test
    @SneakyThrows
    public void instanceFieldTest() {
        Class<?> aClass = Class.forName("com.zjw.reflection.basic.User");
        Constructor<?> constructor = aClass.getDeclaredConstructor(String.class, int.class);
        Object object = constructor.newInstance("zjw", 18);
        Field age = aClass.getDeclaredField("age");
        age.setAccessible(true); // 需要写在get(obj)之前，否则后续无法set值
        // 获取实例的字段
        System.out.println("before: " + age.get(object));
        // age字段是final，但是依然可以修改它的值
        age.set(object, 19);
        System.out.println("before: " + age.get(object));
    }


    /**
     * 调用实例方法
     */
    @Test
    @SneakyThrows
    public void invokeInstanceMethodTest() {
        Class<?> aClass = Class.forName("com.zjw.reflection.basic.User");
        Constructor<?> constructor = aClass.getDeclaredConstructor();
        Object object = constructor.newInstance();

        // 调用public方法，invoke需要传入实例化后的对象
        Method myPublicMethod = aClass.getDeclaredMethod("myPublicMethod");
        myPublicMethod.invoke(object);
        // 调用private方法，invoke需要传入实例化后的对象
        Method myPrivateMethod = aClass.getDeclaredMethod("myPrivateMethod");
        myPrivateMethod.setAccessible(true); // 需要设置可访问，否则抛出IllegalAccessException
        myPrivateMethod.invoke(object);
        // 调用private带参数的方法，invoke需要传入实例化后的对象和要传入的参数
        Method myPrivateMethod2 = aClass.getDeclaredMethod("myPrivateMethod", String.class);
        myPrivateMethod2.setAccessible(true); // 需要设置可访问，否则抛出IllegalAccessException
        myPrivateMethod2.invoke(object, "hello");
    }
}
