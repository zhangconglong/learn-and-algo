package Juc.threadlocal.Demo;

/**
 * TestThreadLocal
 * author: luyi
 * time: 2022/4/11 12:29
 */
public class TestThreadLocal {
    
    public static void main(String[] args) {
        MyDemo01 demo = new MyDemo01();

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                //变量绑定到当前线程
                demo.setContent(Thread.currentThread().getName() + "的数据");

                System.out.println("----------------");
                System.out.println(Thread.currentThread().getName() + "-->" + demo.getContent());
            });
            thread.setName("线程" + i);
            thread.start();
        }

        //最后一定要移除一次threadLocal
        demo.threadLocal.remove();
    }

}
