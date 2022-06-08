package Juc.me.阻塞队列;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * BlockingQueueDemo
 * author: luyi
 * time: 2022/3/11 22:41
 */
public class BlockingQueueDemo {
    public static void main(String[] args) {
        BlockingQueue blockingQueue = new ArrayBlockingQueue(3);//定长的阻塞队列

        //第一组
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
        System.out.println(blockingQueue.element());

        //System.out.println(blockingQueue.add("d"));

        System.out.println(blockingQueue.remove("a"));//取出指定元素
        System.out.println(blockingQueue.remove());//取出队首元素
    }
}
