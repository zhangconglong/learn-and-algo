package Juc.锁.悲观锁.Synchronized.对象锁与类锁;


public class 静态方法 {

    //会出现乱序，所有对象竞争锁
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                try {
                    Phone.call_2();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }, "线程" + i).start();
        }
    }
}
