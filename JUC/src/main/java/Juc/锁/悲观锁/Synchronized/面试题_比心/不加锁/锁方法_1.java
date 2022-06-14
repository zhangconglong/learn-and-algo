package Juc.锁.悲观锁.Synchronized.面试题_比心.不加锁;

/**
 * synchronized锁方法
 * 
 * @author: luyi
 * time: 2022/6/14 17:24
 */
public class 锁方法_1 {
    
    int funA(int a, int b){
        return a+b;
    }
    
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(()->{
                锁方法_1 锁方法 = new 锁方法_1();
                System.out.println(Thread.currentThread().getName() + " " + 锁方法.funA(1, 1));
            }, "线程"+i).start();
        }
    }
}