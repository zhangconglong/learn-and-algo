package Juc.内存队列.无界队列.Disruptor.Demo;

import com.lmax.disruptor.EventHandler;

/**
 * 有事件发布，会回调该接口
 */
public class LongEventHandler implements EventHandler<LongEvent> {
    @Override 
    public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception { 
        System.out.println("消费者进行消费："+longEvent.getValue());
    } 
} 
