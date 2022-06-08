package Juc.me.辅助类;

import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrirDemo
 * author: luyi
 * time: 2022/3/12 21:16
 */
public class CyclicBarrierDemo {
    //创建固定值
    private static final int NUMBER = 7;

    public static void main(String[] args) {
        //循环栅栏
        CyclicBarrier barrier = new CyclicBarrier(NUMBER, ()->{
            System.out.println("集齐七龙珠，就可召唤神龙");
        });

        //集齐7个才会激活栅栏
        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                try {
                    System.out.println(Thread.currentThread().getName()+"颗");
                    barrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
