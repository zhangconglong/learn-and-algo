package Juc.kuangJUC.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 8锁就是关于锁的8个问题
 */
public class Test1 {
    public static void main(String[] args) {
        Phone phone = new Phone();
        Phone phone2 = new Phone();

        //锁的存在
        new Thread(()->{
            phone.sendSms();
        }, "1A").start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            phone.call();
        }, "1B").start();

        new Thread(()->{
            phone.hello();
        }, "1C").start();

        new Thread(()->{
            phone2.call();
        }, "2A").start();
    }
}

class Phone{

    /*synchronized锁的对象是方法的调用者
    *两个方法用的是同一把锁, 谁先拿到谁就先执行 */
    //static静态方法,锁的是Class
    public static synchronized void sendSms(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"->"+"sendSms");
    }

    public synchronized void call(){
        System.out.println(Thread.currentThread().getName()+"->"+"call");
    }

    //普通方法不受锁的影响
    public void hello(){
        System.out.println(Thread.currentThread().getName()+"->"+"hello");
    }
}