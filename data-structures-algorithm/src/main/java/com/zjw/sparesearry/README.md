# 稀疏数组

> 当一个数组中大部分元素为0，或者为同一个值的数组时，可以使用稀疏数组来保存该数组。

稀疏数组的处理方法是:

     记录数组一共有几行几列，有多少个不同的值
     把具有不同值的元素的行列及值记录在一个小规模的数组中，从而缩小程序的规模

如果二维数组如下：

共4行5列，其中大部分值为0，3个非0数值
```
{
     0   0   0   6   0
     5   0   0   9   0
     0   0   0   0   0
     0   0   0   0   0
}
```

转为稀疏数组如下：

其中第一行`[0][0]`,`[0][1]`,`[0][2]`表示原始数组的行数、列数、非0的个数
后面的3行中的每一行表示一个非0数值所在的行列及值的大小，如（0，3，6）表示原始数组的第0行第3列的值为6
```
{
     4   5   3
     0   3   6
     1   0   5
     1   3   9
}
```