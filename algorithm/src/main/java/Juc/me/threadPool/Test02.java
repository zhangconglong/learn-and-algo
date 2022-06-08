package Juc.me.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Test02
 * author: luyi
 * time: 2022/2/28 13:41
 */
public class Test02 {
    public static void main(String[] args) {
        ExecutorService pool1 = Executors.newSingleThreadExecutor();//线程池只用一个线程
        ExecutorService pool2 = Executors.newFixedThreadPool(5);//固定数量
        ExecutorService pool3 = Executors.newCachedThreadPool();//可伸缩


        for (int i = 0; i<10; i++){
            pool1.execute(()->{
                System.out.println(Thread.currentThread().getName()+" 正在执行");
            });
        }

        pool1.shutdown();
        pool2.shutdown();
        pool3.shutdown();
    }
}
