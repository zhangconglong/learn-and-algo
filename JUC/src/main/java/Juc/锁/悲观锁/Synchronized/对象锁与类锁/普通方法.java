package Juc.锁.悲观锁.Synchronized.对象锁与类锁;

public class 普通方法 {

    //会出现乱序
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10000; i++) {
//            Thread.sleep(100);
            Phone phone = new Phone();
            new Thread(phone::call_1, "线程"+i).start();
        }
    }
}
