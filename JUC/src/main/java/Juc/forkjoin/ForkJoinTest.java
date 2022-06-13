package Juc.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class ForkJoinTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        test1();
       // test2();
        test3();
    }

    //普通程序员
    public static void test1(){
        long sum = 0L;
        long start  = System.currentTimeMillis();


        for (long i = 1L; i <= 10_0000_0000; i++) {
            sum += i;
        }
        long end  = System.currentTimeMillis();
        System.out.println("sum = "+sum+" 时间： "+ (end-start));
    }

    //普通程序员
    public static void test2()  {
        long start  = System.currentTimeMillis();

        ForkJoinPool pool = new ForkJoinPool(); //创建池子
        ForkJoinTask<Long> task = new ForkJoinDemo(0L, 10_0000_0000L);//创建任务
       // ForkJoinTask<Long> submit = pool.submit(task);//放进池子里面
        Long sum = null;
        try {
            sum = task.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("sum = "+sum+"时间： "+ (end-start));
    }

    //Stream 并行流
    public static void test3(){
        long start  = System.currentTimeMillis();

        Long sum = LongStream.rangeClosed(0L, 10_0000_0000L).parallel().reduce(0, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println("sum = "+sum+" 时间： "+ (end-start));
    }
}