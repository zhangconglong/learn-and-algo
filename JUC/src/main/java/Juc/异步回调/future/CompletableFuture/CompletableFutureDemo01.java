package Juc.异步回调.future.CompletableFuture;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * CompletableFuture的基础用法
 * author: luyi
 * time: 2022/4/20 13:01
 */
@Slf4j
public class CompletableFutureDemo01 {
    
    //region 创建全局 线程池
    static ThreadPoolExecutor executor = new ThreadPoolExecutor(5,
                                                            50,
                                                            10,//空闲存活时间
                                                            TimeUnit.SECONDS,
                                                            new LinkedBlockingDeque<>(100),//任务队列
                                                            Executors.defaultThreadFactory(),//设置工厂
                                                            new ThreadPoolExecutor.AbortPolicy() //设置拒绝策略
    );
    //endregion

    
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("主线程start...");
        
       /*
        *   构造方法：
        *   （1）runAsync(Runnable runnable)                    无返回值
        *   （2）supplyAsync(Supplier<U> supplier, executor)    有返回值（常用）
        */
        
        /*方式一、runAsync*/
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            System.out.println("任务1，子线程：" + Thread.currentThread().getName());
        }, executor);
        //当线程执行完成后
        future1.whenCompleteAsync((res, exception)->{
            System.out.println("任务1");
            System.out.println(res);
            System.out.println(exception);
        }, executor);



        /*方式二、supplyAsync + 线程池 */
        for (int i = 1; i <= 100; i++) {
            final int temp=i;
            //把任务放入线程池
            CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
                System.out.print("线程" + Thread.currentThread().getName()+"  ");
                test();
                System.out.println(temp);
                return 10;//发生异常，失效
            }, executor);
        }


        /*
        * 方式三：supplyAsync + 异常处理
        * 
        * (1)任务一完成后，whenCompleteAsync再唤任务二
        * (2)任务一出错，exceptionally处理异常
        */
        CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> {
            System.out.println("任务2，子线程：" + Thread.currentThread().getName());
            int i = 10/0;
            return 10;
        }, executor).whenCompleteAsync((res, exception)->{//当线程执行完成后，另起一个线程，获取前一个线程的结果与异常捕获
            System.out.println("====任务2====");
            System.out.println("res = "+res);
            System.out.println("exception2 = "+exception);
        }, executor).exceptionally((e)->{//异常处理
            System.out.println("e2 = "+e);
            return 100;
        });
        
        
        System.out.println("主线程end...");
    }

    //region 业务方法
    public static void test(){
        System.out.print("爬到了: ");
    }
    //endregion
}