package Juc.jdk.threadlocal.Demo;

/**
 * 方式一：直接加锁
 */
public class Demo02 {
    //记录当前线程名
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static void main(String[] args) {

        Demo02 demo02 = new Demo02();

        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(() -> {
                //加了锁的代码线程只能排队进行访问，失去了并发性
                //如果不加锁：所有线程可能会共用同一个i
//                synchronized (Demo02.class) {
                demo02.setContent(Thread.currentThread().getName() + "的数据");
                System.out.println("----------------");
                //线程名+线程的数据
                System.out.println(Thread.currentThread().getName() + "-->" + demo02.getContent());
//                }
            });
            System.out.println(i);

            t.setName("线程" + i);
            t.start();
        }

    }
}