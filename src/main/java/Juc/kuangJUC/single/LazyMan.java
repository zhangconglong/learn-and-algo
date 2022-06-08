package Juc.kuangJUC.single;

//DCL懒汉
public class LazyMan {
    private LazyMan(){
        System.out.println(Thread.currentThread().getName()+"OK");
    }

    private static LazyMan lazyMan;

    //双重检测锁模式
    public static LazyMan getInstance(){
        if (lazyMan==null){
            synchronized (LazyMan.class){
                if (lazyMan==null){
                    lazyMan = new LazyMan();
                }
            }
        }
        return lazyMan;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                LazyMan.getInstance(); //不是原子性操作
            }, String.valueOf(i)).start();
        }
    }
}