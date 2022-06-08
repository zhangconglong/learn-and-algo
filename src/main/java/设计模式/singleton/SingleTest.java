package 设计模式.singleton;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SingleTest {
    public static void main(String[] args) {
        /*
              int corePoolSize,
              int maximumPoolSize,
              long keepAliveTime,
              TimeUnit unit,
              BlockingQueue<Runnable> workQueue,
              SingletonThreadFactory 自定义线程工厂（方便命名线程）
         */
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 20,  
                1,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(5),
                new SingletonThreadFactory() //指定线程池的名称
        );

        for (int i = 0; i < 10; i++) {
            executor.execute(()->{
                SingleUser user = SingleUser.getInstance();
                System.out.println(Thread.currentThread().getName() + " : " + user.hashCode());
            });
        }
        System.out.println("end----");
    }
}
