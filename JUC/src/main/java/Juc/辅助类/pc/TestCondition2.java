package Juc.辅助类.pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestCondition2 {
    public static void main(String[] args) {
        Product3 product3 = new Product3();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    product3.printA();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    product3.printB();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    product3.printC();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();


    }
}

class Product3 { //商品
    private int number = 1;//1A ,2B, 3C
    private Lock lock = new ReentrantLock(); //创建重入锁
    private Condition condition1 = lock.newCondition(); //创建监视器
    private Condition condition2 = lock.newCondition(); //创建监视器
    private Condition condition3 = lock.newCondition(); //创建监视器

    void printA() throws InterruptedException { //生产
        lock.lock();
        try {
            //业务代码
            while (number != 1) { //没轮到A
                //A等待
                condition1.await();
            }

            number=2;
            //通知线程B,生产了一个产品
            System.out.println(Thread.currentThread().getName() + "->" + "AAAA");
            //唤醒指定的B

            condition2.signal();
        } finally {
            lock.unlock();
        }

    }

    void printB() throws InterruptedException { //消费
        lock.lock();
        try {
            //业务代码
            while (number != 2) { //已经空了
                //等待
                condition2.await();
            }
            number=3;
            //通知线程A,消费了一个产品
            System.out.println(Thread.currentThread().getName() + "->"+"BBBB" );
            condition3.signal();
        } finally {
            lock.unlock();
        }

    }

    void printC() throws InterruptedException { //消费
        lock.lock();
        try {
            //业务代码
            while (number != 3) { //已经空了
                //等待
                condition3.await();
            }
            number=1;
            //通知线程A,消费了一个产品
            System.out.println(Thread.currentThread().getName() + "->"+"CCCC" );
            condition1.signal();
        } finally {
            lock.unlock();
        }
    }

}