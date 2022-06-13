package Juc.异步回调.future.CompletableFuture.任务编排;

import java.util.concurrent.CompletableFuture;

/**
 * 消费 计算结果
 * (1)thenAccept
 */
public class CompletableFutureAPI_消费计算结果 {
    public static void main(String[] args) {

        CompletableFuture.supplyAsync(() -> {
            return 1;
        }).thenApply(f -> {
            return f + 2;
        }).thenApply(f -> {
            return f + 3;
        }).thenAccept(System.out::println);//消费结果，无需return


        System.out.println(CompletableFuture.supplyAsync(
                () -> "resultA").thenRun(() -> {
                }).join()
        );
        System.out.println(CompletableFuture.supplyAsync(() -> "resultA").thenAccept(System.out::println).join());
        System.out.println(CompletableFuture.supplyAsync(() -> "resultA").thenApply(r -> r + "resultB").join());
    }
}
