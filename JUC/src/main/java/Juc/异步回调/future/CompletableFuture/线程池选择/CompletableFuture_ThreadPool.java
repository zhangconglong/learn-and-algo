package Juc.异步回调.future.CompletableFuture.线程池选择;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 自定义线程池
 */
public class CompletableFuture_ThreadPool {
    public static void main(String[] args) {
        //自定义线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        /*
         * 任务一：pool-1-thread-1
         * 任务二：ForkJoinPool.common-worker-1
         * 任务三：ForkJoinPool.common-worker-1
         * 任务四：ForkJoinPool.common-worker-1
         * 
         * 
         * thenRunAsync 另起线程池
         * thenRun      不另起线程池
         */
        try {
            CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("1号任务" + "\t" + Thread.currentThread().getName());
                return "abcd";
            }, threadPool) //创建任务，并指定线程池
            .thenRunAsync(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("2号任务" + "\t" + Thread.currentThread().getName());
            }).thenRun(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace(); 
                }
                System.out.println("3号任务" + "\t" + Thread.currentThread().getName());
            }).thenRun(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("4号任务" + "\t" + Thread.currentThread().getName());
            });
            
            
            System.out.println(completableFuture.get(2L, TimeUnit.SECONDS));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
