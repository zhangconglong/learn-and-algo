package Juc.内存队列.无界队列.Disruptor;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import sun.misc.Contended;

/**
 * @Description:
 * @Created on 2019-10-04
 */
public class DisruptorTest {
    public static void main(String[] args) throws Exception {
        //（1）创建disruptor
        Disruptor<Element> disruptor = new Disruptor(
                Element::new,              // RingBuffer生产工厂
                8,                         // RingBuffer数组的大小
                new MyThreadFactory(),     // 生产者的线程工厂
                ProducerType.SINGLE,       // 采用单生产者模式
                new BlockingWaitStrategy() // 阻塞策略
        );

        // 处理Event的handler
        EventHandler<Element> handler = (element, sequence, endOfBatch) -> {
            System.out.println("Element: " + Thread.currentThread().getName() + ": " + element.getValue() + ": " + sequence);
//            Thread.sleep(1000);
        };
        // 设置EventHandler
        disruptor.handleEventsWith(handler);


        //（2）启动disruptor的线程
        /*
        使用disruptor生成10个元素
         */
        disruptor.start();
        for (int i = 0; i < 20; i++) {
            disruptor.publishEvent((element, sequence) -> {
                System.out.println("之前的数据" + element.getValue() + "      当前的sequence" + sequence);
                element.setValue("我是第" + sequence + "个");
            });

        }
    }
}

// 队列中的元素
class Element {
    /*
    JDK8 引入了 @Contented 注解来减少伪共享

    （1）在属性上添加注解
    （2）-XX:-RestrictContended 添加这个参数才能够开启Contented
     */
    @Contended
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}