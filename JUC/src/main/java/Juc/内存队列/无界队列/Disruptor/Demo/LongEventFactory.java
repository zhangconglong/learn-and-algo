package Juc.内存队列.无界队列.Disruptor.Demo;

import com.lmax.disruptor.EventFactory;

public class LongEventFactory implements EventFactory {

    @Override
    public Object newInstance() {
        return new LongEvent();
    }
} 
