package Juc.异步回调.future.CompletableFuture;

import java.util.concurrent.*;

/**
 * 任务编排
 */
public class CompletableFutureDemo02 {

    //创建全局线程池
    static ThreadPoolExecutor executor = new ThreadPoolExecutor(5,
            50,
            10,//空闲存活时间
            TimeUnit.SECONDS,
            new LinkedBlockingDeque<>(100),//任务队列
            Executors.defaultThreadFactory(),//设置工厂
            new ThreadPoolExecutor.AbortPolicy() //设置拒绝策略
    );

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("主线程start...");

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("任务2，子线程：" + Thread.currentThread().getName());
            int i = 10/0;
            return 10;//发生异常，失效
        }, executor);

        //注意：上面不能分开
        //register
        System.out.println("主线程end..."+future2.get());
    }
}