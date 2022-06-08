package Juc.me.threadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Test
 * author: luyi
 * time: 2022/2/28 13:13
 */
public class Test {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                                                3, 6, 1L,
                                                TimeUnit.SECONDS,
                                                new LinkedBlockingQueue<Runnable>(3),
                                                Executors.defaultThreadFactory(),
                                                new ThreadPoolExecutor.AbortPolicy());//拒绝策略：直接抛异常

        for (int i = 0; i<7; i++){
            threadPoolExecutor.execute(()->{
                System.out.println(Thread.currentThread().getName()+"办理业务");
            });
        }

        threadPoolExecutor.shutdown();
    }
}
