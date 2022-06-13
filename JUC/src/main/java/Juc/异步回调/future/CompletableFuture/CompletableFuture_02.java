package Juc.异步回调.future.CompletableFuture;

import java.util.concurrent.*;

/**
 * 任务编排
 */
public class CompletableFuture_02 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("主线程start...");


        /*
         * 不指定线程池默认为【ForkJoinPool.commonPool】
         */
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("任务2，子线程：" + Thread.currentThread().getName());
            int i = 10/0;
            return 10;//发生异常，失效
        });

        
        
        //阻塞
        System.out.println("主线程end..."+future2.get());
    }
}