package Juc.内存队列.伪内存共享;

import sun.misc.Contended;

public class FalseSharingDemo_1 implements Runnable {

    public final static int NUM_THREADS = 4;                     //线程数
    public final static long ITERATIONS = 500L * 1000L * 1000L;  //迭代数
    private final int arrayIndex;                                //数组下标

    private static VolatileLong3[] longs = new VolatileLong3[NUM_THREADS];

    static {
        for (int i = 0; i < longs.length; i++) {
            longs[i] = new VolatileLong3();
        }
    }

    public FalseSharingDemo_1(final int arrayIndex) {
        this.arrayIndex = arrayIndex;
    }

    /**
     *
     * @throws InterruptedException
     */
    private static void runTest() throws InterruptedException {
        Thread[] threads = new Thread[NUM_THREADS];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new FalseSharingDemo_1(i));
        }

        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            t.join();
        }
    }

    @Override
    public void run() {
        long i = ITERATIONS + 1;
        while (0 != --i) {
            longs[arrayIndex].value = i;
        }
    }

    public final static class VolatileLong {
        public volatile long value = 0L;
    }

    // long padding避免false sharing
    // 按理说jdk7以后long padding应该被优化掉了，但是从测试结果看padding仍然起作用
    public final static class VolatileLong2 {
        volatile long p0, p1, p2, p3, p4, p5, p6;
        public volatile long value = 0L;
        volatile long q0, q1, q2, q3, q4, q5, q6;
    }


    /**
     * jdk8新特性，Contended注解避免false sharing
     *
     * VM参数: -XX:-RestrictContended
     */
    @Contended
    public final static class VolatileLong3 {
        public volatile long value = 0L;
    }


    public static void main(final String[] args) throws Exception {
        long start = System.nanoTime();
        runTest();
        System.out.println("duration = " + (System.nanoTime() - start));
    }
}