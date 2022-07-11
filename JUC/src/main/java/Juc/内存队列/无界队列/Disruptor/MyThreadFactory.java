package Juc.内存队列.无界队列.Disruptor;

import java.util.concurrent.ThreadFactory;

/**
 * @author zhangconglong
 * @version [1.0.0, 2022/7/11]
 */
public class MyThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        int i = 0;

        return new Thread(r, "生产者线程simpleThread" + i++);
    }
}
