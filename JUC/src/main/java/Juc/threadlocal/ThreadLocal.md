
> Java中ThreadLocal的实际用途是啥？ - 敖丙的回答 - 知乎
https://www.zhihu.com/question/341005993/answer/1367225682

# FastThreadLocal (Netty优化)
> https://zhuanlan.zhihu.com/p/519790453

"threadLocalHashCode->索引下标"
- ThreadLocal是通过map结构，先计算哈希值，在进行线性探测的方式进行定位。
- Internal-ThreadLocalMap底层采用数组，数据的获取、赋值都是通过下标

导致的问题
1. 请求频繁 
才显现其效果
2. 移除元素

FastThread有一个弊端就是index是一直累加，如果移除了某个变量是，【将对应下标的元素标记为UNSET占位】，而不进行回收，会无限制增大
## FastThreadLocalThread
