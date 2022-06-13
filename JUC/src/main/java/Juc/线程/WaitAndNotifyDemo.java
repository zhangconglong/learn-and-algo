package Juc.线程;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Version: v1.0
 * @ClassName: Mythread
 * @Description：万
 * @Author: zhangconglong on 2021/11/11
 */
class Mythread extends Thread{
    @Override
    public void run() {
        synchronized (this){
            System.out.println("线程：" + this.getName() + " " + "before notify");
            System.out.println("线程：" + this.getName()+ " " + this.getState()); // 输出线程状态
        //    notify();
            System.out.println("线程：" + this.getName() + " " + this.getState()); // 输出线程状态
            System.out.println("线程：" + this.getName() + " " + "after notify");
        }
    }


}

public class WaitAndNotifyDemo{
    public static void main(String[] args) {
        Mythread mythread = new Mythread();
        //Mythread mythread1 = new Mythread();
        //mythread1.start();

        //synchronized (mythread){
        Lock lock = new ReentrantLock();
        lock.lock();
        System.out.println(lock.getClass().getName());
        mythread.start();

        //主线程休眠
        //  Thread.sleep(300);
        System.out.println(Thread.currentThread().getName());
        System.out.println("线程：" + mythread.getName()+ " " +mythread.getState()); // 输出线程状态
        System.out.println("main before wait");
        System.out.println("线程：" + mythread.getName()+ " "+ mythread.getState()); // 输出线程状态
        //mythread.wait();
        System.out.println("111");
        System.out.println("线程：" + mythread.getName()+ " "+ mythread.getState()); // 输出线程状态
        System.out.println("main after wait");

    }
}