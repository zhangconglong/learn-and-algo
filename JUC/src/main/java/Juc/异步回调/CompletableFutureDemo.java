package Juc.异步回调;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 异步回调
 * author: luyi
 * time: 2022/3/11 22:11
 */
public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //异步回调 没有返回值
        CompletableFuture<Void> complete = CompletableFuture.runAsync(()->{
            System.out.println(Thread.currentThread().getName());
        });
        complete.get();

        //异步回调 有返回值supply
        CompletableFuture<Integer> complete2 = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName());
            return 12;
        });
        complete.whenComplete((t, u)->{
            System.out.println("t"+t);//方法的返回值
            System.out.println("u"+u);//异常信息
        }).get();
    }
}
