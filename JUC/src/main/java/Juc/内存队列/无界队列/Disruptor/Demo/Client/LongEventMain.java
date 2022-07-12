package Juc.内存队列.无界队列.Disruptor.Demo.Client;

import Juc.内存队列.无界队列.Disruptor.Demo.LongEvent;
import Juc.内存队列.无界队列.Disruptor.Demo.LongEventFactory;
import Juc.内存队列.无界队列.Disruptor.Demo.LongEventHandler;
import Juc.内存队列.无界队列.Disruptor.Demo.LongEventProducer;
import com.lmax.disruptor.dsl.Disruptor;

import java.nio.ByteBuffer;
import java.util.concurrent.Executors;

/**
 * 测试Client
 */
@Deprecated
public class LongEventMain {
    public static void main(String[] args) throws InterruptedException {

        //（1）构建Disruptor
        Disruptor<LongEvent> disruptor = new Disruptor<LongEvent>(
                new LongEventFactory(),            // The factory for the event
                1024,                              // size of the ring buffer, must be power of 2.
                Executors.newCachedThreadPool()    // construct new threads for consumers
        );
        disruptor.handleEventsWith(new LongEventHandler()); // 有事件发布，会回调该接口（消息消费者）
        disruptor.start();

        //（2）构建单个消息生产者
        LongEventProducer producer = new LongEventProducer(disruptor.getRingBuffer());

        ByteBuffer byteBuffer = ByteBuffer.allocate(8);

        for (long l = 0; true; l++) {
            byteBuffer.putLong(0, l);

            //发布事件 
            producer.onData(byteBuffer);
            Thread.sleep(1000);
        }
    }
}