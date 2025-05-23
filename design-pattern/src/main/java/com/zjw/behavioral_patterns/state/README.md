# 状态模式

[状态模式](https://refactoringguru.cn/design-patterns/state)是一种行为设计模式， 让你能在一个对象的内部状态变化时改变其行为， 使其看上去就像改变了自身所属的类一样。

**模式说明**

- LightState 是状态接口，定义了所有状态共有的行为
- OnState 和 OffState 是具体状态实现，每个状态知道如何切换到其他状态
- Light 是上下文类，维护当前状态并将行为委托给当前状态对象
- 当状态改变时，电灯的行为也随之改变，就像变成了不同的类