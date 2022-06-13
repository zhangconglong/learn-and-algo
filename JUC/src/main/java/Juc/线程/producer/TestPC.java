package Juc.线程.producer;

public class TestPC {
    public static void main(String[] args) {
        SynContainer container = new SynContainer();
        Producer producer = new Producer(container);
        Consumer consumer = new Consumer(container);

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}

class Producer extends Thread{ //生产者

    SynContainer synContainer;

    public Producer(SynContainer synContainer){
        this.synContainer = synContainer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synContainer.push(new Product(i));
            System.out.println("【生产】->第"+i+"个产品");
        }
    }
}

class Consumer extends Thread{ //消费者

    SynContainer synContainer;

    public Consumer(SynContainer synContainer){
        this.synContainer = synContainer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("【消费】->第"+synContainer.pop().id+"个产品");
        }
    }
}

class Product{
    int id;//产品编号

    public Product(int id) {
        this.id = id;
    }
}

class SynContainer{ //缓冲区

    int id;//产品编号
    int count = 0;//容器计数器

    Product[] products = new Product[10];

    //生产者放入产品
    public synchronized void push(Product product){
        //如果容器满了，就等待消费
        while (count == products.length){
            //通知消费者消费，生产者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果没有满，就丢入产品
        products[count] = product;
        count++;
        //可以通知消费者消费了
        this.notify();
    }
    //消费者消费产品
    public synchronized Product pop(){
        //判断能否消费
        while (count == 0){
            //等待生产者生产，消费者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //如果可以消费
        count--;
        Product product = products[count];

        this.notifyAll();
        return product;
    }
}