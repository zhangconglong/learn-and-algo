package Juc.me.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * MyTask
 * author: luyi
 * time: 2022/3/11 21:46
 */
public class ForkJoinDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Task task = new Task(1, 100);

        //创建分支合并池
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> forkJoinTask = forkJoinPool.submit(task);//有返回值
        //forkJoinPool.execute(task);//无返回值

        //获取合并结果
        Integer result = forkJoinTask.get();
        System.out.println(result);
        //关闭池
        forkJoinPool.shutdown();
    }
}

class Task extends RecursiveTask<Integer> {
    private static final Integer Value = 10;
    private int begin, end, result;//拆分开始值，结束值，结果

    //有参构造
    public Task(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Integer compute() { //自定义拆分的逻辑
        if (end-begin<=Value) {
            for(int i=begin; i<=end ;i++){
                result = result+i;
            }
        }
        else{//进行拆分
            int middle = (begin+end)/2;
            Task task = new Task(begin, middle);//左边
            Task task2 = new Task(middle+1, end);//右边
            //合并结果
            task.fork();
            task2.fork();
            //拆分结果
            result = task.join()+task2.join();
        }
        return result;
    }
}
