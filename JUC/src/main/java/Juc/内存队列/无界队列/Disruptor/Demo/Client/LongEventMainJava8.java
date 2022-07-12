package Juc.内存队列.无界队列.Disruptor.Demo.Client;

import Juc.内存队列.无界队列.Disruptor.Demo.LongEvent;
import Juc.内存队列.无界队列.Disruptor.Demo.LongEventProducer;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

import java.nio.ByteBuffer;
import java.util.concurrent.Executors;

/**
 * JDK8推荐的构建方式
 */
public class LongEventMainJava8 {

    public static void main(String[] args) throws InterruptedException {

        Disruptor<LongEvent> disruptor = new Disruptor<>(
                LongEvent::new,
                1024,                  // ringBufferSize, must be power of 2.
                Executors.newCachedThreadPool()    //construct new threads for consumers
        );

        /*
         * 用lambda表达式,注册EventHandler和EventProductor
         */
        disruptor.handleEventsWith((event, sequence, endOfBatch) -> System.out.println("消费到事件Event: " + event.getValue()));
        disruptor.start();
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

        LongEventProducer producer = new LongEventProducer(ringBuffer);

        ByteBuffer bb = ByteBuffer.allocate(8);
        for (long l = 0; true; l++) {
            bb.putLong(0, l);

            ringBuffer.publishEvent( (event, sequence, buffer) -> event.setValue(buffer.getLong(0)), bb );
            Thread.sleep(1000);
        }
    }
}