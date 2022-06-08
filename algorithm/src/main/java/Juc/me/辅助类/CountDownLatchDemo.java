package Juc.me.辅助类;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatchDemo
 * author: luyi
 * time: 2022/3/12 21:08
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        //创建
        CountDownLatch countDownLatch = new CountDownLatch(6);

        //6个同学陆续离开教室
        for(int i = 1; i<=6; i++){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"号离开");
                //计数减1
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }

        //阻塞，等所有走了
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"班长离开");
    }
}
