package 设计模式.singleton;

public class Singleton {
    
    private static volatile Singleton singleton = null;

    private Singleton() {
    }

    /**
     * 返回一个单例对象
     * @return
     */
    public static Singleton getInstance() {
        //第一次校验singleton是否为空
        if (singleton == null) {
            synchronized (Singleton.class) {
                //第二次校验singleton是否为空
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " : " + Singleton.getInstance().hashCode());
                }
            }).start();
        }
    }
}