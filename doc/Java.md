







# Basic



## 泛型

属性，方法参数与返回值类型，用<>声明



属性类型声明在类上

方法参数和返回值类型声明在方法返回值类型前。

**类型擦除**

泛型在运行时被擦除

[参考](http://mp.weixin.qq.com/s?__biz=MzIyMjQ0MTU0NA==&mid=2247526432&idx=2&sn=b2425935d0f5c93f0984b0668ab42a48&chksm=e82f5107df58d81194661ffe2f34c9ac376692c4040f14eb0114db04f3b2717f5a33c2d0b7b1&mpshare=1&scene=24&srcid=0724b12RTsHBzN9qYW8q1yhf&sharer_sharetime=1627115641719&sharer_shareid=6cca8296f4c7be672b06f93a8b2e934f#rd)

泛型不能调用自定义方法，限定边界后可以





































# JUC



## InterruptedException







状态复位

线程池异步执行最恶心的是 使用submit提交后,执行的方法如果抛出了异常,压根不打印日志的…

















# JVM





















## ThreadLocal

[参考](https://mp.weixin.qq.com/s/CR7uGJTupDdKFqJDKlSnDA)



* 为什么要用,使用场景
* 原理
* ThreadLocalMap
* key为什么设计成弱引用
* 内存泄漏问题
* 父子线程间如何共享数据

### ThreadLocalMap





Thread的内部类



ThreadLocal是数据存储类，内部有一个ThreadLocalMap类，Thread持有ThreadLocalMap类型的变量，使用ThreadLocal存储数据时，其实是将数据存储到当前Thread的ThreadLocalMap变量里面，





## 线程池

[细数线程池的10个坑](https://mp.weixin.qq.com/s/S6KihwvkOMpbdRqTIyAgbA)

[线程池到底设置多少线程比较合适？](https://mp.weixin.qq.com/s?__biz=Mzg3NzU5NTIwNg==&mid=2247488048&idx=2&sn=26a79fcbc1b8db0d3f845e598b231714&chksm=cf21cd19f856440fa39a9c52af3abda13f62a047d282c8510075a6af264b5dad39bc90a55765&token=901618401&lang=zh_CN&scene=21#wechat_redirect)

















