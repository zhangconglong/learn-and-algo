package Juc.异步回调.future.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 *  获得结果和触发计算
 */
public class CompletableFutureAPI_1 {
    
    private static void group1() throws InterruptedException, ExecutionException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            //暂停几秒钟线程
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "abc";
        });

        /* 一、获取结果 */
        //System.out.println(completableFuture.get());
        //System.out.println(completableFuture.get(2L,TimeUnit.SECONDS));
        //System.out.println(completableFuture.join());

        //暂停几秒钟线程
        //try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
        
        // getNow() 
        //  （1）计算完，返回结果
        //  （2）没计算完，返回valueIfAbsent值
        System.out.println(completableFuture.getNow("xxx"));
        
        
        /* 二、主动触发计算 */
        /*
        complete（）
        返回Boolean值，是否打断get，直接返回
         */
        System.out.println(completableFuture.complete("completeValue") + "  " + completableFuture.get());
    }
}
