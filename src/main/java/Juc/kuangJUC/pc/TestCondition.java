package Juc.kuangJUC.pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestCondition {
    public static void main(String[] args) {
        Product2 product = new Product2();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    product.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    product.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    product.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    product.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();
    }
}

class Product2{ //商品
    private int number;
    private Lock lock = new ReentrantLock(); //创建重入锁
    Condition condition = lock.newCondition(); //创建监视器

    void increment() throws InterruptedException { //生产
        lock.lock();
        try {
            //业务代码
            while (number != 0){ //还有产品
                //等待
                condition.await();
            }

            number ++;
            //通知线程B,生产了一个产品
            System.out.println(Thread.currentThread().getName()+"生产->"+number);
            condition.signalAll();
        }finally {
            lock.unlock();
        }

    }

    void decrement() throws InterruptedException { //消费
        lock.lock();
        try {
            //业务代码
            while (number == 0){ //已经空了
                //等待
                condition.await();
            }
            number --;
            //通知线程A,消费了一个产品
            System.out.println(Thread.currentThread().getName()+"消费->"+number);
            condition.signalAll();
        }finally {
            lock.unlock();
        }

    }
}