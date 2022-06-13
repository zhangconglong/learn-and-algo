package Juc.forkjoin;

import java.util.concurrent.RecursiveTask;

/*
求和计算
 */
public class ForkJoinDemo extends RecursiveTask<Long> { //计算类必须继承RecursiveTask

    private Long start;
    private Long end;
    private Long temp = 10000L; //临界值

    public ForkJoinDemo(Long start, Long end) {
        this.start = start;
        this.end = end;
    }


    @Override
    protected Long compute() {
        if ((end-start)<temp){ //数值太小不分支合并
            long sum = 0L;
            for (Long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        }else { //分支合并
            long middle = start + (end - start) / 2; //中间值
            /**
             * 拆分任务，将任务压入线程队列
             */
            ForkJoinDemo task1 = new ForkJoinDemo(start, middle);
            task1.join();
            ForkJoinDemo task2 = new ForkJoinDemo(middle+1, end);
            task2.join();

            return task1.join() + task2.join();
        }
    }
}