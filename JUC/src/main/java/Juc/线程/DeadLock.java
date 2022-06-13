package Juc.线程;

//死锁：多个线程互相抱着对方需要的资源，然后形成僵持
public class DeadLock {
    public static void main(String[] args) {
        Makeup makeup = new Makeup(0, "灰姑娘");
        Makeup makeup2 = new Makeup(1, "白雪公主");

        makeup.start();
        makeup2.start();
    }
}

class Lipstick{

}

class Mirror{


}

class Makeup extends Thread {

    //确保资源只有一份,static属于类，不属于对象，因此多个对象都会使用同一个口红
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    int choice;//选择
    String girlName;//使用化妆品的人

    Makeup(int choice, String girlName) {
        this.choice = choice;
        this.girlName = girlName;
    }

    @Override
    public void run() {
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //化妆，互相持有对方的锁
    private void makeup() throws InterruptedException {
        if (choice == 0) {
            synchronized (lipstick) { //获得口红的锁
                System.out.println(this.girlName + "获得口红");
                Thread.sleep(1000);
                synchronized (mirror) {//一秒钟后想获得镜子
                    System.out.println(this.girlName + "获得镜子");
                }
            }
        } else {
            synchronized (mirror) { //获得镜子的锁
                System.out.println(this.girlName + "获得镜子");
                Thread.sleep(2000);
                synchronized (lipstick) {//一秒钟后想获得口红
                    System.out.println(this.girlName + "获得口红");
                }
            }
        }
    }
}