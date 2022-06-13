package Juc.辅助类.pc;

/**
 * 线程之间的通信问题
 * 线程交替执行
 */
public class TestPC {
    public static void main(String[] args) {
        Product product = new Product();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    product.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    product.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    product.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    product.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();
    }
}

class Product{ //商品
    private int number;

    synchronized void increment() throws InterruptedException { //生产
        while (number != 0){ //还有产品
            //等待
            this.wait();

        }
        number ++;
        //通知线程B,生产了一个产品
        System.out.println(Thread.currentThread().getName()+"生产->"+number);
        this.notifyAll();
    }

    synchronized void decrement() throws InterruptedException { //消费
        while (number == 0){ //已经空了
            //等待
            this.wait();
        }
        number --;
        //通知线程A,消费了一个产品
        System.out.println(Thread.currentThread().getName()+"消费->"+number);
        this.notifyAll();
    }
}