package Juc.锁.悲观锁.Synchronized.面试题_比心.不加锁;

/**
 * synchronized锁方法
 *
 * @author: luyi
 * time: 2022/6/14 17:24
 */
public class 锁方法_2 {

    static B funB(int finalI){
        B b = new B();
        b.setName(String.valueOf(finalI));
        return b;
    }
    
    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            int finalI = i;
            new Thread(()->{

                B b = funB(finalI);
                System.out.println(Thread.currentThread().getName() + " 对象名：" + b.getName());
            }, "线程"+i).start();
        }
    }
}

class B{
    private int id;
    private String name;

    public B() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
