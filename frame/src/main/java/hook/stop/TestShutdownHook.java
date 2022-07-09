package hook.stop;

public class TestShutdownHook {

    /*
    关闭方式有三种：
        正常关闭：当最后一个非守护线程结束 / 调用了System.exit / 通过其他特定平台关闭（发送SIGINT，SIGTERM信号等）
        强制关闭：调用Runtime.halt方法 / 直接kill JVM进程(发送SIGKILL信号)
        异常关闭：运行中遇到RuntimeException异常等。

     * 触发钩子函数时机
     * （1）最后一个非守护线程结束
     * （2）
     */
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> System.out.println("thread1..."));
        Thread thread2 = new Thread(() -> System.out.println("thread2..."));

        // 定义关闭线程
        Thread shutdownThread = new Thread(() -> System.out.println("shutdownThread..."));

        // jvm关闭的时候先执行该线程钩子
        Runtime.getRuntime().addShutdownHook(shutdownThread);

        thread1.start();
        thread2.start();
        //thread1和thread2执行结束，触发钩子函数
    }
}