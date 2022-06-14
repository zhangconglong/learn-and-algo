package Juc.锁.悲观锁.Synchronized.对象锁与类锁;

import java.util.concurrent.TimeUnit;

/* 
 * （1）类锁，  所有对象竞争【同一把锁】   
 *     synchronized(A.class)     锁 class文件
 *     synchronized static a()   锁 静态方法
 * 
 * （2）对象锁， 每个对象的都【独享自己的锁】
 *     synchronized void a()      锁 当前对象
 *     synchronized(this)
 */
public class Phone{
    
    //无锁：乱序
    public void call_1(){
        System.out.println(Thread.currentThread().getName()+"->"+"call");
    }
    
    
    /*
      静态方法：类锁
            所有对象调用该方法都阻塞，同步执行
            拿到锁的对象，才能执行
    */
    public synchronized static void call_2() throws InterruptedException {
        
        TimeUnit.SECONDS.sleep(1);
       
        System.out.println(Thread.currentThread().getName()+"->"+"call");
    }

    /**
     * 普通方法：同一对象的调用阻塞
     */
    public synchronized void call_3(){
        System.out.println(Thread.currentThread().getName()+"->"+"call");
    }
}