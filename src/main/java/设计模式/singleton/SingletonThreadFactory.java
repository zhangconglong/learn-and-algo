package 设计模式.singleton;

import java.util.concurrent.ThreadFactory;

/**
 * 用来测试单例
 * 
 * @author zhang
 * time: 2022/6/8 14:30
 */
public class SingletonThreadFactory implements ThreadFactory {

    //自定义线程的名称
    @Override
    public Thread newThread(Runnable r) {
        return new Thread("singleton-pool-");
    }
}
