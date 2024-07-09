# 字符串常用操作

| 方　　法                               | 参数，重载                                                                                     | 用　　途                                                                      |
|------------------------------------|-------------------------------------------------------------------------------------------|---------------------------------------------------------------------------|
| 构造器                                | 重 载 版 本 包 括： 默 认 构 造 器； 参数 分 别 为 String、 StringBuilder、StringBuffer、 char 数组、 byte 数组的构造器 | 创建 String 对象                                                              |
| length()                           | —                                                                                         | String 中 的 Unicode 代 码 单 元（ codeunits）个数                                  |
| charAt()                           | int 索引                                                                                    | String 中某个位置的 char                                                        |
| getChars()、 getBytes()             | 要复制的开始和结束索引，要复制到的目标数组，以及目标数组的起始索引                                                         | 将 char 或 byte 复制到外部数组中                                                    |
| toCharArray()                      | —                                                                                         | 生成一个 char[]，包含了 String 中的所有字符                                             |
| equals()、 equalsIgnoreCase()       | 要与之比较的 String                                                                             | 对两个 String 的内容进行相等性检查。如果内容相等，则返回 true                                     |
| compareTo()、 compareToIgnoreCase() | 要与之比较的 String                                                                             | 按字典顺序比较 String 的内容，结果可能为负数、零或正数。注意大写和小写不相等                                |
| contains()                         | 要查找的 CharSequence                                                                         | 如果参数包含在 String 中，则结果为true                                                 |
| contentEquals()                    | 用来比较的 CharSequence 或StringBuffer                                                          | 如果该 String 与参数的内容完全匹配，则结果为 true                                           |
| isEmpty()                          | —                                                                                         | 返回一个 boolean 值，表明该 String 的长度是否为 0                                        |
| regionMatches()                    | 该 String 的索引偏移量，参数 String和它的索引偏移量，以及要比较的长 度。重载方法添加了“忽略大小写” 功能                             | 返回一个 boolean 值，表明该区域是否匹配                                                  |
| startsWith()                       | 该字符串可能的前缀 String。重载方法在参数列表中增加了偏移量                                                         | 返回一个 boolean 值，表明该 String 是否以参数字符串开头                                      |
| endsWith()                         | 该字符串可能的后缀 String                                                                          | 返回一个 boolean 值，表明参数字符串是否为后缀                                               |
| indexOf()、 lastIndexOf()           | 重载版本包括： char、 char 和起始索引；String、 String 和起始索引                                             | 如果在此 String 中找不到该参数，则返 回 -1； 否 则 返 回 参 数 开 始 的 索 引。 lastIndexOf() 则从后向前搜索 |
| matches()                          | 一个正则表达式                                                                                   | 返回一个 boolean 值，表明此 String 是否与给定的正则表达式匹配                                   |
| split()                            | 一个正则表达式。可选的第二个参数是要进行的最大分割数                                                                | 根据正则表达式拆分 String。返回结果数组                                                   | 
| join()（在 Java 8 中引入）               | 分隔符以及要合并的元素。通过将元素与分隔符连接在一起，生成一个新 的 String                                                 | 将片段合并成一个由分隔符分隔的新String                                                    |
| substring()（还有 subSequence()）      | 重载版本包括：起始索引；起始索引+结束索引                                                                     | 返回一个 String 对象，包含了指定的字符集合                                                 |
| concat()                           | 要拼接的 String                                                                               | 返回一个新的 String 对象，其中包含了原始 String 的字符，后跟参数的字符                               |
| replace()                          | 要搜索的旧字符，以及用来替换的新字符。也可以用来在 CharSequence 之 间进行替换                                            | 返回一个替换后的新 String 对象。如果没有匹配，则使用旧的 String                                   |
| replaceFirst()                     | 用来进行搜索的正则表达式，以及用来替换的新 String                                                              | 返回替换后的新 String 对象                                                         |
| replaceAll()                       | 用来进行搜索的正则表达式，以及用来替换的新 String                                                              | 返回替换后的新 String 对象                                                         |
| toLowerCase()、 toUpperCase()       | ——                                                <br/>                                   | 返回一个新的 String 对象，所有字母的大小写都发生了相应的变化。如果没有任何更改，则使用旧的 String                  |
| trim()                             | ——                                                                                        | 返回一个删除了两端空白字符的新String 对象。如果没有任何更改，则使用旧的String                             |
| valueOf() ( 静态 )                   | 重 载 版 本 包 括： Object、 char[]、char[] 和偏移量还有计数、 boolean、char、 int、 long、 float、 double       | 返回一个 String，里面包含了参数的字符表示                                                  |
| intern()                           | ——                                                                    <br/>               | 为每个唯一的字符序列生成一个独一无二的 String 引用                                             |
| format()                           | 格式字符串（内含要被替换的格式说明符）、参数                                                                    | 生成格式化后的结果 String                                                          |
