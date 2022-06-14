package Juc.锁.悲观锁.Synchronized;

import java.util.concurrent.TimeUnit;

/*
 * synchronized锁的对象是方法的调用者
 * 两个方法用的是同一把锁, 谁先拿到谁就先执行
 * 
 * （1）类锁，  所有对象竞争【同一把锁】   
 *     synchronized(A.class)     锁 class文件
 *     synchronized static a()   锁 静态方法
 * 
 * （2）对象锁， 每个对象的都【独享自己的锁】
 *     synchronized void a()      锁 当前对象
 *     synchronized(this)
 */
public class Phone{
    //static静态方法,锁的是Class
    public synchronized static void sendSms(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"->"+"sendSms");
    }

    /**
     * 锁普通方法：
     */
    public synchronized void call(){
        System.out.println(Thread.currentThread().getName()+"->"+"synchronized-call");
    }

    //普通方法，不受锁的影响
    public void hello(){
        System.out.println(Thread.currentThread().getName()+"->"+"hello");
    }
}