package Juc.线程.创建;

import java.util.concurrent.Callable;

/**
 * 有返回值
 * author: luyi
 * time: 2022/3/11 23:03
 */
public class CallableDemo {
    public static void main(String[] args) throws Exception {
        CallableThread callableThread = new CallableThread();
        Integer result = callableThread.call();
        System.out.println(result);

        //new Thread(new RunnableThread(), "AA").start();
        new RunnableThread().run();
    }
}

class CallableThread implements Callable{
    @Override
    public Integer call() throws Exception {
        return 200;
    }
}

class RunnableThread implements Runnable{

    @Override
    public void run() {
        System.out.println("====");
    }
}
