**Cglib以及不再维护[#191](https://github.com/cglib/cglib/issues/191)，建议使用SpringFramework中的cglib**

# ~~CglibProxy代理~~

依赖

```xml

<dependency>
    <groupId>cglib</groupId>
    <artifactId>cglib</artifactId>
    <version>3.3.0</version>
</dependency>
```

```java
package com.zjw.proxy.proxy3;

/**
 * 一个生产者
 */
public class Producer {

    public void saleProduct(float money){
        System.out.println("销售产品，并拿到钱："+money);
    }

    public void afterService(float money){
        System.out.println("提供售后服务，并拿到钱："+money);
    }

    public final void hello(){
        System.out.println("你能代理我嘛？？");
    }
}
```

```java
package com.zjw.proxy.proxy3;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author 朱俊伟
 * @since 2023/06/22 7:43
 */
public class CglibProxy implements MethodInterceptor {

    private final Object target;

    public CglibProxy(Object target) {
        this.target = target;
    }

    /**
     * @param obj 代理对象的引用
     * @param method 当前执行的方法
     * @param args 当前执行方法所需的参数
     * @param proxy 当前执行方法的代理对象
     * @return Object 方法的返回值
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        long start = System.nanoTime();
        Object result;
        if ("saleProduct".equals(method.getName())){
            result = method.invoke(target,(float)(args[0])*0.8F);
        } else {
            result = method.invoke(target,args);
        }
        long end = System.nanoTime();
        System.out.println("耗时"+(end-start));
        return result;
    }
    
    public <T> T getProxy() {
        return (T)Enhancer.create(target.getClass(), this);
    }


    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy(new Producer());
        Producer cglibProducer = proxy.getProxy();
        cglibProducer.saleProduct(100F);
        cglibProducer.afterService(10F);
        cglibProducer.hello();
    }
}
```