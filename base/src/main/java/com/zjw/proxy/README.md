proxy
proxy2
    jdk动态代理，基于接口

proxy3
    cglib动态代理，基于子类

在Java升级到17后cglib不能使用了，报了如下的错误。


```
Exception in thread "main" java.lang.ExceptionInInitializerError
	at com.zjw.cglib.Client.main(Client.java:40)
Caused by: net.sf.cglib.core.CodeGenerationException: java.lang.reflect.InaccessibleObjectException-->Unable to make protected final java.lang.Class java.lang.ClassLoader.defineClass(java.lang.String,byte[],int,int,java.security.ProtectionDomain) throws java.lang.ClassFormatError accessible: module java.base does not "opens java.lang" to unnamed module @722c41f4
	at net.sf
```

**可以参考spring-core中的MethodInterceptor，cglib动态代理。**
