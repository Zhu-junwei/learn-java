# Java标准库中Builder模式的实现

`StringBuilder`和`StringBuffer`就是**Builder模式**的实现。

```java
StringBuilder builder = new StringBuilder();
String str = builder.append("Hello")
                   .append(" ")
                   .append("World")
                   .toString();
```