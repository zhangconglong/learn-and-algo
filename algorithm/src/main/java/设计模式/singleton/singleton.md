一、volatile
为了保证线程间的可见性。



二、synchronized
- 加锁 class 时（锁类），
        无论共享一个对象还是创建多个对象，它们用的都是同一把锁
- 加锁 this 时（锁对象），
        只有同一个对象才使用同一把锁，
        不同对象之间的锁是不同的。

在本案例中，使用锁class，
  （1）getInstance为static方法，不可锁this！
  static方法，又称为无this方法

