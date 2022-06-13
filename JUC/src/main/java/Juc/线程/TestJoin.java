package Juc.线程;

public class TestJoin implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("线程VIP"+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        //启动线程
        TestJoin join = new TestJoin();
        Thread thread = new Thread(join);
        thread.start();

        //主线程
        for (int i = 0; i < 1000; i++) {

            if (i==100){
                thread.join(); //插队
            }
            System.out.println("主线程"+i);
        }
    }
}