package Juc.内存队列.无界队列.Disruptor.Demo.Client;

import Juc.内存队列.无界队列.Disruptor.Demo.LongEvent;
import Juc.内存队列.无界队列.Disruptor.Demo.LongEventProducer;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

import java.nio.ByteBuffer;
import java.util.concurrent.Executors;

public class LongEventWithMethodRef {
    public static void handleEvent(LongEvent event, long sequence, boolean endOfBatch) {
        System.out.println(event.getValue());
    }

    public static void translate(LongEvent event, long sequence, ByteBuffer buffer) {
        event.setValue(buffer.getLong(0));
    }

    public static void main(String[] args) throws Exception {
        Disruptor<LongEvent> disruptor = new Disruptor<>(
                LongEvent::new,
                1024,                  // ringBufferSize, must be power of 2.
                Executors.newCachedThreadPool()    //construct new threads for consumers
        );
        /*
        在Java 8中方法引用也是一个lambda，lambda引用作为Handler
         */
        disruptor.handleEventsWith(LongEventWithMethodRef::handleEvent);
        disruptor.start();
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

        LongEventProducer producer = new LongEventProducer(ringBuffer);

        ByteBuffer byteBuffer = ByteBuffer.allocate(8);
        for (long l = 0; true; l++) {
            byteBuffer.putLong(0, l);
            ringBuffer.publishEvent(LongEventWithMethodRef::translate, byteBuffer);

            Thread.sleep(1000);
        }
    }
} 
